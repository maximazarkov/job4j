package ru.job4j.loop;

/**
 * Factorial - Факториал.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1 (26.02.2019)
 */
public class Factorial {

    public int calc(int n) {
        int temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
        }
        return temp;
    }
}
