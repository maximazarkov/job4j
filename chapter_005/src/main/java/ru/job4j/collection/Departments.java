package ru.job4j.collection;

import java.util.*;

public class Departments {
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

    public static void sortAsc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static void sortDesc(List<String> orgs) {
// - сравниваем первые элементы полученных массивов по убыванию с помощью compareTo(),
// результат помещаем в переменную rsl
// - если rsl равен 0 - то возвращаем такое сравнение: o1.compareTo(o2) -
// иначе - переменную rsl
        orgs.sort(new DepDescComp());
    }
}
