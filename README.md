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

### 3. Exception 처리 : try-catch
* try
  * 예외가 발생할 가능성이 있는 코드를 모두 기입합니다.
  * **예외가 발생하면, catch 블럭으로 넘어갑니다**. (이후 코드는 동작하지 않습니다)
  * 예외가 발생하지 않으면, catch 블럭을 거치지 않고 try-catch 루프를 빠져나가 다음 수행을 진행합니다.
* catch
  * 예외 케이스에 따라 일치하는 catch 블럭을 수행합니다.
  * 만약 일치하는 catch 블럭을 찾지 못하면, 예외는 처리되지 못한 겁니다.

### 4. Exception 발생시키기
예외가 발생되면 try-catch 문에서는 catch문으로 error 를 전달하고, 수행됩니다. 
* new : 에러 객체 생성
* throw : 예외 발생
```java
throw new Exception("고의로 예외 발생");
````
