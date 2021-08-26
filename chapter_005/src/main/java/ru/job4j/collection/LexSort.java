package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] numLeft, numRight;
        numLeft = left.split("\\.");
        numRight = right.split("\\.");
        return Integer.valueOf(numLeft[0]).compareTo(Integer.valueOf(numRight[0]));
    }
}
