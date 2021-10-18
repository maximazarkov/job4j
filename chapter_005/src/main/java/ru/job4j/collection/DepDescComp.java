package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rlt = 0;
        rlt = o2.split("/")[0].compareTo(o1.split("/")[0]);
        return rlt == 0 ? o1.compareTo(o2) : rlt;
    }
}
