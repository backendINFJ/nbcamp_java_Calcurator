package calculator2;

import java.util.LinkedList;

public class ArithmeticCalculator {
    LinkedList<Double> allResult = new LinkedList<>(); // 결과의 모든 값

    // Queue<Integer> allResult; // 결과값 리스트
    private char type;
    private double num1;
    private double num2;

    private char operator;
    private double result;
    private Operation operation;

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum1() {
        this.num1 = num1;
    }

    public void setNum12() {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public LinkedList<Double> getAllResult() {
        return allResult;
    }

    public double calculate(double num1, double num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;

        switch (operator) {
            case '+':
                operation = new AddOperator();
                break;
            case '-':
                operation = new SubtractOperator();
                break;
            case '*':
                operation = new MultiplyOperator();
                break;
            case '/':
                operation = new DivideOperator();
                break;
            default:
                System.out.println("잘못된 연산 기호입니다.");
                return 0; // 수정해야함 null로 Integer는 null값 반환 x
        }
        double result = operation.operate(num1, num2);
        allResult.offer(result);
        return result;
    }
}