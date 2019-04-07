package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
     /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.init();
    }

    /**
     * Основой цикл программы.
     */
    private void init() {
//        MenuTracker menu = new MenuTracker(this.input, this.tracker);
//        menu.fillActions();
//        do {
//            menu.show();
//            menu.select(Integer.valueOf(input.ask("select:")));
//        } while (!"y".equals(this.input.ask("Exit?(y): ")));
//    }
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        //List<Integer> range = new ArrayList<>();
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
        //    range.add(i);
            range[i] = i;
        }
        while (!exit) {
            menu.show();
            //String answer = input.ask("Введите пункт меню : ");
            int answer = input.ask("Введите пункт меню : ", range);
            menu.select(Integer.valueOf(answer));
            menu.select(input.ask("select:", range));
            if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        //new StartUI(new ConsoleInput(), new Tracker()).init();
        new StartUI(new ValidateInput(), new Tracker());
    }
}
