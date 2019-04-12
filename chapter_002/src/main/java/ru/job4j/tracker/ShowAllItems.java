package ru.job4j.tracker;

/**
 * Класс реализует вывод всеех заявок из хранилища.
 */
public class ShowAllItems extends BaseAction {

    public ShowAllItems(int key, String info) {
        super(key, info);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Отображение всех заявки --------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------");
    }
}
