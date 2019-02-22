package ru.job4j.calculate;

/**
 * Calculate.
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.2 (22.02.2019).
 */

public class Calculate {
    /**
     * @since 0.2 (22.02.2019).
     */
    private double result;

    /**
     * Method add - sum two number  (first+second).
     * @param first - first number (double).
     * @param second - second number (double).
     * @since 0.2 (22.02.2019).
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract - sub two number (first-second).
     * @param first - first number (double).
     * @param second - second number (double).
     * @since 0.2 (22.02.2019).
     */
    public void subtruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div - div two number (first/second).
     * @param first - first number (double).
     * @param second - second number (double).
     * @since 0.2 (22.02.2019).
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple - sum two number (first*second).
     * @param first - first number (double).
     * @param second - second number (double).
     * @since 0.2 (22.02.2019).
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult - return result (double).
     * @since 0.2 (22.02.2019).
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Method echo.
     * @param name - your name.
     * @return Echo plus your name.
     * @since 0.2 (20.02.2019).
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
