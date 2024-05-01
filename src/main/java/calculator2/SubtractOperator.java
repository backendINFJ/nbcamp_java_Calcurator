package calculator2;

public class SubtractOperator implements Operation {

    @Override
    public double operate(double num1, double num2) {
        return num1 - num2;
    }
}
