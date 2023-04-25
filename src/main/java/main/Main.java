package main;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private double EPS = 1e-9;

    private double a = 2.3;
    public double calcF(double x) {
        if (x <= 0.3 + EPS) {
            double cos = Math.cos(x);
            return 1.5 * a * cos * cos;
        }
        if (x <= 2.3 + EPS) {
            return (x-2)*(x-2)+6*a;
        }
        return 3 * a * Math.tan(x);
    }

    public int calcSteps(double start, double end, double step) {
        return (int) (Math.round((end - start) / step) + 1);
    }

    public double[] createX(double start, double end, double step) {
        return IntStream.range(0, calcSteps(start, end, step)).mapToDouble(i -> start + i * step).toArray();
//        double[] x = new double[calcSteps(start,end,step)];
//        Arrays.setAll(x, i -> start + i * step);
//        return x;
    }

    public double[] createY(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = calcF(x[i]);
        }
        return y;
    }
}
