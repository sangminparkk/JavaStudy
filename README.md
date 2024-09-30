# [ref](https://github.com/castello/javajungsuk_basic/blob/master/javajungsuk_basic_%EC%9A%94%EC%95%BD%EC%A7%91.pdf)


## 객체지향개념 I-1
### 1. 객체지향 언어란?
* 과학, 군사적 모의실험(simulation)을 위해 컴퓨터를 이용한 가상 세계를 구현하려는 노력으로부터 객체지향 이론이 시작됨

### 2. 특징
* 기존코드를 활용하여 코드 재사용성이 높다
* 코드간의 관계를 맺어줌으로써 코드 관리가 쉬워졌다
* 제어자와 메서드를 이용하여 데이터를 보호하고, 코드 중복을 제거하며 오류를 방지한다. 최종적으로 신뢰성 높은 프로그램 개발이 가능하다

### 3. 클래스와 객체
* 클래스 : 객체를 정의해놓은 일종의 `설계도`이며, 객체를 생성함.
* 객체 : 클래스로부터 생성된 개념이고, 속성과 기능에 따라 하는 역할이 다름.
* 인스턴스 : 객체에 포함되는 개념으로, 클래스와의 `관계`를 표현할 때 사용하는 용어.

### 4. 객체의 특성
객체는 속성과 기능으로 이루어져있습니다.
* `속성` : 필드(field)값을 의미하며 변수로 정의한다
* `기능` : 메서드로 정의한다
```java
public class Remote {
    private int volume; // 속성(필드)
  
    public void volumeUp() { // 기능(메서드) : 볼륨 증가
        this.volume++;
    }
    public void volumeDown() { // 기능(메서드) : 볼륨 감소
        this.volume--;
    }
}
```
### 5. 인스턴스 생성 (new + class name)
* 객체를 다루기 위한 참조변수(remote) 를 선언합니다.
* new + 클래스명 으로 생성된 `인스턴스(메모리주소값)`을 remote 라는 참초변수에 할당하고
* 메모리주소에 dot(.)을 붙여 필드나 메서드에 접근합니다.
```java
public static void main(String[] args) {
    Remote remote = new Remote(); 
    System.out.println(remote); // Remote@4eec7777
    System.out.println(remote.volume); // value = 0

    remote.volumeUp();
    System.out.println(remote.volume); // value = 1
}
```
### 6. 참조변수와 인스턴스 관계
여러개의 참조변수가 하나의 인스턴스를 가리킬 수 있지만, 하나의 참조변수가 여러개의 인스턴스를 가리킬 수 없습니다. 이는 자바의 `참조`와 `메모리 관리` 방식 때문입니다.
* `참조` : 포인터와 유사한 동작을 합니다. 참조변수가 오직 하나의 포인터(메모리주소)만 저장할 수 있습니다.
* `메모리 관리` : 동적으로 객체를 할당하고, 불필요한 객체는 가비지 컬렉션에 의해 자동으로 메모리에서 제거됩니다. 만약 하나의 참조변수가 여러개의 객체를 가리킬 수 있게 된다면, 가비지 컬렉션 과정에서 어떤 객체를 삭제해야하는지 모호함이 발생하여 문제가 발생할 수 있습니다.

### 7. 클래스의 또다른 정의 : 사용자 정의 타입(User-defined type)
필드값으로 다양한 타입을 선언 및 저장할 수 있는 `구조체` 성격을 띄고, 메서드(함수)와 결합됩니다.

---

## 객체지향개념 I-2 : 변수와 메서드
### 1. 변수의 종류와 생성시기
변수의 선언 위치가 변수의 종류와 범위를 결정합니다.  

| 종류  | 선언 위치  | 생성 시기                | 소멸 시기                       | 
|-----|--------|----------------------|-----------------------------|
| 클래스변수 | 클래스 영역 | 클래스가 메모리에 올라갈 때      | 프로그램이 종료될때                  |
| 인스턴스변수 | 클래스 영역 | 인스턴스가 생성될 때          | 참조변수가 더이상의 참조를 하지 않을때(by.GC) |
| 지역변수 | 메소드 영역 | 메소드 내부 변수 선언문 수행시 | 블럭{}을 벗어나 메서드가 종료될때         |

### To the deep
* 인스턴스 변수
  * 반드시 인스턴스가 먼저 생성된 후에, `참조변수.필드명(인스턴스변수)`으로 접근이 가능합니다.
  * 생성 이후, 참조변수가 없을때 가비지 컬렉션에 의해 자동삭제 됩니다.
* 클래스 변수
  * 클래스가 로딩될때 생성되고 프로그램이 종료될때 소멸됩니다.
  * 별도의 인스턴스 생성없이, `클래스이름.필드명(클래스변수)`로 접근이 가능합니다.
  * 같은 클래스의 모든 인스턴스들이 공유하는 변수입니다.
