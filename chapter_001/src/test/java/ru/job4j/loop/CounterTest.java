package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
        Counter count = new Counter();
        int result = count.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}