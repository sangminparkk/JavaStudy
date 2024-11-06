## java.lang package

## 목차
1. Object 
2. String
3. StringBuffer
4. Math & Wrapper

### 1. Object
모든 클래스의 최고 조상이며 아래 메서드만 가지고 있습니다. equals/hashCode/toString의 경우 적절하게 오버라이딩해야 합니다.
* toString : 객체 정보를 문자열로 반환
* hashCode : 객체의 해시코드를 반환
* equals : 해당 객체가 비교군과 같은 객체인지 확인 (참조값을 비교합니다)
* getClass : 객체의 클래스 정보를 담고 있는 class 인스턴스를 반환
* clone : 객체 자신의 복사본을 반환 (Cloneable 구현 필요)
* notify : 스레드와 관련된 메서드로, 객체 자신을 사용하려고 기다리는 스레드를 깨웁니다. 
* wait : 다른 스레드가 nofity 호출될때까지, 현 스레드를 지정한 시간만큼 기다리게 합니다.


### 2. String


### 3. StringBuffer


### 4. Math & Wrapper
