package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //проверка сортировки массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        int[] inputArray = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        BubbleSort bSort = new BubbleSort(inputArray);
        inputArray = bSort.bubbleSortIntArray();
        int[] expectArray = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(expectArray, is(inputArray));
    }

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray2() {
        int[] inputArray = {5, 1, 2, 7, 3};
        BubbleSort bSort = new BubbleSort(inputArray);
        int[] expectArray = {1, 2, 3, 5, 7};
        inputArray = bSort.bubbleSortIntArray();
        assertThat(expectArray, is(inputArray));
    }

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray3() {
        int[] inputArray = {5, 1, 2, 7, 3};
        BubbleSort bSort = new BubbleSort(inputArray);
        int[] expectArray = {1, 2, 3, 5, 7};
        inputArray = bSort.bubbleSortIntArray();
        assertThat(inputArray, is(expectArray));
    }

    //пример падающего теста. проверка ,что в принципе тесты работают
    //в тест намеренно внесена ошибка
    /*
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray4() {
        int[] inputArray = {5, 1, 2, 7, 3};
        BubbleSort bSort = new BubbleSort(inputArray);
        // вот здесь последний и предпоследний элемент поменял местами.
        int[] expectArray = {1, 2, 3, 7, 5};
        inputArray = bSort.bubbleSortIntArray();
        assertThat(inputArray, is(expectArray));
    }
    */

}