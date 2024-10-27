package me.chandler;

import me.chandler.java8._stream.OnlineClass;
import me.chandler.java8._stream.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(!present);

        // Optional get > 값이 없을때가 문제 : NoSuchElementException
//        OnlineClass onlineClass = optional.get();
//        System.out.println(onlineClass.getTitle());

        // 값이 있는지 확인하고 꺼내야 함
        if (optional.isPresent()) {
            OnlineClass onlineClass = optional.get();
            System.out.println(onlineClass.getTitle());
        }

        // 위와 같은 번거로운 방법을 안하기 위해서, 메서드를 사용합니다.
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        System.out.println("==");
        OnlineClass onlineClass = optional.orElse(createNewClass()); // instance가 들어가고, 해당 연산은 무조건적으로 실행됨. 값여부에 상관없이. >> 찝찝함
        System.out.println(onlineClass.getTitle());

        System.out.println("==");
        OnlineClass onlineClass1 = optional.orElseGet(App::createNewClass); // orElseGet 은 실행을 안함
        System.out.println(onlineClass1.getTitle());

        System.out.println("=="); // 뭔가를 만들어줄 수 없을때
        OnlineClass onlineClass2 = optional.orElseThrow(IllegalStateException::new); // .NoSuchElementException 자동으로 예외를 던짐
        System.out.println(onlineClass2.getTitle());

        // 어떤 값을 걸러내는 옵션 > empty
        System.out.println("===");
        Optional<OnlineClass> onlineClass3 = optional
                .filter(oc -> oc.getId() > 10);

        System.out.println(onlineClass3.isPresent());

        System.out.println("===Map===");
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        // 굉장히 복잡해짐 > flapMap > 한번 껍질을 알아서 까주고, 나는 한번만 까주면 됨
//        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }

}