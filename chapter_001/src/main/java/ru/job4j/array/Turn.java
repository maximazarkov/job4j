package ru.job4j.array;

/**
 * Turn - переворот массива.
 * @author - Azarkov Maxim.
 * @version $Id$.
 * @since 0.1 (27.02.2019)
 */
public class Turn {

    /**
     * back - перевернем массив
     * @param array - подопытный массив
     * @return - перевернутый массив
     */
    public int[] back(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}