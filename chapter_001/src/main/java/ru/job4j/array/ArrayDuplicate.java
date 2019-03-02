package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        //После удаления дубликатов в массиве {"Привет", "Мир", "Привет", "Супер", "Мир"} должно получиться {"Привет", "Мир", "Супер"}
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
