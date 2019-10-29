package ru.job4j.sortuser;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SortUserTest {
    @Test
    public void whenSortingUserByName() {
        List<User> users = List.of(
                new User("Max", 55),
                new User("Timoha", 45),
                new User("Vera", 23),
                new User("Lev", 12)
        );

        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> expect = Set.of(
                new User("Lev", 12),
                new User("Vera", 23),
                new User("Max", 55),
                new User("Timoha", 45)
        );
        assertThat(expect, is(result));
    }


    @Test
    public void whenSortingUserByNameLength() {
//        List<User> users = List.of(...) падает с java.lang.UnsupportedOperationException
//        при вызове метода sortUser.sortNameLength(users) с компаратором
//        судя по всему нестыкуются типы передаваемго класса.
//        Ожидается ArrayList<>, а генерится ImmutableCollections$ListN
//        По этому применю следующий вариант:
        List<User> users = new ArrayList<>(List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
                )
        );
//      Хочу заметить, для для колекции, которая сортируется свтроенной функцией .sort()
//      проблем нет. есть подозрение, что вариант, примененный выше - костыльный...
//      возможно есть выход, если переписать методы сортировки в формате обобщения
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = List.of(
                new User("Иван", 30),
                new User("Иван", 25),
                new User("Сергей", 25),
                new User("Сергей", 20)
        );
        assertThat(expect, is(result));
    }

    @Test
    public void whenSortingByAllFields() {
        List<User> users = new ArrayList<>(List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        ));

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expect = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25));
        assertThat(expect, is(result));
    }
}
