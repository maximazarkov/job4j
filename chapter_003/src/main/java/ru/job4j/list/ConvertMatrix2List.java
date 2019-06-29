package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/*
* Вам необходимо создать класс ConvertMatrix2List.
* Внутри методов использовать foreach.
* public List<Integer> toList (int[][] array) {} - в метод приходит двумерный массив целых чисел,
* необходимо пройтись по всем элементам массива и добавить их в List<Integer>.
* */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] lst: array) {
            for (int l: lst) {
                list.add(l);
            }
        }
        return list;
    }
}