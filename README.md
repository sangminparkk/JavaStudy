# 목표
자바 기본 개념 및 문법 학습을 위한 정리입니다. 제일 중요한 건 프로그래밍 언어에 대한 이해였네요. 뒤늦게 깨달았지만, 이번 기회에 제대로 학습하겠습니다.

## 개발환경
* Windows
* IntelliJ IDEA
* Java 17

## 목차
(업데이트 중)
* 자바의 정석 -- 10/3 > 10/17 (target)
  * 일정이 밀리는 이유 : 집중력 저하 + 생각보다 개념이 부족한 상태로 정리하는데 시간이 많이 소요됨
* Java 8 -- 10/5
* reflection 
* effective java

## 자바의 정석
  * [ch2-variable]()
  * [ch6-OOP](https://github.com/sangminparkk/JavaStudy/tree/ch6)
    * 객체지향 개념I : 클래스와 객체 / 변수와 메서드 / 메서드 오버로딩 / 생성자 / 변수의 초기화
  * [ch7](https://github.com/sangminparkk/JavaStudy/tree/ch7)
    * 객체지향 개념II : 상속 / 오버라이딩 / 제어자 / 다형성 / 추상 클래스 / 인터페이스
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

### 자바8 API로 살펴보는 기본 메소드와 스태틱 메소드
자바8에서 추가된 default method 예시를 살펴보겠습니다. 대표적으로 Iterable, Collection, Comparator 가 있습니다.
* Iterable
  * 자바에서 Collection(List or Set)은 Iterable 인터페이스를 상속 받기 때문에 Collection은 Iterable의 default 메소드를 사용할 수 있습니다.
    * forEach() : elements 를 순회하면서 동작을 수행합니다. 이때, Consumer 라는 함수형 인터페이스를 매개변수로 받으므로 메소드 레퍼런스를 사용할 수 있습니다.  
    * spliterator() : Stream API 핵심 구현 로직으로, 대규모 데이터를 탐색하거나 병렬 처리를 수행하는 데 유용합니다. [예시코드](https://www.baeldung.com/java-spliterator)
      * spliterator 객체를 생성하고, tryAdvance()와 while문을 함께 사용하여 존재하는 요소마다 순차적으로 처리하는 코드입니다. 
```java
List<Article> articles = Stream.generate(() -> new Article("Java"))
        .limit(35000)
        .collect(Collectors.toList());

Spliterator<Article> spliterator = articles.spliterator();
while (spliterator.tryAdvance(article -> article.setName(article.getName().concat("- published by xxx"))));
```
//TODO : spliterator 모든 메소드 공부하기
[reference](https://www.baeldung.com/java-spliterator)

### Stream
데이터 모음이 병렬로 처리되는 과정을 stream 이라고 합니다. `컨베이어 벨트`를 생각하면 이해하기 좋습니다. 
* 데이터를 담고 있는 저장소(컬렉션)를 의미하는게 아니며
* 기존 데이터 소스를 변경하지 않습니다.
* 데이터 처리는 오직 한번만 합니다. 
* 중개 오퍼레이션은 근본적으로 `lazy` 합니다.
  * lazy : 실질적으로 데이터가 요구되는 시점에 맞춰서 연산이 수행됨. 그전까지는 연산 수행 X. 결국 종료 오퍼레이션이 없으면 동작 안한다는 얘기입니다.
* 손쉽게 병렬 처리를 할 수 있습니다.
* `stream pipeline` 
  * 중개 오퍼레이션이 0~여러개 올 수 있고
  * 종료(터미널) 오퍼레이션은 반드시 있어야 됩니다. => 그래야 연산이 수행되기 때문입니다.
* `중개 오퍼레이션`
  * stream 을 리턴합니다.
  * 근본적으로 lazy 합니다.
  * ex) map, filter, limit, sorted,...
* `종료 오퍼레이션`
  * stream이 아닌 다른 타입을 리턴하지 않습니다.
  * ex) collect, count, forEach, min, max,...

### Optional
먼저 Optional API 를 사용하는 이유에 대해 알아보겠습니다.
* `명시적인 의도` : Optional을 리턴하는 메소드는 호출자에게 **값이 없을 수도 있다**는 것을 명확하게 전달합니다. **메소드의 반환값으로 Optional 을 사용하는게 목적**입니다.
* `코드 가독성` : 내장된 메서드를 사용해서 Null check 로직(if (value!=null)) 을 줄여서 값이 없을때 어떻게 처리해야하는지 한줄 표현이 가능합니다.
  
현실적으로 주로 null 을 리턴하거나 null 체크를 까먹은 경우가 많은데요. 이런 경우 **null로부터 안전한 코딩**을 하기 위해 Optional API를 주로 사용합니다.  

메서드 작업 중 특별한 상황에서 값을 제대로 리턴할 수 없는 경우 선택할 수 있는 방법은 아래와 같습니다.
1. 예외 리턴 : 예외가 발생하면 stack trace 가 만들어집니다. 자주 생성하고 처리하게 될수록 CPU와 메모리 등 비용이 발생하는 단점이 있습니다. 가급적으면 예외를 던지지 않는게 중요합니다.
2. null 리턴 : 혼선을 초래할 가능성이 높습니다. 당연히 값이 있을 거라고 생각했지만 NPE가 발생한다면, 메서드를 호출하는 쪽 입장에서는 매번 주의해야 하는 번거로움이 있습니다.
3. Optional 리턴(java8~) : 명시적으로 클라이언트에 빈값이 있다는 걸 알려줍니다.

### Optional 사용시 주의사항
기본적으로 **리턴 타입으로 사용하는 게 권장사항**이고, 그외는 권장하지 않습니다.

* 매개변수 타입 : 비권장사항으로, null이 포함될 가능성이 있어 위험합니다. null로부터 안전하게 코딩하려고 API를 사용하는데 setter를 통해서 null을 넘겨줄 수 있습니다. NPE 발생합니다.
```java
public void setProgress(Optional<Progress> progress) {
    this.progress = progress.get(); // NPE
}
```
* Map의 Key 타입 : Key는 반드시 null 이 되면 안되는게 정의입니다. 
* 인스턴스 필드 타입 : 필드값이 없다면 차라리 validation 처리하는게 좋습니다.
* Collection, Map, Stream Array, Optional은 Opiontal로 감싸지 말 것.
  * 그 자체로 이미 비어있는지를 확인할 수 있는 컨테이너 성격을 띄고 있기 때문입니다.
* primitive 타입은 Optional.of(10) 사용하지 말것.
  * boxing, unboxing 이 자동으로 일어나면서 추가적인 메모리 할당과 성능 비용 문제가 발생할 수 있습니다.
  * primitive 값을 직접 저장하는 OptionalInt/OptionalDouble/OptionalLong 을 사용하는 것을 권장합니다.

자주 사용되는 메서드는 아래와 같습니다.
* `of` : null 이 아닌 데이터만 받고 싶은 경우
* `ofNullable()` : null 일수도 있는 데이터를 감쌀때