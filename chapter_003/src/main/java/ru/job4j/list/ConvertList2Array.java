package ru.job4j.list;

import java.util.List;

/*
* Вам необходимо создать класс
* ConvertList2Array
* Внутри методов использовать foreach.
*
* public int[][] toArray (List<Integer> list, int rows) {} - метод toArray должен
* равномерно разбить лист на количество строк двумерного массива. В методе toArray
* должна быть проверка - если количество элементов не кратно количеству строк -
* оставшиеся значения в массиве заполнять нулями.
*
* Например в результате конвертации листа со значениями (1,2,3,4,5,6,7)
* с разбиением на 3 строки должен получиться двумерный массив {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
* */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + (list.size() == rows ? 0 : 1);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer lst: list) {
            array[row][cell++] = lst;
            if (cell >= cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}