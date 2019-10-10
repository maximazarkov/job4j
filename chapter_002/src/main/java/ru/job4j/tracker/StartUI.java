package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
     /**
     * Константа для выхода из цикла.
     */
    //private static final String EXIT = "6";
     private static final int EXIT = 6;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок
     */
    private final Tracker tracker;

    /**
     * Реализация вывода данных с помощью Consumer. С помощью лямбда будет передана функция println
     * @since 11.10.2019 0.2
     */
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     * @param output ...
     * @since 11.10.2019 0.2
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    private void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range[i] = i;
        }
        while (!exit) {
            menu.show();
            //String answer = input.ask("Введите пункт меню : ");
            int answer = input.ask("Введите пункт меню : ", range);
            menu.select(answer);
            //menu.select(input.ask("select:", range));
            if (EXIT == answer) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        //new StartUI(new ConsoleInput(), new Tracker()).init();
        //new StartUI(new ValidateInput(), new Tracker());
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
