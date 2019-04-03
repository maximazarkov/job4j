package ru.job4j.tracker;

/**
 * @author Azarkov Maxim
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для отображение всех записей.
     */
    private static final String SHOWALL = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поистка заявки по ID заявки.
     */
    private static final String FINDID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDNAME = "5";

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

        boolean exit = false;

        MenuTracker menu = new MenuTracker(this.input,this.tracker);
        do {

        } while(!"y".equals(this.input.ask("Exit? y")));

//        while (!exit) {
//
//            menu.showMenu();
//            String answer = this.input.ask("Введите пункт меню : ");
//            if (ADD.equals(answer)) {
//                //добавление заявки вынесено в отдельный метод.
//                this.createItem();
//            } else if (SHOWALL.equals(answer)) {
//                //отображение всех заявок
//                this.showAllItem();
//            } else if (EDIT.equals(answer)) {
//                //редактирование заявки
//                this.editItem();
//            } else if (DELETE.equals(answer)) {
//                //удаление заявки
//                this.deleteItem();
//            } else if (FINDID.equals(answer)) {
//                //поиск завяки по Id
//                this.findIdItem();
//            } else if (FINDNAME.equals(answer)) {
//                //поиск заяки по имени
//                this.findNameItem();
//                // выход из программы
//            } else if (EXIT.equals(answer)) {
//                exit = true;
//            }
//        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    // как я понимаю - далее идут методы, которые пойду в класс Action. пока оставляю сдесь
    private void createItem() {

        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void showAllItem() {
        System.out.println("------------ Отображение всех заявки --------------");
        for (Item item : this.tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println("---------------------------------------------------");
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------- Редактирование заявки ---------------");
        String id = this.input.ask("Введите Id заявки, для ее изменения :");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (this.tracker.replace(id, item)) {
            System.out.println("------------- Заявка отредактирована --------------");
        } else {
            System.out.println("------------ Заявка НЕ ОТРЕДАКТИРОВАНА!------------");
        }
    }

    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private void deleteItem() {
        System.out.println("----------------- Удаление заявки -----------------");
        String id = this.input.ask("Введите Id заявки, для ее удаления :");
        if (this.tracker.delete(id)) {
            System.out.println("--------------- Заявка удалена ----------------");
        } else {
            System.out.println("-------------- Заявка НЕ УДАЛЕНА!--------------");
        }
    }

    /**
     * Метод реализует поиск заявки из хранилища по Id.
     */
    private void findIdItem() {
        System.out.println("---------------- Поиск заявки по Id ---------------");
        String id = this.input.ask("Введите Id заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("----------------- Заявки отсуствуют -----------------0");
        }
    }

    /**
     * Метод реализует поиск заявки из хранилища по имени.
     */
    private void findNameItem() {
        System.out.println("-------------- Поиск заявки по имени --------------");
        String key = this.input.ask("Введите имя заявки:");
//        int count = 0;
        Item[] items = this.tracker.findByName(key);
        if (items != null) {
            for (Item item : items) {
                System.out.println(item);
//                count++;
            }
        }
//        System.out.println("-----------\tВсего найдено заявок: " + count);
        System.out.println("---------------------------------------------------");

    }


    public static void main(String[] args) {
        //new StartUI(new ConsoleInput(), new Tracker()).init();
        new StartUI(new ConsoleInput(), new Tracker());
    }
}
