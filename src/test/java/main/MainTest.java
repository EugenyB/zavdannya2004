package main;

import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    Main main;

    @DataProvider(name = "dataForCalcF")
    public Object[][] dataForCalcF() {
        return new Object[][]{
                {0, 3.45},
                {1, 14.8},
                {3, -0.983}
        };
    }

    @BeforeClass
    public void beforeClass() {
        main = new Main();
    }

    @Test(dataProvider = "dataForCalcF")
    public void testCalcF(double x, double expectedY) {
        assertThat(main.calcF(x)).isCloseTo(expectedY, Percentage.withPercentage(0.1));
    }

    @Test
    public void testCalcF1() {
        double x = 0;
        assertThat(main.calcF(x)).isCloseTo(3.45, Percentage.withPercentage(0.1));
    }

    @Test
    void testCalcF2() {
        double x = 1;
        assertThat(main.calcF(x)).isCloseTo(14.8, Percentage.withPercentage(0.1));
    }

    @Test
    public void testCalcF3() {
        double x = 3;
        assertThat(main.calcF(x)).isCloseTo(-0.983, Percentage.withPercentage(0.1));
    }

    @DataProvider(name = "dataForCalcSteps")
    public Object[][] dataForCalcSteps() {
        return new Object[][] {
                {0, 1, 0.1, 11},
                {-1, 1, 0.1, 21}
        };
    }

    @Test(dataProvider = "dataForCalcSteps")
    public void testCalcSteps(double start, double end, double step, int expected) {
        assertThat(main.calcSteps(start,end,step)).isEqualTo(expected);
    }

    @DataProvider(name = "dataForCreateX")
    public Object[][] dataForCreateX() {
        return new Object[][] {
                {0, 1, 0.1, 0, 0.0},
                {0, 1, 0.1, 5, 0.5},
                {0, 1, 0.1, 10, 1.0},
                {0.2, 2.8, 0.002, 50, 0.3},
                {0.2, 2.8, 0.002, 1050, 2.3},
                {0.2, 2.8, 0.002, 1300, 2.8}
        };
    }

    @Test(dataProvider = "dataForCreateX")
    public void testCreateX(double start, double end, double step, int index, double expected) {
        assertThat(main.createX(start, end, step)[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
    }
    //    @Test
//    public void testCreateX() {
//        double start = 0;
//        double end = 1;
//        double step = 0.1;
//        double[] x = main.createX(start, end, step);
//        double[] expected = {0.0, 0.5, 1.0}; // 0, 5, 10
//        assertThat(x[0]).isCloseTo(expected[0], Percentage.withPercentage(0.1));
//        assertThat(x[5]).isCloseTo(expected[1], Percentage.withPercentage(0.1));
//        assertThat(x[10]).isCloseTo(expected[2], Percentage.withPercentage(0.1));
//    }

    @DataProvider(name = "dataForCreateY")
    public Object[][] dataForCreateY() {
        return new Object[][] {
                {0.2, 2.8, 0.002, 50, 3.1487},
//                {0.2, 2.8, 0.002, 1050, 2.3},
//                {0.2, 2.8, 0.002, 1300, 2.8}
        };
    }

    @Test(dataProvider = "dataForCreateY")
    public void testCreateY(double start, double end, double step, int index, double expected) {
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        System.out.println(">>>> " + x[index]);
        assertThat(y[index]).isCloseTo(expected, Percentage.withPercentage(0.1));
    }


}