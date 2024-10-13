## 객체지향개념 II-1
### 1. 상속
기존의 클래스를 재사용해서 새로운 클래스를 생성하고, **클래스 간의 부모와 자식 관계를 설정**해주는 작업입니다.  
이때, 자손은 부모의 모든 멤버를 상속 받습니다. (단, 생성자와 초기화 블럭 제외)
* 자식클래스 extends 부모클래스

### 1-1. 클래스 간의 관계 유형
상속관계와 포함관계, 두가지가 있습니다.
* 상속관계(inheritance)
  * 공통부분을 부모클래스에서 관리하고, 개별 특성은 자식클래스에서 관리합니다.
  * 부모의 변경사항은 자식에 영향을 미치지만, 자식의 변경사항은 부모에 아무런 영향을 미치지 않습니다.
* 포함관계(composite)
  * 한 클래스의 멤버변수로 다른 클래스를 선언하는 작업입니다.
  * 작은 단위의 클래스를 먼저 만들고, 하나의 커다란 클래스를 만드는 과정입니다.
```java
public class Circle {
    Point point = new Point();
    int r;
}

public class Point {
    int x;
    int y;
}
```
### 1-2. 관계 결정하기
많은 관계를 맺어줄때, 재사용성을 높이고 코드 관리가 수월해야 합니다. 
* 상속 : is a
* 포함 : has a

//TODO : Deck 섞는 예제 이해되지 않음. 코드가 어렵진 않은데 현재 내수준에서 이해하기 힘든 것 같음.


### 1-3. 단일 상속
자바는 기본적으로 단일 상속만 허용합니다. 우선 순위가 높은 클래스를 상속관계로 맵핑해주고, 나머지는 포함관계로 처리합니다.
* 모든 클래스의 조상 클래스는 `Object` 입니다. 조상이 없는 클래스는 자동으로 Object 클래스를 상속 받습니다.
```java
// AS-IS
public class TVCR extends TV, VCR { // 허용 불가
}
// TO-BE
public class TVCR extends TV { // 단일 상속
  VCR vcr = new VCR();
}
// Extends Object
public class TV extends Obeject {
}
```
### 2. 오버라이딩
조상 클래스로부터 상속 받은 메서드를 자식 클래스에서 **변경하는 것(=재정의)**을 말합니다. 만약, 조상 클래스의 메서드를 재정의하지 않는 경우에는 오버라이딩에 속하지 않습니다.
* 오버라이딩 조건(3가지)
  * 선언부가 동일해야 합니다. (메서드 이름, 매개변수, 객체 타입)
  * 접근제어자의 범위가 조상 클래스보다 좁으면 안됩니다. 최소한 같거나 넓어야 합니다. (parent : protected > child : protected or public)
  * 조상클래스의 메서드보다 많은 수의 예외를 선언할 수 없습니다.

### 2-1. super - 멤버변수 접근
* this : 자기자신(현재)을 가리키는 참조변수. 모든 인스턴스 메서드에 지역변수로 존재합니다.
* super : this와 같지만, 조상 클래스를 가리키는 참조변수. 자식 클래스에서의 멤버변수(필드 or 메서드)가 조상 클래스와 같은 경우, 구분하기 위해 사용됩니다.

### 2-2. super() - 생성자 접근
* 모든 클래스의 생성자 첫 줄에는 1) 같은 클래스내 다른 생성자 혹은 2) 조상 클래스의 생성자를 호출해야 합니다.
* 자식 클래스의 인스턴스를 생성하면, 자식 + 조상의 멤버가 합쳐진 하나의 인스턴스가 생성됩니다.
* 자바는 명확한 호출 순서를 필요로 하기 때문에 생성자 내, `단한번의` **this() 또는 super() 호출만** 가능합니다. 
```java
public class Point3D extends Point {
    int z;
    public Point3D() {
//        super(); // 호출시
        this(0, 0, 0);
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
```

### 3. package 와 import
* 패키지
  * 서로 연관된 클래스와 인터페이스의 묶음이며 물리적으로 폴더를 의미합니다. 
  * 클래스의 full name에는 패키지명이 포함됩니다. (ex: java.lang.String)
  * classpath : 클래스파일(.class)를 찾는 경로
* import
  * 패키지명을 생략하며 클래스를 사용할 수 있습니다.
  * import문은 컴파일시에 처리됨으로 프로그램 성능에 아무런 영향을 미치지 못합니다. → **몰랐지만 디테일한 부분**

## 객체지향개념 II-2
### 1. 제어자(modifiers)★
클래스, 변수, 메서드의 선언부에 사용되면서 부가적인 의미를 담고 있습니다.  
크게 두가지로 분류할 수 있습니다.
* 접근제어자 : private < default < protected < public
* 그외 제어자 : static, final, abstract, native, transient, synchronized, volatile, strictfp
 
하나의 대상에 여러개의 제어자를 조합해서 사용할 수 있지만, **접근제어자는 단 하나만 사용 가능합**니다.

### 1-1. static - 공통적인
static 제어자는 `메서드, 멤버변수, 초기화 블럭`에 사용할 수 있습니다.
* 멤버변수 : 클래스가 메모리에 로드될때 생성되어 모든 인스턴스에 공통적으로 사용되는 클래스변수입니다.
* 메서드 : 인스턴스 생성없이, 클래스.메서드명 으로 호출 가능합니다. 이때, static메서드 내에서는 인스턴스 멤버변수들을 직접 사용할 수 없고 매개변수와 같은 지역변수를 사용할 수 있습니다.
* 초기화 블럭 : static 변수의 복잡한 초기화 수행을 처리할 수 있습니다.

### 1-2. final - 변경될 수 없는
final 제어자는 `클래스, 메서드, 멤버변수, 지역변수`에 사용할 수 있습니다.
* 클래스 : 변경되거나 더이상 확장될 수 없으므로, 다른 클래스의 조상클래스가 될 수 없습니다. 대표적인 final 클래스로는 `String`과 `Math`가 있습니다.
* 메서드 : 오버라이딩을 통해 재정의할 수 없는 메서드
* 멤버변수/지역변수 : 값을 변경할 수 없는 상수로서 취급

### 1-3. 생성자를 이용한 final 멤버변수 초기화
일반적으로 final이 붙은 변수는 상수로써 선언과 동시에 초기화를 하지만, 인스턴스마다 고정된 값을 갖는 인스턴스 변수의 경우 생성자를 통해서 초기화를 합니다.  
인스턴스 생성하면서 초기화된 final변수(상수)는 변경이 불가능합니다.
```java
public class Card {
  final int NUMBER;
  final String KIND;
  
  public Card(int number, String kind) {
    this.NUMBER = number;
    this.KIND = kind;
  }

  public Card() {
    this(1,"HEART");
  }
  public static void main(String[] args) {
    Card card = new Card(5,"HEART");
//        card.NUMBER = 20; //Cannot assign a value to final variable 'NUMBER'
  }
}
```

### 1-4. abstract

### 1-5. 

### 1-6. 접근제어자 

### 2. 다형성

## 객체지향개념 II-3
### 1. 추상클래스
### 2. 인터페이스



