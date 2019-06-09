package ru.job4j.videointro;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(425);                      //index = 0
        Integer value = list.get(0);
        System.out.println(value);

        list.add(1, 32);     //index = 1
        System.out.println(list.get(1));

        List<Integer> flats = new ArrayList<Integer>();
        flats.add(4);                       //index = 2
        flats.add(3);                       //index = 3
        list.add(425);

        list.addAll(flats);

        System.out.println(format("find 4 index: %s", list.indexOf(4)));    // >>> index(4) => 2
        System.out.println(format("find 32 index: %s", list.lastIndexOf(32)));  // >>> lastIndex(32) => 1

        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(format("find index %s value: %s", i, list.get(i)));
        }
        System.out.println(format("find 3 index: %s", list.indexOf(3)));    // >>> index(3) => 2

    }
}
