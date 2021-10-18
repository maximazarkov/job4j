package ru.job4j.search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class PhoneDictionaryTest {

    private final PhoneDictionary phones = new PhoneDictionary();

    @Before
    public void loadOutputBefore() {

        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Petr", "Ivanov", "234567", "Omsk")
        );
        phones.add(
                new Person("Ivan", "Ivanov", "234567", "Omsk")
        );
    }

    @Test
    public void whenFindBySurname() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("Arsentev");
        Assert.assertEquals(persons.iterator().next().getSurname(), "Arsentev");
    }

    @Test
    public void whenFindByName() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("Petr");
        Assert.assertEquals(persons.iterator().next().getSurname(), "Arsentev");
    }

    @Test
    public void whenFindByPhone() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("534872");
        Assert.assertEquals(persons.iterator().next().getSurname(), "Arsentev");
    }

    @Test
    public void whenFindByPhoneIvanovPetr() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("234567");
        Assert.assertEquals(persons.iterator().next().getName(), "Petr");
    }

    /* пока не совмем понял как протестить коллекцию, если в ней больше 1 элемента
    * данный тест падает
    */
    @Test
    public void whenFindByPhoneTwoPersonIvanov() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("234567");
        Iterator<Person> it = persons.iterator();
        Person p = it.next();
        Assert.assertEquals(p.getName(), "Petr");
        p = it.next();
        Assert.assertEquals(p.getName(), "Ivan");
    }

    @Test
    public void whenFindByPhoneTwoPersonSize() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("234567");
        Assert.assertEquals(persons.size(), 2);
    }

}