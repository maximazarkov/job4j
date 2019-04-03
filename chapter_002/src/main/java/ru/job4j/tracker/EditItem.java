package ru.job4j.tracker;

/**
 * Класс реализует редактирование заявки в хранилище.
 */
public class EditItem implements UserAction {
    int key;
    String info;

    public EditItem(int key, String info) {
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
        System.out.println("------------- Редактирование заявки ---------------");
        String id = input.ask("Введите Id заявки, для ее изменения :");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            System.out.println("------------- Заявка отредактирована --------------");
        } else {
            System.out.println("------------ Заявка НЕ ОТРЕДАКТИРОВАНА!------------");
        }
    }
}
