package ru.job4j.array;

/**
 * Square
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1 (27.02.2019)
 */
public class Square {

    /**
     * calculate - возвращает массив через цикл элементами от 1 до bound возведенными в квадрат
     * @param bound - размер массива
     * @return - возвращаемый массив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        int i = 0;
        while (i < bound) {
            rst[i] = (int) Math.pow(i + 1, 2);
            i++;
        }
        return rst;
    }
}