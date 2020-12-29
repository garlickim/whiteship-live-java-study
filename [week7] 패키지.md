## package 키워드
- class,interface 등의 액세스 보호 및 name space 관리를 제공하는 **type**들의 그룹핑
- 위에서 언급한 **type** 이란 class, interface, enum, annotation
- java 기본 클래스는 java.lang 패키지에 있으며, IO 관련 클래스는 java.io 패키지에 존재
- 아래와 같은 이유로 클래스와 인터페이스는 패키지로 묶어야 함
  - 다른 프로그래머가 관련 type을 쉽게 파악할 수 있음
  - 패키지마다 새로운 name space를 가지므로, 동일한 클래스명이 있어도 다른 패키지와 충돌을 일으키지 않음
  - 동일한 패키지 내 액세스를 허용하며, 외부 패키지에 대한 액세스는 제한할 수 있음
- package 이름
  - package 이름은 클래스,인터페이스 이름과 충돌하지 않도록 소문자로 작성
  - 보통 인터넷 도메인 이름을 역순으로 하여 사용 (ex: com.naver)
  - java 언어에 대한 패키지는 java. 또는 javax. 
  - package 이름에 java 예약어가 사용되거나 하는 경우가 있다면 _을 사용하거나 인터넷 도메인이 아닌 다른 규칙으로 사용 될 수도 있음
- package 생성
  - java 파일 맨 위에 선언
  - package 명렁어로 시작하며 그 뒤에 package 이름을 작성
  ~~~java
  package com.naver.dto
  
  public class Student{
  }
  ~~~

</br>

## import 키워드
- 외부에서 package 멤버를 사용하려면 몇가지 방식이 존재
  - full package 명으로 접근
    - 코드 가독성이 떨어짐
     ~~~java
     graphics.Rectangle myRect = new graphics.Rectangle();
     ~~~
  - package member import
    - package 명령문 다음에 import 키워드를 사용하여 특정 멤버를 가져옴
    ~~~java
    package com.naver.dto // 현재 패키지
    import graphics.Rectangle; 
    
    class Shape {
    }
    ~~~
  - 전체 package import
    - 특정 패키지에 포함된 모든 type을 가져오려면 import *(wild card)를 사용
    ~~~java
    import graphics.*; 
    ~~~
  
</br>

## 클래스패스
- 클래스를 찾기위한 경로
- JVM이 클래스 파일을 찾는 기준 결로
- :(콜론)을 사용하여 경로를 구분
- application class loader는 설정된 classpath를 기반으로 지정된 경로에 있는 클래스를 로딩
- 

</br>

## CLASSPATH 환경변수

</br>

## -classpath 옵션

</br>

## 접근지시자
