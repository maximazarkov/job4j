package ru.job4j.tracker;

/**
 * Класс реализует поиск заявки из хранилища по Id.
 */
public class FindItemById implements UserAction {
    int key;
    String info;

    public FindItemById(int key, String info) {
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
        System.out.println("---------------- Поиск заявки по Id ---------------");
        String id = input.ask("Введите Id заявки:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("----------------- Заявки отсуствуют -----------------0");
        }
    }
}