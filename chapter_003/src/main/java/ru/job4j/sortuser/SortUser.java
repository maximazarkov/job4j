package ru.job4j.sortuser;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<ListExample.User> sort(List<ListExample.User> users) {
        return new TreeSet<>(users);
    }
}

