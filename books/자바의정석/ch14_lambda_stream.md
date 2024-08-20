# [ref](https://github.com/castello/javajungsuk_basic/blob/master/javajungsuk_basic_%EC%9A%94%EC%95%BD%EC%A7%91.pdf)


## 람다(Lambda)

### 1. Lambda Expression
함수 또는 메소드를 간단한 식으로 표현하는 방법을 의미합니다.  

* 배경
  * Java8부터 도입된 것으로, 코드를 간결하고 가독성 있게 작성할 수 있게 도와줍니다. [공식문서](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#approach5)를 참고하여 자세히 다뤄보겠습니다.

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

## 스트림(Stream)


