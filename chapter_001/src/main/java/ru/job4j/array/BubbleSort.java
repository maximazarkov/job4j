package ru.job4j.array;


/**
 * BubbleSort.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1
 */
public class BubbleSort {

    private int[] array;
    private int currentLenght;

    /**
     * BubbleSort(int[] array) - конструкторв принимает массив целочисленных примитивов.
     * @param array - массив приметивов.
     * @since 0.1.
     */
    public BubbleSort(int[] array) {
        this.array = array;
        this.currentLenght = array.length - 1;
    }

    /**
     * bubbleSortIntArray() - медод сортировки массива методом перестановки (пузырька), переданного конструктору при создании массива.
     * @return - отсортированный массив целочисленных примитивов.
     * @since 0.1.
     */
    public int[] bubbleSortIntArray() {
        int tmp;
        while (currentLenght > 0) {
            for (int i = 0; i < currentLenght; i++) {
                for (int j = 0; j <= i; j++) {
                    if (array[i] > array[i + 1]) {
                        tmp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmp;
                    }

                }
            }
            currentLenght--;
        }
        return array;
    }
}
