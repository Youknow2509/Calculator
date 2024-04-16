package src.Model;

public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return Double.MAX_VALUE;
        }
    }
}
