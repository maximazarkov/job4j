package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                {1}, {2}, {3}, {4}, {5}, {6}, {7}, {0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when1Elements1RowsThen1() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1),
                1
        );
        int[][] expect = {
                {1}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when1Elements2RowsThen2() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1),
                2
        );
        int[][] expect = {
                {1}, {0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2Elements1RowsThen3() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2),
                1
        );
        int[][] expect = {
                {1, 2, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2Elements2RowsThen2() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2),
                2
        );
        int[][] expect = {
                {1}, {2}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2Elements3RowsThen3() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2),
                3
        );
        int[][] expect = {
                {1}, {2}, {0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when3Elements1RowsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3),
                1
        );
        int[][] expect = {
                {1, 2, 3, 0}
        };
        assertThat(result, is(expect));
    }


    @Test
    public void when3Elements3RowsThen3() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3),
                3
        );
        int[][] expect = {
                {1}, {2}, {3}

        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ArrayListIn1ListInteger() {
        ConvertList2Array convertList = new ConvertList2Array();
        List<int[]> list = List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}
        );

        List<Integer> result = convertList.convert(list);

        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }

}