* 지역변수
  * 메서드 내에서 선언 및 생성되고, 메서드 종료와 함께 소멸됩니다. 
  * 조건문이나 반복문 블럭{} 내에서 선언된 지역변수는 해당 블럭을 벗어나면 소멸됩니다.

### 2. 클래스 변수 Vs. 인스턴스 변수
* 인스턴스 변수 : 인스턴스가 생성될때마다 필드는 다른 값을 할당할 수 있습니다.
* 클래스 변수 : 생성된 모든 인스턴스가 하나의 저장공간을 공유함으로, 항상 공통된 값을 가집니다.
```java
public class Card {
  
    String kind;
    int number;
    static int width = 100;
    static int height = 250;

    public static void main(String[] args) {
        Card card1 = new Card();
        card1.kind = "HEART";
        card1.number = 7;
        System.out.println("card1 = " + card1.kind + ", " + card1.number + ", " + card1.width + ", " + card1.height);

        Card card2 = new Card();
        card2.kind = "SPADE";
        card2.number = 2;
        System.out.println("card2 = " + card2.kind + ", " + card2.number + ", " + card2.width + ", " + card2.height);

        System.out.println("== static 변수 선언 ==");
        System.out.println( Card.width + ", " + Card.height);
    }

    //card1 = HEART, 7, 100, 250
    //card2 = SPADE, 2, 100, 250
    //== static 변수 선언 ==
    //100, 250
}
```

### 3. 메서드
* `메서드`란 : 매개변수를 입력받아 프로세스를 처리하고 해당 결과를 리턴해줍니다. (매개변수/리턴이 없을수도 있습니다)
* 장점 및 작성지침
  * 반복되는 코드를 줄이고 코드 관리를 쉽게 해준다
  * 하나의 메서드는 하나의 기능만 수행하도록 작성한다. 그래야 테스트 검증하기도 편합니다.
* 구조
  * 선언부 : 접근제어자 + 리턴 타입 + 메서드 이름(매개변수)
  * 구현부 : 메서드 호출시 수행될 코드

### 3-1. return
메서드가 종료되는 두가지 조건 : 1) 메서드 블럭 끝에 도달했을때  / 2) 블록 중간에 return문을 만났을때  
그리고 반환값이 존재하는 메서드는 모든 조건에 대해서 return을 해줘야합니다.

### 4. JVM(Java Virtual Machine) 의 메모리 구조
자바 프로그램 실행 시, 필요한 데이터 저장.
* Heap : 인스턴스가 생성되는 공간이고, 인스턴스 변수가 heap 영역에 생성.
* Call Stack : 메서드 호출시, 수행에 필요한 메모리공간을 할당받고 메소드 종료시 사용하던 메모리 반환.
* Method Area : 클래스 정보와 클래스 변수가 저장되는 공간
* PC registers : 현재 실행 중인 명령어 주소 저장.
* Native Method Stack : 자바 외의 언어로 작성된 메서드를 실행할 때 사용.

### 5. 매개변수 종류
* 기본형 : read Only
* 참조형 : read & write → 객체의 인스턴스 변수값이 변경됨
```java
    private static void change(int x) {
        x = 1000;
        System.out.println("x = " + x);
    }

    private static void change(Data d) {
        d.x = 1000;
        System.out.println("d.x = " + d.x);
    }
    
```

### 6. 재귀호출(recursive call)

### 4. 메소드 오버로딩
사전적 정의로 `overload`를 구분하자면, 과적하다라는 뜻입니다.  
자바에서는 **클래스 내 같은 이름의 메소드를 여러 개 정의하는 것**을 의미합니다.

* 목적
  * 매개변수는 다르지만 같은 의미의 기능을 수행하도록 설계합니다.

* 오버로딩 조건
  * 메소드 이름이 같아야 합니다.
  * `매개변수`의 개수 또는 타입이 달라야 합니다.
  * 단, 매개변수가 같고 메소드의 리턴타입이 다른 경우 오버로딩이 성립되지 않습니다. 이런 경우 컴파일러는 어떤 메소드를 호출해야하는지 구분할 수 없기 때문에 에러를 발생시킵니다.

* 대표적인 예시
  * println : 매개변수의 타입이 다르지만, 출력 기능을 수행하기 위한 메소드
```java
public class App
{
  public static void main( String[] args )
  {
    System.out.println("string");
    System.out.println(3.14); // double
    System.out.println(3.14f); // float
    System.out.println(3L); // long
    System.out.println('c');
    System.out.println(1);
    System.out.println(true);
    System.out.println(new char[]{'a', 'b', 'c'});
    System.out.println(new Member());
  }
}
```

## 객체지향개념 I-3

