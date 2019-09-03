package ru.job4j.bank;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccauntTest {
    @Test
    public void whenEqualsTwoAccauntsThenTrue() {
        Account first = new Account(1000, "1111 2222 3333 4444");
        Account second = new Account(1000, "1111 2222 3333 4444");
        assertThat(first.equals(second), is(true));
    }

    @Test
    public void whenTransferEnoughFundsThenTrue() {
        Account first = new Account(1000d, "1111 2222 3333 4444");
        Account second = new Account(1000d, "5555 2222 3333 4444");
        assertThat(first.transfer(second, 500d), is(true));
        assertThat(first.getValues(), is(500d));
        assertThat(second.getValues(), is(1500d));
    }

    @Test
    public void whenTransferNotEnoughFundsThenTrue() {
        Account first = new Account(1000d, "1111 2222 3333 4444");
        Account second = new Account(1000d, "5555 2222 3333 4444");
        assertThat(first.transfer(second, 2000d), is(false));
    }

    @Test
    public void whenTransferDuplicateAccauntsThenFalse() {
        Account first = new Account(1000d, "1111 2222 3333 4444");
        Account second = new Account(1000d, "1111 2222 3333 4444");
        assertThat(first.transfer(second, 500d), is(false));
    }

}
