package ru.job4j.calculate;

/**
 * Calculate
 * @author Maxim Azarkov (aza-maxim@yandex.ru)
 * @version $Id$
 * @since 0.1 (17.02.2019)
 */

public class Calculate {
    
    /**
     * main. Конструктор. Выводит строку "hello Job4j" в консоль
     * @param args - args
	 * @since 0.1 (17.02.2019)
     */
    public static void main(String[] args) {
        System.out.println("hello Job4j");
    }

	/**
     * Method echo
     * @param name - your name
	 * @return Echo plus your name.
	 * @since 0.2 (20.02.2019)
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
