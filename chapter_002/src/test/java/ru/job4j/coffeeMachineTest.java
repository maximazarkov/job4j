package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.coffeeMachine.Change;

public class coffeeMachineTest {

    @Test
    public void whenCoffeeNx11Pay100ThenChange100MinesNx11(){
        Change ch = new Change();
        int[] change = ch.change(11, 100);
        int[] result = {10, 10, 10, 10, 10, 10, 10, 10, 5, 2, 2};
        assertThat(result, is(change));
        change = ch.change(22, 100);
        result = new int[] {10, 10, 10, 10, 10, 10, 10, 5, 2, 1};
        assertThat(result, is(change));
        change = ch.change(33, 100);
        result = new int[] {10, 10, 10, 10, 10, 10, 5, 2};
        assertThat(result, is(change));
        change = ch.change(44, 100);
        result = new int[] {10, 10, 10, 10, 10, 5, 1};
        assertThat(result, is(change));
        change = ch.change(55, 100);
        result = new int[] {10, 10, 10, 10, 5};
        assertThat(result, is(change));
        change = ch.change(66, 100);
        result = new int[] {10, 10, 10, 2, 2};
        assertThat(result, is(change));
        change = ch.change(77, 100);
        result = new int[] {10, 10, 2, 1};
        assertThat(result, is(change));
        change = ch.change(88, 100);
        result = new int[] {10, 2};
        assertThat(result, is(change));
        change = ch.change(99, 100);
        result = new int[] {1};
        assertThat(result, is(change));

// тест по заданию
        change = ch.change(35, 50);
        result = new int[] {10, 5};
        assertThat(result, is(change));
    }
}
