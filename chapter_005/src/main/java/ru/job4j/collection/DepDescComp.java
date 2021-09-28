package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rlt = 0;
        List<String> dep1 = Departments.fillGaps(List.of(o1));
        List<String> dep2 = Departments.fillGaps(List.of(o2));
            for (int i = 0; i < Math.min(dep1.size(), dep2.size()); i++) {
                if ((rlt = dep1.get(i).compareTo(dep2.get(i))) != 0) {
                    break;
                }
            }
            if (rlt == 0) {
                rlt = Integer.compare(dep2.size(),dep1.size());
            }
//        }
        return rlt;
    }
}
