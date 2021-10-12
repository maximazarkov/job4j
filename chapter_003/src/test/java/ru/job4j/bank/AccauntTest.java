package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccauntTest {
    @Test
    public void whenEqualsTwoAccauntsThenTrue() {
        Account first = new Account("1111", 1000);
        Account second = new Account("1111", 1000);
        Assert.assertEquals(first, second);
    }

    @Test
    public void whenTransferEnoughFundsThenTrue() {
        Account first = new Account("1111", 1000d);
        Account second = new Account("5555", 1000d);
        Assert.assertTrue(first.transfer(second, 500d));
        Assert.assertEquals(Double.valueOf(first.getBalance()), Double.valueOf(500d));
        Assert.assertEquals(Double.valueOf(second.getBalance()), Double.valueOf(1500d));
    }

    @Test
    public void whenTransferNotEnoughFundsThenTrue() {
        Account first = new Account("1111", 1000d);
        Account second = new Account("5555", 1000d);
        Assert.assertFalse(first.transfer(second, 2000d));
    }

    @Test
    public void whenTransferDuplicateAccountsThenFalse() {
        Account first = new Account("1111", 1000d);
        Account second = new Account("1111", 1000d);
        Assert.assertFalse(first.transfer(second, 500d));
    }

}
