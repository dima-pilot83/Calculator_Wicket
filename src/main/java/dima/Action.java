package dima;

/**
 * Created by Dima on 30.04.17.
 */
public class Action {

    protected static double add(double a, double b) {
        return a + b;
    }

    protected static double sub(double a, double b) {
        return a - b;
    }

    protected static double mul(double a, double b) {
        return a * b;
    }

    protected static double div(double a, double b) throws IllegalArgumentException {
        if (b == 0) throw new IllegalArgumentException();
        return a / b;
    }
}
