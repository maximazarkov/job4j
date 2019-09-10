package ru.job4j.bank;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserTest {

    @Test
    public void whenEqualsTwoUsersAndFirstUserIsNullThenFalse() {
        User first = new User();
        User second = new User("Ivan", "4321 123456");
        assertThat(first.equals(second), is(false));
    }

    @Test
    public void whenEqualsTwoUsersAndFirstUserNameIsNullThenFalse() {
        User first = new User(null, "4321 123456");
        User second = new User("Ivan", "4321 123456");
        assertThat(first.equals(second), is(false));
    }

    @Test
    public void whenEqualsTwoUsersAndFirstUserPassportIsNullThenFalse() {
        User first = new User("Ivan", null);
        User second = new User("Ivan", "4321 123456");
        assertThat(first.equals(second), is(false));
    }


    @Test
    public void whenEqualsTwoUsersAndSecondUserIsNullThenFalse() {
        User second = new User();
        User first = new User("Ivan", "4321 123456");
        assertThat(first.equals(second), is(false));
    }

    @Test
    public void whenEqualsTwoUsersIsOneObjectThenTrue() {
        User first = new User("Ivan", "4321 123456");
        User second = first;
        assertThat(first.equals(second), is(true));
    }

    @Test
    public void whenEqualsTwoEdenticalUsersThenTrue() {
        User second = new User("Ivan", "4321 123456");
        User first = new User("Ivan", "4321 123456");
        assertThat(first.equals(second), is(true));
    }

    @Test
    public void whenEqualsTwoUsersIsDiferentPassportsThenFalse() {
        User second = new User("Ivan", "4321 123456");
        User first = new User("Ivan", "9876 123456");
        assertThat(first.equals(second), is(false));
    }
}
