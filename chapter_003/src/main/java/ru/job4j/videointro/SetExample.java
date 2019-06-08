package ru.job4j.videointro;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        //Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set = new TreeSet<Integer>();

        set.add(3);
        set.add(4);
        set.add(1);
        set.add(0);

        set.add(4); //выполнится, но не добавится!

        for (Integer value : set) {
            System.out.println(value);

        }
    }
}
