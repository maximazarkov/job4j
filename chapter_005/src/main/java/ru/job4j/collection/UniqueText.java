package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        /* for-each origin -> new HashSet. */
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        /* for-each text -> hashSet.contains */
        for (String str : text) {
            check.remove(str);
        }
        if (check.size() > 0) {
            rsl = false;
        }
        return rsl;
    }
}
