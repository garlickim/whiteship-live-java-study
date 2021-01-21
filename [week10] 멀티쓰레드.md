# 학습내용
- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락

</br>

## Thread 클래스와 Runnable 인터페이스
- Thread란?
  - 프로세스가 할당받은 자원을 이용하는 실행 단위
  - 즉, 프로그램이 실행된 상태가 프로세스이며, 프로세스의 실행 단위가 쓰레드
  - 하나의 프로세스는 하나 이상의 쓰레드를 가짐
- 자바에서 쓰레드를 생성하는 방법은 Thread 클래스를 사용, Runnable 인터페이스를 구현하는 방법이 존재
- Thread 클래스
  - Runnable 인터페이스를 상속받아 구현되어 있음
  - Thread 클래스를 상속받아 run 메소드를 오버라이딩하여 사용
  ~~~java
  class Example {
      public static void main(String[] args) throws InterruptedException {
          Thread aThread = new AThread();
          aThread.start();

          Thread bThread = new BThread();
          bThread.start();
      }
  }


  class AThread extends Thread {
      @Override
      public void run() {
          for (int i = 0; i < 5; i++) {
              System.out.println("running AThread : "+i);
          }
      }
  }

  class BThread extends Thread {
      @Override
      public void run() {
          for (int i = 0; i < 5; i++) {
              System.out.println("running BThread : "+i);
          }
      }
  }
  ~~~
  [결과]
  ~~~java
  running AThread : 0
  running BThread : 0
  running AThread : 1
  running BThread : 1
  running AThread : 2
  running BThread : 2
  running AThread : 3
  running BThread : 3
  running AThread : 4
  running BThread : 4
  ~~~
- Runnable Interface
  - 인터페이스이기 때문에, 다중 상속이 가능하며 구현클래스를 통해 구체화 됨
  - Runnable 인터페이스를 상속받아 구현한 객체를 호출하여 쓰레드를 생성
  ~~~java
  
  ~~~
  
