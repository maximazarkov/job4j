package ru.job4j.department;

import java.util.Comparator;

/**
 * Создав в эксперементальных целях для изучения компаратора в коллекиях.
 * Предназначен для тестирования метода .reversed().
 * @since 0.7.
 * @deprecated. выведен из работы в этой же версии, т.к. задача реализована на лямбда выражениях
 */
class CompNormal implements Comparator<String> {
    public int compare(String a, String b) {
        // выполним сравнение в обратном порядке
        return a.compareTo(b);
    }
    // переопределять метод equals не требуется
}
