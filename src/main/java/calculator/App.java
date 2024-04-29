package calculator;

import java.util.Scanner;

import java.util.Queue;

import java.util.LinkedList;


public class App {  // 계산 메서드

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위해 스캐너 선언

        Queue<Integer> queue = new LinkedList<>(); // 큐 메서드 선언

        boolean run = true;

        while (run) { // 특정 조건외 무한 반복을 위해 while 선언  / for문 보다 직관적이며 유지보수 관점에도 좋음 (실제로 for문 했다가 리팩토링함)
            System.out.print("첫 번째 숫자를 입력하세요: ");  // 첫 번째 파라미터
            int num1 = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: "); // 두 번째 파라미터
            int num2 = sc.nextInt();

            System.out.print("사칙 연산 기호를 입력하세요 : "); // 세 번째 파라미터
            char operator = sc.next().charAt(0);

            int result = 0;

            if (operator == '+') { // 사칙연산에 따라 반응할 조건문 선언 , // == -> .equals로 리팩토링
                result = num1 + num2; // 덧셈 연산자
            } else if (operator == '-') {
                result = num1 - num2; // 뺼셈 연산자
            } else if (operator == '*') {
                result = num1 * num2; // 곱셈 연산자
            } else if (operator == '/' && num2 != 0) { // 나눗셈 입력시 두 번째 파라미터가 0을 허용하지 않게 설계
                result = num1 / num2; // 나눗셈 연산자
            } else {
                System.out.println("입력하신 값은 사칙연산이 아니거나 두 번째 숫자가 0입니다."); // 오타에 대한 친절한 안내멘트
                continue; // 오타를 입력한 경우 반복문 처음으로 이동시켜주는 친절한 서비스
            }

            System.out.println("결과 : " + result);// 리턴값 저장 즉,result 연산에 대한 반환값 저장
            queue.offer(result); /* 연산값 Queue에 저장, 예외처리를 사용하지않기에 .add보단 .offer를 선택했다 택한 이유는
                예외를 발생시 성능에 영향을 줄 수 있고 예외처리 코드를 따로 작성할 필요가 없으며 false로만 반환받기 때문*/

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력시 삭제)아닐시 문자 아무거나 입력!)");  // 원소삭제 안내문
            if (sc.next().equals("remove")) {  // 원소 삭제 메서드 remove 사용,  내로남불 예외처리 허용 메서드
                queue.poll(); // 최근 연산값 삭제
                System.out.println("최근 원소가 삭제되었습니다.");
            }
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력시 조회 아닐시 문자 아무거나 입력! )");
            if (sc.next().equals("inquiry")) { // 연간값 조회 메서드
                for (Integer i : queue) {
                    System.out.println("저장된 연산결과 : "+ i);
                }
            }

            System.out.println(); // RUN 표시창 가독성을 위함 공백 추가
            System.out.println("더 계산하시겠습니까?  종료하려면 exit 입력 아닐시 문자 아무거나 입력!)"); // continue ? exit ?}

                if (sc.next().equals("exit")) { /* == 를 사용해도 되지 않냐는 질문이 있을 수 있는데 ==는 문자열 타입이 아닌 경우에 사용이 되고
                                          문자열을 일치를 확인할 경우에는 .equals를 사용  */
                    run = false; // break는 가장 가까운 제어문을 종료시키기 때문에 직관적이고
                }
            } // boolean으로 변수 할당하는 거 보다 43번째 줄을  조건문에 넣어서 exit가 아닐 때 까지 선언하는 방식도 있는데 고민중임

        System.out.println("프로그램을 종료합니다."); // 안내멘트
        sc.close(); // 메서드 종료
    }
}


