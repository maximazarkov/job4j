package ru.job4j.array;

/**
 * Обертка над строкой.
 * @author Azarkov Maxim.
 * @version $Id$.
 * @since 0.1.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        //немного усложню проверку, в том числе и для теста
        //допустим, что если массив меньше перфикса, то сразу возвращаем false
        //хотя, думаю, что мой подход не верен, т.к. данную проверку можно организовать в отдельном методе
        //чтобы не нагдужать данный метод.
        if (data.length < value.length) {
            result = false;
        } else {
            for (int i = 0; i < value.length; i++) {
                //провериv, что массив data имеет первые элементы, одинаковые с value
                if (data[i] != value[i]) {
                    result = false;
                }
            }
        }
        return result;
    }
}