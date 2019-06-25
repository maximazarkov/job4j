package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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

    /*
     * В классе ConvertList из 3-го задания 1-го урока написать метод:
     * public List<Integer> convert (List<int[]> list)
     * В этом методе вы должны пройтись по всем элементам всех массивов в списке list
     * и добавить их в один общий лист Integer.
     * Массивы в списке list могут быть разного размера.
     * Например:
     * list.add(new int[]{1, 2})
     * list.add(new int[]{3, 4, 5, 6})
     * List<Integer> result = convertList.convert(list)
     *
     * List<Integer> result будет содержать элементы: (1, 2, 3, 4, 5, 6)
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();

        /* foreach */
//        for (int[] lst: list) {
//            for (int l: lst) {
//                result.add(l);
//            }
//        }

        /* реализация с помощью итератора */
//        Iterator<int[]> it = list.iterator();
//        while(it.hasNext()) {
//            for (int l : it.next()) {
//                result.add(l);
//            }
//        }

        /* реализация с помощью стрим апи */
//        list.forEach(
//            new Consumer<int[]>() {
//                @Override
//                public void accept(int[] list) {
//                    for (int l : list) {
//                        result.add(l);
//                    }
//                }
//            }
//        );

        /* упростим стрим апи до лямбда */
        list.forEach(lst -> {
                    for (int l : lst) {
                        result.add(l);
                    }
                }
        );

        /* еще вариант упрощения. статический вызов не статического поля у обьъекта */
        /* === НЕ УДАЛОСЬ РЕАЛИЗОВАТЬ === */
//        list.forEach(System.out::println);

        return result;
    }
}