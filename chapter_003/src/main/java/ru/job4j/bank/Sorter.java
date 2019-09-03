// не правильно указан пакет. название не должно иметь имея домена верхнего уровня
//package com;
package ru.job4j.bank;

import java.util.*;

public class Sorter {

    public Sorter() {

    }

    /**
     * Сортировки спитска пользователей
     * @param list
     * @return
     */
    Set<User> sort(List<User> list) {
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }

    /**
     * Сортировка пользователей по длинне имени.
     * @param list
     * @return
     */
    List<User> sortnamelength(List<User> list) {
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }

    /**
     * Сортировка по двум признакам - имя, затем возраст возраст.
     * @param list
     * @return
     */
    List<User> sortboth(List<User> list) {
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getPassport().compareTo(o2.getPassport());
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}