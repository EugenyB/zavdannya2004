package main;

import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class MainTest {

    Main main;

    @BeforeClass
    public void beforeClass() {
        main = new Main();
    }

    @Test
    public void testCalcF1() {
        double x = 0;
        assertThat(main.calcF(x)).isCloseTo(3.45, Percentage.withPercentage(0.1));
    }

    @Test void testCalcF2() {
        double x = 1;
        assertThat(main.calcF(x)).isCloseTo(14.8, Percentage.withPercentage(0.1));
    }

    @Test
    public void testCalcF3() {
        double x = 3;
        assertThat(main.calcF(x)).isCloseTo(-0.983, Percentage.withPercentage(0.1));
    }
}