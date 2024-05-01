package calculator2;


import java.util.LinkedList;

public class CircleCalculator {

    LinkedList<Double> allResult = new LinkedList<>(); // ArithmeicCalculator 공통배열
    private final double PI = 3.14;
    private double radius;
    public double circle(double radius) {
        return radius * radius * PI;

    }
}
