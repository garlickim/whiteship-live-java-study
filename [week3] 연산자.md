### 산술 연산자
- 사칙 연산을 다루는 연산자  
  |   산술 연산자    |  	   설명     |
  |---------------|--------------|
  | +             |  더하기 |
  | -             |  빼기  | 
  | *             |  곱하기 |
  | /             |  나누기 |
  | %             |  나머지 |
  ~~~java
  int num1 = 2;
  int num2 = 4;
  
  int add = num1 + num2; // 6
  int subtract = num2 - num1; // 2
  int multiply = num1 * num2; // 8
  int divide = num2 / num1; // 2
  int reminder = num2 % num1; // 0
  
  ~~~
  
</br>


### 비트 연산자
- 비트 단위로 연산하는 연산자  
  |   비트 연산자    |  	   설명     |
  |---------------|--------------|
  | &             |  AND 연산자 : 비트가 모두 1이면 1을 반환 | 
  | \|             |  OR 연산자 : 비트가 1개라도 1이면 1을 반환  | 
  | ^             |  XOR 연산자 : 비트가 서로 다르면 1을 반환 | 
  | ~             |  NOT 연산자 : 비트가 1이면 0을 반환, 0이면 1을 반환 | 
  | <<             |  left shift 연산자 : 선언된 수만큼 비트를 왼쪽으로 이동 | 
  | >>             |  right shift 연산자 : 선언된 수만큼 비트를 오른쪽으로 이동 | 
  | >>>            |  선언된 수만큼 비트를 오른쪽으로 이동 후, 나머지 비트는 전부 0으로 채움 | 
  

- 비트 연산자는 왜 사용할까?
  - 비트를 직접 다루므로 연산 속도가 굉장히 빠름
  - & (AND 연산자)의 경우, 값이 홀수인지 짝수인지 알아보는 예제를 보면
    ~~~java
    for (int i = 1; i < 100000; i++) {
        if (i % 2 == 0)
            System.out.println("짝수");
        else
            System.out.println("홀수");
    }
    // 위의 %2로 나누는 연산보다 아래의 &1 하는 연산이 훨씬 빠르다
    // 가장 오른쪽 피연산자 수가 1이라면 무조건 & 연산시 1이므로 해당 값은 홀수이다
    // 대략 위아래의 속도 차이는 30ms 정도 (10번정도 돌린 평균)
    for (int i = 1; i < 100000; i++) {
        if ((i & 1) == 1)
            System.out.println("홀수");
        else
            System.out.println("짝수");
    }
    ~~~
  
  </br>


### 관계 연산자
- 피연산자간의 관계를 확인하는데 사용되는 연산자
- 비교 연산자로 불리기도 하며, 연산의 결과는 boolean 타입으로 true 또는 false
  |   관계 연산자    |  	   설명     |
  |---------------|--------------|
  | >             |  왼쪽 값이 크면 true, 아니면 false | 
  | <           |  오른쪽 값이 크면 true, 아니면 false  | 
  | >=          |  왼쪽 값이 오른쪽 값보다 크거나 같으면 true, 아니면 false | 
  | <=          |  오른쪽 값이 왼쪽 값보다 크거나 같으면 true, 아니면 false | 
  | ==          |  왼쪽과 오른쪽 값이 같으면 true, 다르면 false | 
  | !=          |  왼쪽과 오른쪽 값이 다르면 true, 같으면 true | 
  ~~~java
  int number = 10;

  if(number > 2) // true
      System.out.println("number는 2보다 크다");
  if(number < 20) // true
      System.out.println("number는 20보다 작다");
  if(number >= 10) // true
      System.out.println("number는 10과 같거나 크다");
  if(number <= 10) // true
      System.out.println("number는 10과 같거나 작다");
  if(number != 11) // true
      System.out.println("number는 11과 다르다");
  ~~~

  </br>
  

### 논리 연산자
- 표현식이 true 인지 false 확인하는데 사용되는 연산자
  |   논리 연산자    |  	   설명     |
  |---------------|--------------|
  | &&             |  논리 AND 연산자 : 표현식이 모두 true 이면 true | 
  | \|\|           |  논리 OR 연산자 : 표현식이 하나라도 true 이면 true  | 
  | !          |  논리 NOT 연산자 : 표현식이 true이면 false 반환 | 
  ~~~java
  System.out.println((6 > 2) && (9 > 3));  // true
  System.out.println((6 > 2) && (9 < 3));  // false

  System.out.println((6 < 2) || (9 > 3));  // true
  System.out.println((6 > 2) || (9 < 3));  // true
  System.out.println((6 < 2) || (9 < 3));  // false

  System.out.println(!(6 == 2));  // true
  System.out.println(!(6 > 2));  // false
  ~~~
  
  </br>
  

### instanceof
- 객체의 타입을 확인하는데 사용되는 연산자
- 어떤 클래스, 서브 클래스 또는 인터페이스에 속해있는지 판별할 때 사용
- null 유형의 객체와 비교하면 무조건 false를 리턴
~~~java
class Kia {
}
class Seltos extends Kia {
}

Seltos seltos = new Seltos();
if(seltos instanceof Kia) // true
    System.out.println("셀토스는 기아차");
    
Seltos seltos = null;    
if(seltos instanceof Kia) // false
    System.out.println("셀토스는 기아차");
~~~

</br>


### assignment(=) operator
- 변수의 값을 할당하는데 사용하는 연산자
- 오른쪽의 값을 왼쪽 변수에 할당
- 오른쪽의 값의 타입과 왼쪽 변수 타입은 같아야 함 (다르면 컴파일 에러)
  |   연산자    |  	   설명     |
  |---------------|--------------|
  | =             | a = 10;  |
  | +=            | a += b; // a = a + b; |
  | -=            | a -= b; // a = a - b; |
  | *=            | a *= b; // a = a * b; |
  | /=            | a /= b; // a = a / b; |
  | %=            | a %= b; // a = a % b; |

~~~java
int a = 10;
int result = 5;

result += a; // result = result + a;
System.out.println(result); // 15

// --

String a = "";
int result = 5;

result += a; // compile error (int 타입의 결과를 String에 할당할 수 없으므로)
~~~

</br>


### 화살표(->) 연산자
- java8 에서 등장한 람다를 지원하기 위해 등장한 연산자
- 매개변수와 구현식 사이의 -> 연산자를 통해 표현됨
- (파라미터) -> {BODY} 의 형태로 구현되며, 람다에 대한 자세한 내용은 15주차에서..
- 메소드를 1개만 가진 인터페이스를 생성, 해당 인터페이스의 실 몸체 구현은 사용하는 곳에서 람다식으로 표현(아래의 예 참고)
~~~java
class Scratch {
    public static void main(String[] args) {
        // 아래의 3가지 Calculator는 모두 같다
        Calculator calculator1 = (int a, int b) -> { return a + b; };
        Calculator calculator2 = (int a, int b) -> a + b;
        Calculator calculator3 = (a, b) -> a + b;

        System.out.println(calculator1.sum(1, 2)); // 3
        System.out.println(calculator2.sum(1, 2)); // 3
        System.out.println(calculator3.sum(1, 2)); // 3
    }
}

interface Calculator {
    public int sum(int number1, int number2);
}
~~~

</br>


### 3항 연산자

### 산자 우선 순위

### (optional) Java 13. switch 연산자
