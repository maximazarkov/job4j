package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static  org.junit.Assert.assertThat;

/**
 * Test.Fit.
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.1 (23.02.2019).
 */
public class FitTest {

    /**
     * Test.Fit.IdealManWeight
     */
    @Test
    public void whenManHeight180ThenWight92() {
        Fit fit = new Fit();
        double weight = fit.manWaight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Test.Fit.IdealWomanWeight
     */
    @Test
    public void whenWomanHeight170ThenWight69() {
        Fit fit = new Fit();
        double weight = fit.womanWaight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
