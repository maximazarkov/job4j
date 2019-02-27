package ru.job4j.array;

/**
 * FindLoop - поиск с помощью цикла.
 * @author AzarkovMaxim.
 * @version $Id$.
 * @since 0.1 (27.02.2019)
 */
public class FindLoop {

    /**
     * indexOf - возвращает индекс найденного элемента.
     * @param data -массив.
     * @param el - искомый элемент.
     * @return -  индекс элемента в массие при его наличии, иначе - -1.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}