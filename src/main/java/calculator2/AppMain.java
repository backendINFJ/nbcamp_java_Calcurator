package calculator2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AppMain {  // 계산 메서드

    public static void main(String[] args) {

        CircleCalculator circleCalculator = new CircleCalculator();

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in); // 사


        Queue<Double> allResult = new LinkedList<>();// 용자 입력을 받기 위해 스캐너 선언

        boolean run = true;

        while (run) { // 특정 조건외 무한 반복을 위해 while 선언  / for문 보다 직관적이며 유지보수 관점에도 좋음 (실제로 for문 했다가 리팩토링함)
            System.out.println("사칙연산 -> 1  , 원의 넓이 구하기 -> 2 의도에 맞게 번호를 선택해주세요!");
            int type = sc.nextInt();
            switch (type) {

                case 1:
                    System.out.print("첫 번째 숫자를 입력하세요: ");  // 첫 번째 파라미터
                    double num1 = sc.nextInt();
                    arithmeticCalculator.getNum1();

                    System.out.print("두 번째 숫자를 입력하세요: "); // 두 번째 파라미터
                    double num2 = sc.nextInt();
                    arithmeticCalculator.getNum2();
                    System.out.print("사칙 연산 기호를 입력하세요 : "); // 세 번째 파라미터
                    char operator = sc.next().charAt(0);

                    double result = arithmeticCalculator.calculate(num1, num2, operator);
                    allResult.offer(result);

                    System.out.println("결과: " + result);

                    // 결과값을 allResult에 추가
                    allResult.addAll(arithmeticCalculator.getAllResult());

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력시 삭제)아닐시 문자 아무거나 입력!)");  // 원소삭제 안내문
                    if (sc.next().equals("remove")) {  // 연산값 삭제 메서드 remove 사용,  내로남불 예외처리 허용 메서드
                        allResult.remove();// 최근 연산값 삭제 메서드
                        System.out.println("최근 원소가 삭제되었습니다.");
                    }
                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력시 조회 아닐시 문자 아무거나 입력! )");
                    if (sc.next().equals("inquiry")) { // 연산값 조회 메서드
                        for (Double v : allResult) {
                            System.out.println(v);

                        } // 연산 조회 메서드
                    }

                    System.out.println(); // RUN 표시창 가독성을 위함 공백 추가
                    System.out.println("더 계산하시겠습니까?  종료하려면 exit 입력 아닐시 문자 아무거나 입력!)"); // continue ? exit ?}

                    if (sc.next().equals("exit")) { /* == 를 사용해도 되지 않냐는 질문이 있을 수 있는데 ==는 문자열 타입이 아닌 경우에 사용이 되고
                                          문자열을 일치를 확인할 경우에는 .equals를 사용  */
                        run = false; // break는 가장 가까운 제어문을 종료시키기 때문에 직관적이고
                    } else {
                        continue;
                    }
                    break;

                case 2:
                    System.out.print("원의 반지름(radius)를 입력하세요 : ");  // 원의 반지름
                    double radius = sc.nextDouble(); // private final PI = 3.14 CircleCalculator 지정

                    // 원의 넓이 계싼 메서드
                    System.out.println("원의 넓이 : " + circleCalculator.circle(radius)); // 원 넓이 출력

                    System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력시 삭제)아닐시 문자 아무거나 입력!)");  // 원소삭제 안내문
                    if (sc.next().equals("remove")) {  // 연산값 삭제 메서드 remove 사용,  내로남불 예외처리 허용 메서드
                        allResult.remove(); // 최근 연산값 삭제 메서드
                        System.out.println("최근 원소가 삭제되었습니다.");
                    }
                    System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력시 조회 아닐시 문자 아무거나 입력! )");
                    if (sc.next().equals("inquiry")) { // 연산값 조회 메서드
                        for (Double v : allResult) {
                            System.out.println(v);
                        }
                    }
                    //  ArithmeticCalculator.allResult();

                    System.out.println("더 계산하시겠습니까?  종료하려면 exit 입력 아닐시 문자 아무거나 입력!)"); // continue ? exit ?}

                    if (sc.next().equals("exit")) {
                        run = false; // == 를 사용해도 되지 않냐는 질문이 있을 수 있는데 ==는 문자열 타입이 아닌 경우에 사용이 되고
                        break;              // 문자열을 일치를 확인할 경우에는 .equals를 사용
                    }
                    continue;
                default:
                    System.out.println("프로그램을 종료합니다."); // 안내멘트
                    sc.close(); // 메서드 종료
            }
        }
    }
}


