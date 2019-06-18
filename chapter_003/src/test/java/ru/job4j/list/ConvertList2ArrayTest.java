package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7Elements1RowsThen7() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                1
        );
        int[][] expect = {
                {1, 2, 3, 4, 5, 6, 7, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements2RowsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements3RowsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements4RowsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements5RowsThen10() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                5
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0},
                {0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements6RowsThen12() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                6
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0},
                {0, 0},
                {0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements7RowsThen7() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                7
        );
        int[][] expect = {
                {1}, {2}, {3}, {4}, {5}, {6}, {7}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when7Elements8RowsThen8() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                8
        );
        int[][] expect = {
                {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}
        };
        assertThat(result, is(expect));
    }

}