## 상속이란?
- 자바의 클래스는 다른 클래스로부터 파생될 수 있음, 따라서 필드와 메소드까지도 상속이 이루어짐
- 새 클래스를 생성하고 싶을 때, 이미 구현된 코드가 포함된 클래스가 있다면 해당 클래스를 상속하여 코드를 재사용할 수 있음

### 자바 상속의 특징
- Object 클래스를 제외한 모든 클래스는 단 하나의 슈퍼 클래스만 가질 수 있음
- 명시적으로 상속받은 superclass가 없다면, 모든 클래스는 Object 클래스를 상속하고 있음
- subclass는 superclass의 모든 멤버(fields, methods, and nested classes)를 상속 받음
- superclass의 생성자는 멤버가 아니므로 상속되지 않음. 그러나 subclass에서 호출은 가능


### super 키워드
### 메소드 오버라이딩
### 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
### 추상 클래스
### final 키워드
### Object 클래스
