## 상속이란?
- 자바의 클래스는 다른 클래스로부터 파생될 수 있음, 따라서 필드와 메소드까지도 상속이 이루어짐
- 새 클래스를 생성하고 싶을 때, 이미 구현된 코드가 포함된 클래스가 있다면 해당 클래스를 상속하여 코드를 재사용할 수 있음

</br>

### 자바 상속의 특징
- Object 클래스를 제외한 모든 클래스는 단 하나의 슈퍼 클래스만 가질 수 있음
- 명시적으로 상속받은 superclass가 없다면, 모든 클래스는 Object 클래스를 상속하고 있음
- subclass는 superclass의 모든 멤버(fields, methods, and nested classes)를 상속 받음
- superclass의 생성자는 멤버가 아니므로 상속되지 않음. 그러나 subclass에서 호출은 가능
- subclass는 상속받은 필드 또는 메소드의 접근제어자(modifier)를 넓은 범위로의 오버라이딩을 허용 
  - protected -> public 가능
  - public -> private 불가능
- subclass에서 할 수 있는 것들
  1. 상속된 필드는 직접 사용 가능함
  2. superclass의 필드와 동일한 이름으로 subclass에 생성이 가능
  3. 새로운 필드를 선언 가능
  4. 상속된 메소드를 그대로 사용 가능
  5. superclass에 있는 메소드를 오버라이딩 할 수 있음
  6. 새로운 메소드를 생성 가능
  7. superclass의 생성자를 호출 가능 (super)
  ~~~java
  class Car{
    public String name;
    public int distance;
    
    public void setDistance(int distance){
        this.distance = distance;
    }
    public void printDistance(){
    }
  }
  
  class K3 extends Car{
    public String name;  // 2
    public String owner; // 3
    
    public K3(){
      super();  // 7
    }
    
    @Override
    public void printDistance(){ // 5
      System.out.println("distance is "+ distance); // 1
    }
    
    public void printOwner(){ // 6
      System.out.println("owner is "+ owner);
    }
  }
  ~~~

</br>

### super 키워드
- 상속으로 superclass의 메소드를 오버라이딩하는 경우, super 키워드를 사용하여 superclass의 메소드를 호출 할 수 있음
- superclass의 필드도 참조 가능함
~~~java
public class Superclass {
    public void printMethod() {
        System.out.println("Printed in Superclass.");
    }
}

public class Subclass extends Superclass {
    // overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();
        System.out.println("Printed in Subclass");
    }
    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();    
        // 결과는 
        // Printed in Superclass.
        // Printed in Subclass
    }
}
~~~
- super() 또는 super(매개변수) 를 사용하여 superclass의 생성자를 호출 할 수 있음
- java 컴파일러는 subclass의 생성자가 명시적으로 superclass의 기본 생성자를 호출하지 않으면, 기본 생성자를 호출하도록 삽입함
  - 만약, superclass의 기본 생성자가 없는 경우 컴파일 에러가 발생함
- subclass의 생성자가 superclass의 생성자를 호출하는 경우를 생성자 체이닝(constructor chaining) 이라고 함

</br>

### 메소드 오버라이딩
- Instance Methods 
  - 동일한 시그니처 및 return type을 가진 instance method를 subclass는 오버라이딩 할 수 있음
  - 메소드를 오버라이딩할 때, @Override 키워드 사용
  - 메소드 오버라이딩 시, subclass에서 return type을 superclass의 return type의 하위 타입으로 재정의 가능 (covariant return type)
  ~~~java
  class Car{
  }

  class K3 extends Car{
  }

  class A {
      public Car check(){
          return new Car();
      }
  }

  class B extends A{
      @Override
      public K3 check() {
          return new K3();
      }
  }
  ~~~
- Static Methods
  - subclass가 superclass의 static method와 동일한 시그니처를 사용하여 method를 정의하면, subclass의 메소드는 superclass의 메소드를 숨김
  - static method를 숨기는 것과 오버라이딩하는 것의 차이는 아래와 같음
    - 오버라이딩된 instance method의 버전은 하위 클래스에 존재
    - 숨겨진 method의 버전은 superclass에서 호출되는 것인지 subclass에서 호출되는 것인지에 따라 다름
  ~~~java
  public class Animal {
      public static void testClassMethod() {
          System.out.println("The static method in Animal");
      }
      public void testInstanceMethod() {
          System.out.println("The instance method in Animal");
      }
  }
  
  public class Cat extends Animal {
      public static void testClassMethod() {
          System.out.println("The static method in Cat");
      }
      public void testInstanceMethod() {
          System.out.println("The instance method in Cat");
      }

      public static void main(String[] args) {
          Cat myCat = new Cat();
          Animal myAnimal = myCat;
          Animal.testClassMethod();
          myAnimal.testInstanceMethod();
          // 결과는
          // The static method in Animal
          // The instance method in Cat
      }
  }
  ~~~
- Interface Methods
  - default 메소드와 abstract method는 instance method 처럼 상속됨
  - 클래스 또는 인터페이스의 동일한 시그니처를 가진 여러개의 default method를 제공하면, compiler는 상속 규칙에 따라 충돌을 해결함
    - instance 메소드는 default 메소드보다 우선
      ~~~java
      public class Horse {
          public String identifyMyself() {
              return "I am a horse.";
          }
      }
      public interface Flyer {
          default public String identifyMyself() {
              return "I am able to fly.";
          }
      }
      public interface Mythical {
          default public String identifyMyself() {
              return "I am a mythical creature.";
          }
      }
      public class Pegasus extends Horse implements Flyer, Mythical {
          public static void main(String... args) {
              Pegasus myApp = new Pegasus();
              System.out.println(myApp.identifyMyself()); // I am a horse.
          }
      }
      ~~~
    - 다른 후보에 의해 오버라이드된 메소드는 무시됨
      ~~~java
      public interface Animal {
          default public String identifyMyself() {
              return "I am an animal.";
          }
      }
      public interface EggLayer extends Animal {
          default public String identifyMyself() {
              return "I am able to lay eggs.";
          }
      }
      public interface FireBreather extends Animal { }
      public class Dragon implements EggLayer, FireBreather {
          public static void main (String... args) {
              Dragon myApp = new Dragon();
              System.out.println(myApp.identifyMyself()); // I am able to lay eggs.
          }
      }
      ~~~
  - 2개 이상의 독립적으로 정의된 default 메소드가 충돌하거나 추상 메소드와 충돌하면 compile 오류가 발생
    - 이런 경우, 명시적으로 supertype 메소드를 오버라이딩해야 함
    - super 키워드를 사용하여 사용할 클래스와 인터페이스에서 default method를 호출할 수 있음
    ~~~java
    public interface OperateCar {
        // ...
        default public int startEngine(EncryptedKey key) {
            // Implementation
        }
    }
    public interface FlyCar {
        // ...
        default public int startEngine(EncryptedKey key) {
            // Implementation
        }
    }
    
    public class FlyingCar implements OperateCar, FlyCar {
        // ...
        public int startEngine(EncryptedKey key) {
            FlyCar.super.startEngine(key);
            OperateCar.super.startEngine(key);
        }
    }
    ~~~
   - interface의 static method는 상속되지 않음
    
    </br>
    
### 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
### 추상 클래스
### final 키워드
### Object 클래스
