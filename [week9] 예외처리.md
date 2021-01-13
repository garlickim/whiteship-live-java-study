# 학습내용
- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법

<br>

## 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바에서 예외를 처리하는 방법은 여러가지가 있음
- try-catch-finally 구문
  - 예외 발생 가능성이 있는 실행 코드를 try 블록 안에 작성
  - 발생 가능한 예외를 catch의 괄호에 작성
    - 여러개의 catch 블록을 사용할 수 있음. 다만! exception의 범위가 작은->큰 순서로 작성되어야 함
  - 예외 발생시 행동할 코드를 catch 블록안에 작성
  - try-catch 블록과 관계없이 항상 실행되는 코드는 finally 블록에 작성
  ~~~java
  try {
      int number = Integer.parseInt("a");
  } catch (NumberFormatException e) {
      System.out.println("NumberFormatException 발생");
  } catch (Exception e) {
      System.out.println("Exception 발생");
  } finally {
      System.out.println("finally block 안");
  }
  ~~~

## 자바가 제공하는 예외 계층 구조

## Exception과 Error의 차이는?

## RuntimeException과 RE가 아닌 것의 차이는?

## 커스텀한 예외 만드는 방법
