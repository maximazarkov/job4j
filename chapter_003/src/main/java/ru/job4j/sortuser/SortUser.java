package ru.job4j.sortuser;

import java.util.*;

/**
 * @author Azarkov Maxim.
 * @since 04.08.2019
 */
public class SortUser {

    /**
     * Метод сортирующий коллекцию с помощью встроенного функционала TreeSet.
     * @param users - передаваемая коллекция
     * @return - отсортированная коллекиция типа Set
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Метод для сортировки по длинне имени пользователя
     * @param users - коллекиця
     * @return - отсортированная коллекция типа List
     */
    public List<User> sortNameLength(List<User> users) {
        NameLengthCompare nlc = new NameLengthCompare();
        Collections.sort(users, nlc);
        return users;
    }

    /**
     *
     * Метод, сортирующий пользователей сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     * @param users - коллекиця
     * @return - отсортированная коллекция типа List
     */
    public List<User> sortByAllFields(List<User> users) {
        AllFieldsCompare afc = new AllFieldsCompare();
        Collections.sort(users, afc);
        return users;
    }

    // Класс, реализующий компаратор, для сортировки по длинне имени
    private class NameLengthCompare implements Comparator<User> {
        public int compare(User frst, User scnd) {
            return frst.getName().length() - scnd.getName().length();
        }
    }


    // Класс, реализующий компаратор, для сортировки по разнице по всем полям
    private class AllFieldsCompare implements Comparator<User> {
        public int compare(User frst, User scnd) {
            int result = frst.getName().compareTo(scnd.getName());
            if (result == 0) {
                result = frst.getAge() - scnd.getAge();
            }
            return result;
        }
    }
}

