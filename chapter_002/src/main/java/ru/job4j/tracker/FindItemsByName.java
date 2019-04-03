package ru.job4j.tracker;

/**
 * Класс реализует поиск заявки из хранилища по имени.
 */
public class FindItemsByName implements UserAction {
    int key;
    String info;

    public FindItemsByName(int key, String info) {
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
        System.out.println("-------------- Поиск заявки по имени --------------");
        String key = input.ask("Введите имя заявки:");
        Item[] items = tracker.findByName(key);
        if (items != null) {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        System.out.println("---------------------------------------------------");
    }
}