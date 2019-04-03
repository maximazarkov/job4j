package ru.job4j.tracker;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        //how to init
    }

    public void fillActions() {
        this.actions[0] = new AddItem(this.input, this.tracker)
    }

    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = this.input.ask("Введите имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }

    public void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    /*
// провел жксперимент с int. в классе MenuTracker создал тестовый метод void select(int index)
// в будущем, как я понимаю нужно будет прикрутить к нему некий метод Action (в замен void).
            int index;
            try {
                index = Integer.parseInt(answer);
            }
            catch (NumberFormatException e)
            {
                index = -1;
            }

            menu.select(index);
*/
//    public Action select(int index) {
 //   public void select(int index) {
 //       System.out.println("Selected index: " + index);
 //   }
}
