package ru.job4j.max;

/**
 * Max.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1 (25.02.2019).
 */
public class Max {

    /**
     * max - определяет максимальное число.
     * @param first - первое число.
     * @param second - второе число.
     * @return - максимальное число.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * max - определяет максимальное число.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @return - максимальное число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }

    /**
     * summation - сумма двух чисел
     * @param first - первое число.
     * @param second - второе число.
     * @return sum sacond & first
     */
    public int summation(int first, int second) {
        return first + second;
    }
}
