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

//TODO: Deck 섞는 예제 이해되지 않음. 코드가 어렵진 않은데 현재 내수준에서 이해하기 힘든 것 같음.


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
### 1-4. abstract - 추상의, 미완성의
final 제어자는 `클래스, 메서드`에 사용할 수 있습니다.
* 클래스 : 클래스 내 추상 메서드가 선언되었음을 의미합니다
* 메서드 : 구현부는 없고, 선언만 하는 메서드
//TODO: 언제, 어떤 문제를 해결할때 사용하는지 구체적인 예시가 필요함. 생각보다 코드 활용도가 높은 개념임. 추가 공부 필요. Functional Interface의 기초.
* **추가**: 상속을 통해 구현부 작성 및 완성되어야 한다는 의미를 가집니다

### 1-5. 접근제어자(access modifier)
클래스나 멤버에 적용되면서, 외부로부터의 접근을 제한합니다. 접근 제어자를 사용하는 이유는 1) 외부로부터 데이터를 보호하고 2) 내부적으로 사용되는 데이터의 외부 노출을 막기 위함입니다.  
쉽게 말해, 접근제어자를 이용한 캡술화 개념입니다. private으로 선언된 멤버변수에 직접 접근을 막고 메서드로 접근하는 방법이 대표적인 예시가 되겠습니다.  
접근제어자의 종류는 아래와 같습니다.
* private : `같은 클래스` 내에서만 접근 가능
* default : `같은 패키지` 내에서만 접근 가능 
* protected : `같은 패키지` 내에서 또는 `다른 패키지의 하위(자식) 클래스`에서 접근 가능 
* public : 접근 제한이 없음 

### 1-6. 생성자의 접근 제어자
생성자에 접근제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있습니다. `Lazy Initialization` 방식으로, 필요할때 인스턴스를 생성하고 싶다면 아래와 같은 방법으로 풀어낼 수 있습니다.
```java
final class Singleton { // 상속 제한 + 접근제어자 생략되어 default 접근 수준 적용    
    private static Singleton s;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (s == null) {
            s = new Singleton();
        }
        return s;
    }
}
```
### 1-7. 접근제어자 조합 - 전혀 몰랐던 디테일 ★
| 대상   | 사용 가능한 제어자                         |
|:-----|:-----------------------------------|
| 클래스  | public, (default), final, abstract |
| 메서드  | 모든 접근제어자, final, static, abstract  |
| 멤버변수 | 모든 접근제어자, final, static            |
| 지역변수 | final                              |

1. 메서드 : static 과 abstract는 함께 사용할 수 없습니다. static은 구현부가 있는 메서드에만 사용 가능하기 때문입니다.
2. 메서드 : private 과 final을 같이 사용할 필요는 없습니다. private 메서드는 오버라이딩할 수 없고, final 역시 상속을 제한하기 때문입니다. 둘중 하나만 사용해도 충분합니다.
3. 메서드 : abstract 메서드의 접근제어자가 private 일 수 없습니다. abstract 는 상속을 통해 완성되어야 함으로, private을 사용할 경우 자손 클래스에서의 접근을 막기 때문입니다.
4. 클래스 : abstract 와 final 을 동시에 사용할 수 없습니다. final은 상속을 제한함으로써 확장할 수 없지만, abstract는 상속을 통해서 완성되어야 하는 의미입니다. 서로 모순되기 때문입니다.

### 2. 다형성(polymorphism)
여러 가지 형태를 가질 수 있는 개념을 의미합니다. 하나의 참조변수로 **여러 타입의 객체를 참조**할 수 있습니다.  
부모 타입의 참조변수로 자식 타입의 인스턴스를 다룰 수 있습니다.
```java
// parent - Tv, child - CaptionTv
CaptionTv captionTv = new CaptionTv();
Tv tv = new CaptionTv();
```
### 2-1. 형변환(casting)
* Up-casting : 자식타입 → 부모타입을 참조하며, 형변환 생략이 가능합니다.
* Down-casting : 부모타입 → 자식타입을 참조하며, 형변환 생략이 불가능합니다.

### 2-2. instanceOf 연산자
참조변수가 참조하는 인스턴스의 실제 타입을 체크하는데 사용됩니다. 결과값이 true면, 해당 타입으로 형변환이 가능합니다.
````java
CaptionTv captionTv = new CaptionTv();
if (captionTv instanceof CaptionTv) { // true
    System.out.println("CaptionTv의 인스턴스 입니다.");
}
if (captionTv instanceof Tv) { // true
    System.out.println("Tv의 인스턴스 입니다.");
}
if (captionTv instanceof Object) { // true
    System.out.println("Object의 인스턴스 입니다.");
}
````

### 2-3. 참조변수와 인스턴스 변수의 연결 → 몰랐던 내용 
부모클래스와 자식클래스간에, 멤버변수 혹은 메서드가 중복정의된 경우 아래 원칙에 따라 동작합니다.
* 멤버변수 : 레퍼런스타입에 영향을 받습니다.
* 메서드 : 레퍼런스타입에 영향을 받지 않습니다.
```java
Tv tv = new CaptionTv(); // parent
CaptionTv captionTv = new CaptionTv(); // child

System.out.println(tv.channel); // 30 - parent
tv.channelUp(); // child
System.out.println(captionTv.channel); // 50 - child
captionTv.channelUp(); // child
```

