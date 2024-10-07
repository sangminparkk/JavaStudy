# 목표
자바 기본 개념 및 문법 학습을 위한 정리입니다. 제일 중요한 건 프로그래밍 언어에 대한 이해였네요. 뒤늦게 깨달았지만, 이번 기회에 제대로 학습하겠습니다.

## 개발환경
* Windows
* IntelliJ IDEA
* Java 17

## 목차
(업데이트 중)
* 자바의 정석 -- 10/3
* Java 8 -- 10/5
* reflection 
* effective java

## 자바의 정석
  * [ch2-variable]()
  * [ch6-OOP](https://github.com/sangminparkk/JavaStudy/tree/ch6)
    * 객체지향 개념I : 클래스와 객체 / 변수와 메서드 / 메서드 오버로딩 / 생성자 / 변수의 초기화
  * [ch7](https://github.com/sangminparkk/JavaStudy/tree/ch7)
    * 객체지향 개념II : 
  * [ch14-lambda&stream]()


## Java8
reference : [더 자바, Java8](https://www.inflearn.com/course/the-java-java8?srsltid=AfmBOoqD_eIHjLnm7tknB4hnMzTsVsiGJ2wiYUrfQIT6lhgJZMpxQemN)

### 미리 알아두면 좋은..

**1. 자바8부터 default 메서드가 등장하게 된 이유**
* 하위 호환성 유지
  * 새로운 메서드를 추가할때마다 인터페이스를 구현한 모든 클래스에 새로운 메서드를 구현을 해줘야 합니다. 미구현시 컴파일 에러가 발생함으로 기존 코드를 계속해서 수정해야 합니다.
  * 이러한 문제를 해결하기 위해 등장한게 `default` 메서드입니다. default 메서드는 생성시 바디부를 함께 구현해줌으로써 기존 구현체들이 자동으로 메서드를 상속 받아 처리할 수 있습니다. 최종적으로 기존코드를 수정하지 않고도 새로운 기능을 추가할 수 있습니다.
* 함수형 프로그래밍 지원 및 람다
  * 기존 인터페이스에 default 메서드를 적용하면 유연성과 사용성을 강화시켜 함수형 프로그래밍 스타일 적용이 가능합니다.

같은 맥락으로 Java8부터 static 메서드 역시 인터페이스에 직접 구현할 수 있습니다.

### Functional Interface
목적 : 자바는 객체 지향 설계 목적으로 개발된 언어인만큼 함수에 대한 개념이 없었습니다. 자바 8부터 함수형 프로그래밍 개념이 도입되면서 `함수에 대한 참조`를 지원하기 위해 사용되기 시작했습니다. `Lazy Execution`과 같은 특정 작업 완료 이후에 실행될 함수를 정의하고 필요할 때 호출할 수 있습니다.

* [함수형 인터페이스](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)
  * 일반적으로 추상(abstract) 메서드가 하나만 선언된 인터페이스 (=SAM Interface, Single Abstract Method)
  * `@FunctionalInterface` 애노테이션을 가집니다.

* [람다](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) 
  * 익명 내부 클래스의 코드를 심플하게 만들어 줍니다.

```java
public class Reader {
  public static void main(String[] args) {
      
      // 익명 내부 클래스를 이용한 함수형 인터페이스 구현
    Book book = new Book() {
        @Override
        public void description(String name) {
          System.out.println("책 이름 : " + name);
        }
    };

      //람다 표현식을 사용한 함수형 인터페이스 구현
    Book bookWithLambda = (name) -> System.out.println("책 이름 : " + name);
    
    // output
    book.description("자바8");
  }
}
```
//TODO : 멀티쓰레드(외부 변수 참조시 final) / 익명 내부 클래스

### 자바가 기본으로 제공하는 함수형 인터페이스
[API 레퍼런스](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)  
무슨 인터페이스를 어떻게 활용하는지가 메인입니다. 상세 코드는 **MyFunctionalInterface 클래스** 참조 바랍니다.

| No. | Interface        | Description                                           |
|-----|------------------|-------------------------------------------------------|
| 1   | Function<T,R>    | T타입의 입력값 **하나**를 받아서 R타입을 반환                          |
| 2   | BiFunction<T,U,R> | T와 U타입의 입력값 **두개**를 받아서 R타입을 반환                       |
| 3   | Consumer<T>      | T타입을 입력받지만 아무 것도 반환하지 않음                              |
| 4   | Supplier<T>      | 입력없이 T타입의 값을 반환                                       |
| 5   | Predicate<T>     | T타입 조건(값)을 입력받아 boolean을 반환                           |
| 6   | UnaryOperator<T> | Function의 특수케이스로, T타입의 입력값 하나를 받아서 동일한 타입(T)의 값을 반환   |
| 7   | BinaryOperator<T> | BiFunction의 특수케이스로, T타입의 입력값 두개를 받아서 동일한 타입(T)의 값을 반환 |

### 람다 표현식 - 변수캡처
(인자 리스트) -> {바디}로 표현합니다. 이때 바디부 에서 인자리스트 외 외부 변수를 참조(`변수캡처`)하여 처리하는 경우도 있습니다. 익명내부 클래스와 람다표현식에서 scope 개념도 정리할겸 살펴보겠습니다.  
자바는 **인스턴스 변수나 메서드 파라미터를 사용**하는 것이 일반적이고, 외부 변수를 참조하는 경우가 드뭅니다. 그럼에도 외부 변수를 참조할때 제약사항이 존재합니다. 고민해보는 시간을 갖길 바랍니다.

* 공통점 : 외부변수 참조 가능하지만, 해당 변수는 final이거나 effectively final 상태입니다. (thread-safe)
```java
public class MyLambda {
  public static void main(String[] args) {

    MyLambda myLambda = new MyLambda();
    myLambda.executeTask(); 
    myLambda.printNumber();

  }

  private void executeTask() {
    int count = 10;

    Thread thread = new Thread(new Runnable() { // 익명 클래스
      @Override
      public void run() {
//        count++;  // 컴파일 에러
        System.out.println(count);
      }
    });
    thread.start();
  }

  private void printNumber() {
    int count = 5;

    Consumer<Integer> print = i -> { // 람다표현식
      // count++; // 컴파일 에러
      System.out.println(i + count); 
    };
  }
}
```

* 차이점 : 익명클래스는 shadowing이 가능하지만, 람다표현식은 shadowing 적용이 안됩니다.
  * `shadowing` : 외부 변수와 동일한 이름의 변수가 내부 범위에서 선언되었을때, 외부 변수를 가리는 현상을 의미합니다.
  * 람다표현식은 선언된 위치에서 변수를 캡처하고, 해당 변수를 고정시킵니다. 따라서 변수명이 중복되지 않도록 주의해야 합니다.
```java
    private void executeTask() { // 익명 클래스
        int count = 10;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 5; 
                System.out.println(count); // 10(X) -> 5(O)
            }
        });
        thread.start();
    }

    private void printNumber() { // 람다표현식
        int count = 10;

        Consumer<Integer> print = i -> { // i 대신에 매개변수명을 count 로 해도 컴파일 에러가 발생합니다.
            int count = 10; // 컴파일 에러 발생 > Variable 'count' is already defined in the scope
            System.out.println(i + count);
        };
    }
```
### 메소드 레퍼런스 
람다의 역할이 제한적이라면(=기존의 메소드를 호출하는 경우), 메소드 레퍼런스를 이용해서 코드의 가독성을 높일 수 있습니다. / [java 공식문서](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html) / [예시코드](https://www.baeldung.com/java-method-references)

| No. | Kind of Method Reference                                    | 
|-----|-------------------------------------------------------------|
| 1   | Static method                                               |
| 2   | Instance methods of particular objects                      |
| 3   | Instance methods of an arbitrary object of a particular type |
| 4   | Constructor                                                 |

* Static Method : `객체타입::스태틱 메소드`
  * 문자열을 입력받아 문자열을 출력하는 함수형 인터페이스를 개발한다고 가정하면, 람다표현식 처리할 수 있지만 아래와 같이 객체를 생성하여 스태틱 메소드를 호출하는 방식으로 처리 가능합니다.
```java
public class MyMethodReference {

    private String message;

    public static String send(String message) {
        return "Today : " + message;
    }

    public static void main(String[] args) {
//        UnaryOperator<String> sendMessage = msg -> "Today : " + msg;
        UnaryOperator<String> sendMessage = MyMethodReference::send; // ClassType::Static Method
        System.out.println(sendMessage.apply("we're gonna keep going fast"));
    }
}
```
* Instance methods of particular objects : `객체 레퍼런스::인스턴스 메소드`
  * 이름을 입력받아 이름을 출력하는 코드를 개발한다고 가정하면, 인스턴스 메소드에 접근해야함으로 인스턴스를 먼저 생성하고 
```java
MyMethodReference myMethodReference = new MyMethodReference();
UnaryOperator<String> printName = myMethodReference::name;
```

* Instance methods of an arbitrary object of a particular type : `객체타입::인스턴스 메소드`
```java
List<Integer> numbers = Arrays.asList(41, 21, 31, 5, 4, 24);
//numbers.stream().sorted((a, b) -> a.compareTo(b));
numbers.stream().sorted(Integer::compareTo);
```

* Constructor : `객체타입::new`
  * 기본생성자와 파라미터생성자 모두 똑같이 new 키워드를 통해 생성되지만, 서로 다른 값을 참조하고 있습니다. 
  * Functional Interface에 대해 학습을 하셨으면 차이점이 보이실 겁니다. 
```java
public class MyMethodReference {

  private String name;

  public MyMethodReference() {
  }

  public MyMethodReference(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static void main(String[] args) {
    // 기본생성자
    Supplier<MyMethodReference> constructor = MyMethodReference::new;
    MyMethodReference reference1 = constructor.get();
    System.out.println(reference1.getName()); // null
    
    // 파라미터 생성자
    Function<String, MyMethodReference> parameterConstructor = MyMethodReference::new;
    MyMethodReference reference2 = parameterConstructor.apply("chandler");
    System.out.println(reference2.getName()); // chandler
  }
}
```

### 인터페이스 기본 메소드와 스태틱 메소드
* Default method 를 사용하는 이유는 [공식문서](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)에 의하면, 인터페이스의 파워풀한 확장이 가능하기 때문입니다.
  * 기존 메서드 선언이 아닌, 구현체를 함께 제공하는 방법
  * 기존에 구현된 클래스들에게 영향을 미치지 않으면서도 새로운 기능을 추가할 수 있는 방법
  * 인터페이스 구현체가 재정의할 수 있다.
  * 인터페이스를 상속받은 인터페이스에서 abstract로 변경하여 다시 선언할 수 있다.

* static method
  * 해당 타입과 관련됐으며, 객체 상태와 무관하게 동작하는 기능의 경우 static 메서드로 정의하여 유틸리티 혹은 헬퍼 메서드를 제공할 수 있다. 