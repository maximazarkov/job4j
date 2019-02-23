package ru.job4j.converter;

/**
 * Конвертер валюты
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.1 (23.02.2019).
 */
public class Converter {

    int courseEuro = 70;
    int courseDollar = 60;

    /**
     * Конвертируем рубли в евро.
     * @param value - рубли.
     * @return - евро.
     * @since 0.1 (23.02.2019).
     */
    public int rubleToEuro(int value) {
        return value / this.courseEuro;
    }

    /**
     * Конвертируем рубли в доллар.
     * @param value - рубли.
     * @return - доллар.
     * @since 0.1 (23.02.2019).
     */
    public int rubleToDollar(int value) {
        return value / this.courseDollar;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value - евро.
     * @return - рубли.
     * @since 0.1 (23.02.2019).
     */
    public int euroToRuble(int value) {
        return value * this.courseEuro;
    }

    /**
     * Конвертируем доллар в рубли.
     * @param value - доллар.
     * @return - рубли.
     * @since 0.1 (23.02.2019).
     */
    public int dollarToRuble(int value) {
        return value * this.courseDollar;
    }

}
