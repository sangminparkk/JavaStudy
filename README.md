# [ref](https://github.com/castello/javajungsuk_basic/blob/master/javajungsuk_basic_%EC%9A%94%EC%95%BD%EC%A7%91.pdf)


## 객체지향개념 I-1

## 객체지향개념 I-2

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

