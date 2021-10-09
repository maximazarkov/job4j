package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void whenEqualsTwoUsersAndFirstUserNameIsNullThenFalse() {
        User first = new User("4321 123456", null);
        User second = new User("4321 123456", "Ivan");
        Assert.assertNotEquals(first, second);
    }

    @Test
    public void whenEqualsTwoUsersAndFirstUserPassportIsNullThenFalse() {
        User first = new User(null, "Ivan");
        User second = new User("4321 123456", "Ivan");
        Assert.assertNotEquals(first, second);
    }

    @Test
    public void whenEqualsTwoIdenticalUsersThenTrue() {
        User second = new User("4321 123456", "Ivan");
        User first = new User("4321 123456", "Ivan");
        Assert.assertEquals(first, second);
    }

    @Test
    public void whenEqualsTwoUsersIsDifferentPassportsThenFalse() {
        User second = new User("4321 123456", "Ivan");
        User first = new User("9876 123456", "Ivan");
        Assert.assertNotEquals(first, second);
    }
}