## 객체지향개념 II-3
### 1. 추상클래스(abstract class)
확장을 통해 자식클래스마다 다르게 구현될 것으로 예상되는 경우에 사용을 하고, 구현부가 없고 선언부만 있는 추상메서드를 포함하고 있는 클래스입니다.  
결과적으로 여러 클래스에서 공통적으로 사용될 수 있는 추상클래스를 바로 작성하거나, **기존 클래스의 공통 부분을 뽑아서 추상클래스를 만듭니다.**
* 일반메서드가 추상메서드를 호출할 수 있습니다.
* 완성된 클래스가 아님으로 인스턴스를 생성할 수 없습니다.
* 상속을 통해 완성되는 클래스인 만큼, 다른 클래스를 작성하는데 도움을 줄 목적으로 작성합니다.

### 1-1. 추상메서드
* 선언부만 있기 때문에 `주석`을 통해서 어떤 기능을 수행할 목적으로 작성하였는지 설명해야 합니다.
* 추상 클래스를 상속받는 자식클래스에서 구현부를 완성시켜야 합니다.

### 2. 인터페이스(interface) ★
개인적으로 공부할때 추상클래스와 어떤 차이가 있는지 몰랐는데요. 이번에 제대로 파악해보겠습니다.
* 추상클래스보다 추상화 정도가 높습니다.
* 실제로 구현된 게 없는, 기본 설계도일 뿐입니다. 
* 인스턴스를 생성할 수 없고, 확장을 목적으로 사용됩니다.
* 정해진 규칙에 맞게 구현하도록 `표준 제시`하는데 사용됩니다.
* `추상메서드`와 `상수`만을 멤버로 가질 수 있습니다.
  * 상수 : public + static + final => static이 붙는 이유 : 모든 인스턴스에서 동일한 상수로 참조할 수 있고 메모리 절약도 되기 때문입니다. 
  * 추상메서드 : public + abstract

### 2-1. 인터페이스의 다중상속
* 클래스와 달리, 다중상속이 가능하고 상속시 default 메서드로 구현부를 작성해야 합니다.
* Object 클래스와 같은 최고 조상은 없습니다.
```java
public interface Fightable extends Movable, Attacktable {
}
```

### 2-2. 인터페이스의 구현
* extends 대신 `implements` 사용합니다.
* 인터페이스를 구현하는 클래스는 추상메서드를 완성해야 합니다. 즉, 구현부 작성이 필요합니다.
* 상속과 구현이 동시에 가능합니다. (= 클래스A extends 클래스B implements 인터페이스C)

### 2-2. 인터페이스를 이용한 다형성
* 인스턴스 생성시 인터페이스 타입을 참조할 수 있습니다.
* **인터페이스를 매개변수 타입으로 지정**할 수 있습니다. => 가장 큰 장점으로 생각됩니다.
* 인터페이스를 메서드의 리턴타입으로 지정할 수 있습니다. => lambda expression 으로 확장됩니다.

### 2-3. 인터페이스 장점 ★★
* 개발시간 단축 
  * 인터페이스에서 선언부를 체크하고, 메서드를 호출하는 쪽에서는 구현부를 개발할 수 있습니다.
  * 인터페이스를 구현하는 클래스가 작성될때까지 기다리지 않고, 다른 작업들을 병행할 수 있습니다.
* 표준화 가능
  * 프로젝트의 기본이 되는 틀(인터페이스)을 작성한 다음에 개발자들은 해당 스펙에 따라 **일관되고 정형화된 프로그램 개발**이 가능합니다.
* 독립적인 프로그래밍 가능
  * **선언부와 구현부를 분리**시킬 수 있습니다.
  * 클래스와 클래스간의 직접적인 관계를 인터페이스를 설정함으로써 간접관계로 변경할 수 있고, 결국 클래스간의 영향을 미치지 않는 독립적인 프로그래밍이 가능합니다.
* 서로 관계없는 클래스들간 관계 설정 가능
  * 서로 상속관계도 아니고, 같은 조상클래스를 가지고 있는 않는 클래스들에게 공통의 인터페이스를 구현하도록 함으로써 관계를 맺어줄 수 있음

### 2-4. 인터페이스 이해
* 두 객체 간 연결을 돕는 중간역할(**A - I - B**)을 하면서, 간접적인 관계로 변경
* 설계(선언)와 구현 분리
  * `User` : 클래스를 사용하는 측 (=메서드 호출)
  * `Provider` : 클래스를 제공하는 측(=선언부)

### 2-5. default 메서드
추상메서드 작성시, 인터페이스를 구현한 모든 클래스에 해당 메서드를 구현해야줘야 합니다. 유지보수에 좋지 못합니다.  
이런 문제를 해결하고자 나온 개념이 `default 메서드` 입니다.
* default 메서드 : 선언과 동시에 구현을 함께 해주는 메서드이며, 자동으로 상속됩니다.  
```java
public interface MyInterface {
    void method(); // 구현되는 클래스에 overriding 필요
    void newMethod(); // 구현되는 클래스에 overriding 필요
    default void new2Method() { // 자동 상속
        System.out.println("구현부");
    }
}
```

주의사항
* 디폴트 메서드와 부모클래스로부터 상속 받은 메서드의 이름이 같은 경우, 디폴트 메서드는 무시됩니다.
* 여러 인터페이스 간 디폴트 메서드끼리 충돌이 일어날 경우, 개발자는 어떤 인터페이스를 사용할 것인지 반드시 명시해줘야 합니다.

 

### 3. 내부 클래스(inner class)



