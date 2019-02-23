package ru.job4j.calculate;

/**
 * Программа для расчета идеального веса
 * @author Maxim Azarkov (aza-maxim@yandex.ru).
 * @version $Id$.
 * @since 0.3 (23.02.2019).
 */
public class Fit {

    /**
     * Идеальный вес для мужчины
     * @param height - рост
     * @return - идеальный вес
     */
    public double manWaight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины
     * @param height - рост
     * @return - идеальный вес
     */
    public double womanWaight(double height) {
        return (height - 110) * 1.15;
    }
}