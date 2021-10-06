package ru.job4j.collection;
import java.util.*;

/**
 * Сортировка департаментов.
 */
public class Departments {
    /**
     * Метод, заполняющие отсутствующие в цепочке отделы
     * @param deps урезанный список отделов
     * @return развернутый список с добавленными пропущенными отделами
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.length() > 0 ? start + "/" + el : el;
                tmp.add(start);
            }

        }
        return new ArrayList<>(tmp);
    }

    /**
     * Сортировка массива кодов подразделений по возрастанию и убыванию,
     * при которых сохраняется иерархическая структура.
     * @param orgs
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
