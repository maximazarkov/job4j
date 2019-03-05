package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate - метод для работы с дубликатамив массиве.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1.
 */
public class ArrayDuplicate {

    /**
     * remove - метод для удаления дублекатов в массиве. После удаления дубликатов в массиве, например: {"Привет", "Мир", "Привет", "Супер", "Мир"} должно получиться {"Привет", "Мир", "Супер"}.
     * @param array - массив для обработки.
     * @return - возвращает новый объект типа String[] - массив с удаленными элементами.
     * @since 0.1.
     */
    public String[] remove(String[] array) {
        int numDupl = 0; // количество дуплекатов
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    String temp = array[array.length - numDupl - 1];
                    array[array.length - numDupl - 1] = array[j];
                    array[j] = temp;
                    numDupl++;
                }
                if (j >= array.length - numDupl - 1) {
                    break;
                }
            }
        }
        return Arrays.copyOf(array, numDupl + 1);
    }
}
