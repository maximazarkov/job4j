package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

public class DepDescCompTest {
    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        Assert.assertTrue(rsl > 0);
    }

    @Test
    public void compare2() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK1",
                "K2/SK1"
        );
        Assert.assertTrue(rsl > 0);
    }

    @Test
    public void compare3() {
        int rsl = new DepDescComp().compare(
                "K2/SK2/SSK1",
                "K2/SK1/SSK2"
        );
        Assert.assertTrue(rsl > 0);
    }


    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        Assert.assertTrue(rsl < 0);
    }
}