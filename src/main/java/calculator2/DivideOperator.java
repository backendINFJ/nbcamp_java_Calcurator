package calculator2;

public class DivideOperator implements Operation {

   private int error; //  = (int) null; // 캐스팅 실패

    @Override
    public double operate(double num1, double num2)  {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("num2가 0이거나 사칙연산의 기호가 올바르지 않습니다");
            return error; // 수정사항 0이 아니라 null
        }
    }
}
