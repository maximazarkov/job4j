package ru.job4j.sortuser;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SortUserTest {
    @Test
    public void whenSortingUserByName() {
        List<ListExample.User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new ListExample.User("Max", 55),
                new ListExample.User("Timoha", 45),
                new ListExample.User("Vera", 23),
                new ListExample.User("Lev", 12)
                )
        );

        SortUser sortUser = new SortUser();
        Set<ListExample.User> result = sortUser.sort(users);
        Set<ListExample.User> expect = new TreeSet<ListExample.User>();
        expect.addAll(Arrays.asList(
                new ListExample.User("Lev", 12),
                new ListExample.User("Vera", 23),
                new ListExample.User("Max", 55),
                new ListExample.User("Timoha", 45)
            )
        );
        assertThat(expect, is(result));

    }

}
