package ru.job4j.search;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
//import java.util.NoSuchElementException;

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
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByName() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("534872");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhoneIvanovPetr() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("234567");
        assertThat(persons.iterator().next().getName(), is("Petr"));
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
        assertThat(p.getName(), is("Petr"));
        p = it.next();                              //обязательно перед каждым обращением перезапрашиваем итератор для нового пёрсона
//        assertThat(p.getName(), is("Petr"));      // если убрать p = it.next();, то итератор не переместиться и тест пройдет успешно, иначе пришлост закомментирова )))
        assertThat(p.getName(), is("Ivan"));  // чтобы сработала эта строка обязательно нужно обратиться к итератору =>  p = it.next();

        // А эта строка так же для истории о неправильно мрипменении итератора. При правильно приенении итератора и превышении количсства элементов словим NoSuchElementException
//        p = it.next();
//        assertThat(p.getSurname(), is("Ivanov"));
    }

    @Test
    public void whenFindByPhoneTwoPersonSize() {
        // init PhoneDictionary SEE @Before
        List<Person> persons = phones.find("234567");
        assertThat(persons.size(), is(2));
    }


//    @Test
//    public void whenFindNull() throws NoSuchElementException {
//        // init PhoneDictionary SEE @Before
//        try {
//            List<Person> persons = phones.find("5348720");
//        } catch (NoSuchElementException nsee) {
//            Assert.assertNotEquals("", nsee.getMessage());
//        }
//    }
}