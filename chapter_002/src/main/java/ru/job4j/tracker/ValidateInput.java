package ru.job4j.tracker;

/**
 * класс ValidateInput, наследующий ConsoleInput. В нем переопределен метод ask таким образом,
 * что бы обрабатывались исключительные ситуации (при помощи блоков try { … } catch( … ) { … }).
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String quastion, int[] range) {
        /**
         * инициализируем условие выхода из цикла опроса клавиатуры. Если ошибок нет, то клавиатура опрашивается
         * без замечаний и возвращается номер нажато клавищи. Если допущен случай исключения, то возвращается ошибка -1.
         */
        boolean invalid = true;
        int value = -1;
        do {
           try {
                value = super.ask(quastion, range);
                invalid = false;
           } catch (MenuOutException moe) {
               //moe.printStackTrace();
               System.out.println("Please select key from menu.");
           } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
           }
        } while (invalid);
        return value;

    }
}
