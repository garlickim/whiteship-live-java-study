# Mandatory
### 선택문 (jdk8 기준으로 작성함)
- switch statement
- 여러개의 if문으로 구성할 수 있는 구문을 swich-case 문으로 표현
- switch 의 매개변수에 따라 블록이 구성됨
- switch는 기본 primitive type(char, int, short, char)에서 동작하며, primitive를 wrapping한 일부 클래스(Character, Byte, Short, Integer)와 몇가지 클래스(Enum, String)에서도 동작
- 기본 구문
~~~java
switch (조건){
    case 값1:
        코드;
        break;
    case 값2:
        코드;
        break;
    ...
    default:
        코드;
        break;
}
~~~

- if 문으로 표현된 구문을 switch 문으로 표현하면 ..
~~~java
String name = "garlic";

// if statement
if(name.equals("kelly"))
    System.out.println("she is kelly");
else if(name.equals("garlic"))
    System.out.println("she is garlic");
else if(name.equals("sally"))
    System.out.println("she is sally");
else
    System.out.println("none");

// switch statement
switch (name) {
    case "kelly":
        System.out.println("she is kelly");
        break;
    case "garlic":
        System.out.println("she is garlic");
        break;
    case "sally":
        System.out.println("she is sally");
        break;
    default:
        System.out.println("none");
        break;
}
~~~

- break 문
    - switch 구문 사용시 break 사용은 일치하는 case 문을 만나면 코드를 실행하고 switch 문을 종료
    - 일치하는 case문 실행 후 break를 사용하지 않으면, 이후의 case는 값이 일치하지 않아도 실행함!!! (주의해서 사용)
    ~~~java
    List<String> list = new ArrayList<>();
    String name = "garlic";
    
    switch (name) {
        case "kelly":
            list.add("kelly");
        case "garlic":
            list.add("garlic");
        case "sally":
            list.add("sally");
        default:
            break;
    }
    for (String s : list) {
        System.out.println(s); // 결과는 ?? garlic sally
    }
    ~~~

</br>

### 반복문
- for statement

- foreach statement

- while statement

- do-while statement


</br>

# Option
### 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.
~~~java
public class Application {

    private final static String TOKEN = "";

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        try {
            GitHub github = new GitHubBuilder().withOAuthToken(TOKEN).build();

            // Get Repository
            GHRepository repository = github.getRepository("garlickim/whiteship-live-java-study");

            // Get Issues
            List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);

            // Count of attendance by person
            Map<String, Integer> countOfAttendance = calculateCountOfAttendance(issues);

            // Rate of attendance by person
            Map<String, String> rateOfAttendance = calculateRateOfAttendance(countOfAttendance);

            // print
            System.out.println("이름 | 참여율");
            for (String name : rateOfAttendance.keySet()) {
                System.out.println(name + " : " + rateOfAttendance.get(name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Integer> calculateCountOfAttendance(List<GHIssue> issues) {
        Map<String, Integer> countOfAttendance = new HashMap<>();

        try {
            for (GHIssue issue : issues) {
                for (GHIssueComment comment : issue.getComments()) {
                    String name = comment.getUser().getName();

                    Integer count = countOfAttendance.containsKey(name) ? countOfAttendance.get(name) : 0;
                    countOfAttendance.put(name, ++count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOfAttendance;
    }

    private Map<String, String> calculateRateOfAttendance(Map<String, Integer> countOfAttendance) {
        Map<String, String> rateOfAttendance = new HashMap<>();

        for (String name : countOfAttendance.keySet()) {
            Double avg = (countOfAttendance.get(name) / 18.0) * 100;
            rateOfAttendance.put(name, String.format("%.2f", avg));
        }
        return rateOfAttendance;
    }
}
~~~

</br>


### 
