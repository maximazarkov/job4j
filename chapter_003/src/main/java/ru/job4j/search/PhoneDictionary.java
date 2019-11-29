package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
//import java.util.NoSuchElementException;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
//        result.addAll(persons);
        for (var person : persons) {
            if ((key.contains(person.getName()))
                    || (key.equals(person.getSurname()))
                    || (key.equals(person.getPhone()))
                    || (key.equals(person.getAddress()))
            ) {
                result.add(person);
            }

        }
//        if (result.size() == 0) {
//            throw new NoSuchElementException("Совпадений нет. Повторите поиск с другими параметрами");
//        }
        return result;
    }
}