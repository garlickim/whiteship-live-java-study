### 클래스 정의하는 방법
- 최소한의 클래스 선언 방법
  ~~~java
    class MyClass {
        // field, constructor, and 
        // method declarations
    }
  ~~~
  - 클래스 선언에는 public, private 등과 같은 접근 제어자를 붙일 수 있음
  - 클래스의 첫 글자는 대문자로 시작해야 함
  - 선언하는 클래스의 부모 클래스가 있는 경우 extends 키워드를 사용함
    - 클래스는 하나의 클래스만 확장 가능함
  - 하나의 클래스는 여러개의 인터페이스를 implement 키워드를 사용하여 확장 가능함
  - 클래스 바디는 {} 로 감싸져 있음


</br>

### 객체 만드는 방법(new 키워드 이해하기)
- new operator를 사용하여 객체를 생성함
- new operator 다음에는 생성자 호출이 이어지며, 새 객체를 초기화 함
  ~~~java
    Point point = new Point(10, 20);
  ~~~
- 아래 예와 같이 단순히 참조 변수를 선언하는 것은 객체를 생성하지 않음
  ~~~java
    Point point;
  ~~~
  
- new operator는 새로운 object를 위한 메모리를 할당하고, 그 메모리에 대한 참조를 반환하여 클래스를 인스턴스화 함 (클래스의 인스턴스화 == 객체 생성)

</br>

### 메소드 정의하는 방법

</br>

### 생성자 정의하는 방법

</br>

### this 키워드 이해하기


</br>



