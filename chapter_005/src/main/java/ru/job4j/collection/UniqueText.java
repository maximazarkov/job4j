package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        /* for-each origin -> new HashSet. */
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        /* for-each text -> hashSet.contains */
        for (String str : text) {
            if (!check.contains(str)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
