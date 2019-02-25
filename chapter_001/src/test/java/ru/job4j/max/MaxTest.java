package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstGreatSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(3, 1, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenSecondGreatFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenThirdGreatFirstAndSecond() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenSummation() {
        Max maxim = new Max();
        int result = maxim.summation(3, 2);
        assertThat(result, is(5));
    }
}
