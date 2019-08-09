package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLnStr = (left.length() >= right.length()) ? right.length() : left.length();
        for (int i = 0; i < minLnStr; i++) {
            if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                break;
            } else if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                break;
            } else {
                if (left.length() > right.length()) {
                    result = 1;
                } else if (left.length() < right.length()) {
                    result = -1;
                }
            }
        }

        return result;
    }

}