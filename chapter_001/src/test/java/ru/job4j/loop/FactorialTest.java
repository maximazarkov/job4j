package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        //тест, проверяющий, что факториал для числа 5 равен 120.
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        int expect = 120;
        assertThat(result, is(expect));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //тест, проверяющий, что факториал для числа 0 равен 1.
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        int expect = 1;
        assertThat(result, is(expect));

    }
}