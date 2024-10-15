package me.chandler;

import me.chandler.java8._stream.OnlineClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main( String[] args ) {

        //stream
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("chandler");
        names.add("toby");
        names.add("foo");

        System.out.println("-=====");
        // 병렬처리가 무조건적으로 좋은건 아닙니다. // stream 하면 같은 쓰레드, parallelstream 사용시 다른 스레드 => 나중에 사용하기전에 해보셔야합니다. 성능 측정해서.
        List<String> collect = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        // 실습
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        // Filter : 100점!
        System.out.println("spring으로 시작하는 수업");
        springClasses.stream()  // List<OnlineClass> collection 임으로 class 의 인스턴스가 지나간다.
                .filter(c -> c.getTitle().startsWith("spring"))
                .forEach(s -> System.out.println(s.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
                .filter(((Predicate<OnlineClass>) OnlineClass::isClosed).negate()) // closed 되지 않아야 하는데? > 결과값 반대여야 하니까 Predicate의 negate >> 와... 모든것을 활용함
//                .filter(c -> !c.isClosed())
                .forEach(c -> System.out.println(c.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기"); // map :  input 과 output을 다르게 조작할 수 있습니다 ★★ > 이런 개념을 알고 사용하셔야 합니다.
        List<String> classNames = springClasses.stream()
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        classNames.forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        // 조금 어렵습니다. flat 하게 시킵니다. >> 데이터를 다 꺼내온다고 생각하시면 됩니다.
        List<List<OnlineClass>> keesunEvents = new ArrayList<>(); // list 안에 list 가 있는 것
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        // 스스로 풀어본것
        keesunEvents.stream()
                .map(list -> list.stream()
                        .map(OnlineClass::getTitle)
                        .collect(Collectors.toList())
                ).forEach(System.out::println);

        // flatMap
        keesunEvents.stream()
                .flatMap(Collection::stream) // 헐 나 이것도 몰랐음. collection에서의 default method였음
                .map(oc -> oc.getTitle())
                .forEach(System.out::println);

        // stream의 핵심은 각 오퍼레이션마다 "타입이 무엇인가"를 알아야지만 유연하게 처리할 수 있습니다.

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만"); // OK!
        IntStream.iterate(10, i -> ++i) // i -> i+1
                .skip(10)
                .limit(10)
                .forEach(System.out::println);


        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream()
                .map(oc -> oc.getTitle())
                .anyMatch(s -> s.contains("Test")); // allMatch 가 아니라 anyMatch 였음! 다행히 왜 안되지 하면서 찾다가 결국 성공!
        System.out.println(test); // boolean 이 리턴되기 때문에 터미널 오퍼레이션이죠


        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring")) // 와 순서바꾸면 getTitle이 없어져야함 > 이야..순서도 중요하네. 그래서 "타입"을 알아야 됩니다.
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

    }
}