package ru.job4j.department;

import java.util.Comparator;

/**
 * Создадим компоратор для сортировки в обратном направлении
 * Создан в эксперементальных целях для изучения компаратора в коллекиях.
 * Предназначен для тестирования ручного метода обратной сортировки.
 * @since 0.7.
 * @deprecated. выведен из работы в этой же версии, т.к. задача реализована на лямбда выражениях
 */


class CompRevers implements Comparator<String> {
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr = a;
        bStr = b;
        // выполним сравнение в обратном порядке
        return bStr.compareTo(aStr);
    }
    // переопределять метод equals не требуется
}
