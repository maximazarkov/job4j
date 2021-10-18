package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.job4j.collection.Departments.fillGaps;

public class DepartmentsTest {
    List<String> depFull = new ArrayList<>();
    List<String> dep = new ArrayList<>();
    @Before
    public void init() {
        dep.add("K1/SK1");
        dep.add("K1/SK1/SSK1");
        dep.add("K1/SK2");
        dep.add("K1/SK1/SSK2");
        dep.add("K2/SK1/SSK1");
        dep.add("K2");
        dep.add("K2/SK1/SSK2");
        depFull.addAll(fillGaps(dep));

    }

    @Test
    public void sortAsc() {
        List<String> expected = new ArrayList<>();
        expected.add("K1");
        expected.add("K1/SK1");
        expected.add("K1/SK1/SSK1");
        expected.add("K1/SK1/SSK2");
        expected.add("K1/SK2");
        expected.add("K2");
        expected.add("K2/SK1");
        expected.add("K2/SK1/SSK1");
        expected.add("K2/SK1/SSK2");
        Departments.sortAsc(depFull);
        Assert.assertEquals(expected, depFull);
    }

    @Test
    public void sortDesc() {
        List<String> expected = new ArrayList<>();
        expected.add("K2");
        expected.add("K2/SK1");
        expected.add("K2/SK1/SSK1");
        expected.add("K2/SK1/SSK2");
        expected.add("K1");
        expected.add("K1/SK1");
        expected.add("K1/SK1/SSK1");
        expected.add("K1/SK1/SSK2");
        expected.add("K1/SK2");

        Departments.sortDesc(depFull);
        Assert.assertEquals(expected, depFull);
    }



    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void whenNonChange() {
        //"K1/SK1"
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        Assert.assertEquals(expect, result);

        //"K1/SK2"
        input = Arrays.asList("k1", "k1/sk2");
        expect = Arrays.asList("k1", "k1/sk2");
        result = Departments.fillGaps(input);
        Assert.assertEquals(expect, result);

        //"K1/SK1/SSK1"
        input = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1");
        expect = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1");
        result = Departments.fillGaps(input);
        Assert.assertEquals(expect, result);
    }
}