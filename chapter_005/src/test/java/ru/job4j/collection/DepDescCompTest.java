package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class DepDescCompTest {
    ArrayList<String> dep = new ArrayList<>();
    @Before
    public void init() {
        dep.add("K1/SK1");
        dep.add("K1/SK2");
        dep.add("K1/SK1/SSK1");
        dep.add("K1/SK1/SSK2");
        dep.add("K2");
        dep.add("K2/SK1/SSK1");
        dep.add("K2/SK1/SSK2");

    }

    @Test
    @Ignore
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
// необходимо пояснение, откуда метод greaterThen()
//        Assert.assertEquals(greaterThan(0), rsl);
    }



    @Test
    @Ignore
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );

// необходимо пояснение, откуда метод lessThen()
//        Assert.assertEquals(lessThan(0), rsl);
    }
}