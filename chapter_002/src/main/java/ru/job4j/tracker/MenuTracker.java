package ru.job4j.tracker;

public class MenuTracker {

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
