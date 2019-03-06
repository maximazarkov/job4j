package ru.job4j.array;

import org.junit.Test;
import  static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MargeSortArrayTest {

    @Test
    public void whenArr13MargeArr24ThetArr1234() {
        int[] a = new int[] {1, 3};
        int[] b = new int[] {2, 4};
        MargeSortArray mArray = new MargeSortArray();
        int[] expect = {1, 2, 3, 4};
        int[] result = mArray.marge(a, b);
        assertThat(expect, is(result));
    }

    @Test
    public void whenArr135MargeArr24ThetArr12345() {
        int[] a = new int[] {1, 3, 5};
        int[] b = new int[] {2, 4};
        MargeSortArray mArray = new MargeSortArray();
        int[] expect = {1, 2, 3, 4, 5};
        int[] result = mArray.marge(a, b);
        assertThat(expect, is(result));
    }

    @Test
    public void whenArr1256MargeArr34ThetArr123456() {
        int[] a = new int[] {1, 2, 5, 6};
        int[] b = new int[] {3, 4};
        MargeSortArray mArray = new MargeSortArray();
        int[] expect = {1, 2, 3, 4, 5, 6};
        int[] result = mArray.marge(a, b);
        assertThat(expect, is(result));
    }

}
