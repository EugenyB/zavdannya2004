package main;

public class Main {

    private double a = 2.3;
    public double calcF(double x) {
        if (x <= 0.3) {
            double cos = Math.cos(x);
            return 1.5 * a * cos * cos;
        }
        if (x <= 2.3) {
            return (x-2)*(x-2)+6*a;
        }
        return 3 * a * Math.tan(x);
    }
}
