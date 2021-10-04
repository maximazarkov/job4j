package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rlt = 0;
        List<String> dep1 = Departments.fillGaps(List.of(o1));
        List<String> dep2 = Departments.fillGaps(List.of(o2));
        rlt = dep2.get(0).compareTo(dep1.get(0));
        if (rlt == 0) {
            rlt = o1.compareTo(o2);
        }
        return rlt;
    }
}
