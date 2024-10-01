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
