package ru.job4j.sortuser;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SortUserTest {
    @Test
    public void whenSortingUserByName() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Max", 55),
                new User("Timoha", 45),
                new User("Vera", 23),
                new User("Lev", 12)
                )
        );

        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new TreeSet<User>();
        expect.addAll(Arrays.asList(
                new User("Lev", 12),
                new User("Vera", 23),
                new User("Max", 55),
                new User("Timoha", 45)
            )
        );
        assertThat(expect, is(result));
    }


    @Test
    public void whenSortingUserByNameLength() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
                )
        );

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(
                new User("Иван", 30),
                new User("Иван", 25),
                new User("Сергей", 25),
                new User("Сергей", 20)
                )
        );
        assertThat(expect, is(result));
    }

    @Test
    public void whenSortingByAllFields() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
                )
        );

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expect = new ArrayList<User>();
        expect.addAll(Arrays.asList(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
                )
        );
        assertThat(expect, is(result));
    }
}
