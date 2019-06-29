package ru.job4j.department;

import org.junit.Test;
import java.util.ArrayList;
import java.util.TreeSet;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentSortTest {

    @Test
    public void whenSortUp() {
        Department d = new Department();
        ArrayList<String> divisions1 = new ArrayList<String>();
        divisions1.addAll(d.recoverDivision("K1\\SK1"));
        divisions1.addAll(d.recoverDivision("K1\\SK2"));
        divisions1.addAll(d.recoverDivision("K1\\SK1\\SSK1"));
        divisions1.addAll(d.recoverDivision("K1\\SK1\\SSK2"));
        divisions1.addAll(d.recoverDivision("K2"));
        divisions1.addAll(d.recoverDivision("K2\\SK1\\SSK1"));
        divisions1.addAll(d.recoverDivision("K2\\SK1\\SSK2"));

        TreeSet<String> result = new TreeSet<String>();
        result.add("K1");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK2");
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK1");
        result.add("K2\\SK1\\SSK2");

        DepartmentSortUp dsu = new DepartmentSortUp();

        TreeSet<String> divisionsSorting = new TreeSet<String>();
        divisionsSorting = dsu.sortDivisions(divisions1, divisionsSorting);
        assertThat(result, is(divisionsSorting));
    }

    @Test
    public void whenSortDown() {
        Department d = new Department();
        ArrayList<String> divisions1 = new ArrayList<String>();
        divisions1.addAll(d.recoverDivision("K1\\SK1"));
        divisions1.addAll(d.recoverDivision("K1\\SK2"));
        divisions1.addAll(d.recoverDivision("K1\\SK1\\SSK1"));
        divisions1.addAll(d.recoverDivision("K1\\SK1\\SSK2"));
        divisions1.addAll(d.recoverDivision("K2"));
        divisions1.addAll(d.recoverDivision("K2\\SK1\\SSK1"));
        divisions1.addAll(d.recoverDivision("K2\\SK1\\SSK2"));

        TreeSet<String> result = new TreeSet<String>();
        TreeSet<String> divisionsSorting = new TreeSet<String>();
        result.add("K2");
        result.add("K2\\SK1");
        result.add("K2\\SK1\\SSK2");
        result.add("K2\\SK1\\SSK1");
        result.add("K1");
        result.add("K1\\SK2");
        result.add("K1\\SK1");
        result.add("K1\\SK1\\SSK2");
        result.add("K1\\SK1\\SSK1");
        DepartmentSortDown dsd = new DepartmentSortDown();
        divisionsSorting = dsd.sortDivisions(divisions1, divisionsSorting);
        assertThat(result, is(divisionsSorting));
    }

}
