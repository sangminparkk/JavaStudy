## 예외처리(exception handling)
왜 오류가 발생하고, 
어떤 오류를 어떻게 처리해야하는지

### 1. 프로그램 오류 (2가지)
* `Compile Error` : 컴파일시 발생하는 에러
* `Runtime Error` : 프로그램 실행 중 발생하는 에러
  * `Error` : 코드에 의해 커버 불가능하며 심각한 수준
  * `Exception` : 코드에 의해 커버 가능한 수준

### 2. 예외처리를 반드시 필요한 이유
* Application 실행 중 발생 가능한 예외의 발생에 대비한 코드를 사전에 작성함으로써 안정성 확보
* Application의 비정상적인 종료를 막고, 정상적인 상태를 유지하기 위함

### 3. Exception 처리1 : try-catch-finally
* try
  * 예외가 발생할 가능성이 있는 코드를 모두 기입합니다.
  * **예외가 발생하면, catch 블럭으로 넘어갑니다**. (이후 코드는 동작하지 않습니다)
  * 예외가 발생하지 않으면, catch 블럭을 거치지 않고 try-catch 루프를 빠져나가 다음 수행을 진행합니다.
* catch
  * 예외 케이스에 따라 일치하는 catch 블럭을 수행합니다. 발생한 에러 객체에 대해 참조변로 접근할 수 있습니다. (ex. e.printStackTrace() / e.getMessage())
  * 만약 일치하는 catch 블럭을 찾지 못하면, 예외는 처리되지 못한 겁니다.
  * 추가로, Exception의 경우 예외처리의 최고 조상이므로 가장 마지막 catch문에 처리하는 걸 권장합니다.
* finally
  * 예외 발생 여부와 관계없이, **무조건** 실행되는 블럭입니다. try나 catch블럭에서 return문을 만나도 finally은 수행된다는 점 참고 하시기 바립니다.
    * 예외 발생 : try > catch > finally 
    * 예외 미발생 : try > finally
  * 중복 코드를 제거할 수 있다는 장점이 있습니다.
    * try/catch 문의 마지막 줄에 위치하는 동일한 코드를 finally문으로 옮겨 한번만 호출되게 할 수 있습니다. (종료 메서드 등)

### 4. Exception 발생시키기
예외가 발생되면 try-catch 문에서는 catch문으로 error 를 전달하고, 수행됩니다. 
* new : 에러 객체 생성
* throw : 예외 발생
```java
throw new Exception("고의로 예외 발생");
````
### 5. 계층구조
예외 클래스는 크게 두가지로 나뉩니다.
* RuntimeException classes : 프로그래머의 실수로 발생하는 예외로, 흔히 코드 에러라고 볼 수 있습니다.
* Exception classes : 사용자의 실수와 같은 외적인 요인에 의해서 발생하는 예외로, 반드시 예외처리를 해줘야 합니다.
  * IOException, SQLException, Other Checked Exception 

### 6. Exception 처리2 : Throws
예외처리를 하는게 아니라, 호출한 메서드로 Exception을 전달합니다. 호출한 메서드에서 예외 처리를 해야할 때 사용합니다.  
다시말해, method2()에서 예외가 발생할 수 있음을 알려줍니다.
```java
private static void method2() throws Exception {
    throw new Exception();
}
```  
   

처리 순서에 따른 콘솔창 출력부분이 계속 헷갈리네요. 아래와 같이 정리했습니다.
* 첫번째 출력 : catch문의 print
* 두번째 출력 : 발생한 exception의 stackTrace + 에러 메세지(try문의 string)
```java
public class _Throws_2 {
    public static void main(String[] args) throws Exception {
        method1();
    }

    private static void method1() throws Exception {
        try {
            throw new Exception("예외>>>>"); // 예외를 발생만 시킴. 곧바로 해당 메세지가 출력되지 않습니다.
        } catch (Exception e) {
            System.out.println("method1메서드에서 예외가 처리되었습니다."); //1. 가장 먼저 출력
            e.printStackTrace(); // 2. e.getMessage와 함께 정보를 출력합니다.
        }
    }
}
```

### 7. 예외 되던지기(re-throwing)
예외처리한 후 다시 예외를 던짐으로써, 호출한 메서드로 전달하는 상황을 말합니다. 예외가 발생한 메서드와 호출한 메서드, 양쪽에서 예외처리를 해주면 됩니다.
