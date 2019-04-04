package ru.job4j.tracker;

/**
 * Класс реализует вывод всеех заявок из хранилища.
 */
public class ShowAllItems implements UserAction {
    private int key;
    private String info;

    public ShowAllItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
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
