package ru.job4j.loop;

/**
 * Counter - счетчики.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1 (25.02.2019)
 */
public class Counter {

    /**
     * Метод add должен вычислять сумму четныx чисел в диапазоне от start до finish;
     * @param start - начало диапазона
     * @param finish - конец диапазоно
     * @return - сумма четных значений
     */
    public int add(int start, int finish) {
        int temp = 0;
        for (int i = start; i <= finish; i++) {
            temp += (i % 2 == 0) ? i : 0;
        }
        return temp;
    }
}
