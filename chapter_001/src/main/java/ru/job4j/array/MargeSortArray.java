package ru.job4j.array;


/* Даны два отсортированных массива.
Вам нужно написать метод, который берет элементы этих массивов и добавляет в третий массив.
int[] merge(int[] left, int[] right)
Третий массив должен получится тоже отсортированный.
Например:
Массив 1                    int[] a = new int[] {1, 3};
Массив 2                    int[] b = new int[] {2, 4};
Массив результат, который появится после слияния.
int[] result = new int[] {1, 2, 3, 4};
В задаче нельзя использовать сортировку.
*/

/**
 * MargeSortArray - объединение отсортированных строк.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1.
 */

public class MargeSortArray {



    /**
     * marge - метод, который берет элементы двух отсортированных массивов и объеденяет в третий отсортированный  массив.
     * @param left - первый массив
     * @param right - второй массив
     * @return - результат объединения
     */
    public int[] marge(int[] left, int[] right) {
        int countL = 0; // счетчик элементов для левого массива
        int countR = 0; // счетчик элементов для правого массива
        int[] result = new int[left.length + right.length];

        // вижу, что можно как-то упростить код, но пока не пойму как
        // возможно лямбда выражениями или перехватом Exception.
        while (countL + countR != left.length + right.length) {
            // исключим перемолнение
            if (countR == right.length) {
                result[countL + countR] = left[countL];
                countL++;
            } else if (countL == left.length) {
                result[countL + countR] = right[countR];
                countR++;
            } else if (left[countL] <= right[countR]) {
                result[countL + countR] = left[countL];
                countL++;
            } else {
                result[countL + countR] = right[countR];
                countR++;
            }
        }
        return result;
    }
}
