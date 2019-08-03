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


}
