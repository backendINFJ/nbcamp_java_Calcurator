package calculator;

import java.util.Scanner;

public class App1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: "); // 첫번째 파라미터
        int num1 = sc.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: "); // 두번째 파라미터
        int num2 = sc.nextInt();

        System.out.print("사칙 연산 기호를 입력하세요 : "); // 연산 파라미터
        char operator = sc.next().charAt(0);

        sc.nextLine(); // 팀원 설명추가

        for ( ; ; ) {

            int result = 0;

            if (operator == '+') {
                result = num1 + num2;  // 덧셈 연산자
                System.out.println("결과 : " + result);
            } else if (operator == '-') {
                result = num1 - num2;  // 뺄셈 연산자
                System.out.println("결과 : " + result);
            } else if (operator == '*') {
                result = num1 * num2; // 곱셈 연산자
                System.out.println("결과 : " + result);
            } else if (operator == '/' && num2 != 0) { // != 는 boolean 타입인데 왜 되는지 ? 여쭤보기 (타입 관련으로 설명)
                result = num1 / num2; // 나눗셈 연산자 여기서 num2는 분모
                System.out.println("결과 : " + result);
            }
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
                String end = sc.nextLine();

            if (end.equals("exit")) {
                break;
            }
        }
    }
}// 오타 입력시 예외처리, while > for 유지보수관점 와일이 좀 더 직관적 , 먼저 선언하지말고
// == -> 연산자 , equals하는 이유는 String은 객체라서 문자열은 이퀄스가 맞음