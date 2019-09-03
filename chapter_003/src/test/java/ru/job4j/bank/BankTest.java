package ru.job4j.bank;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;


public class BankTest {
    @Test
    public void whenAddAndDeleteTwoUsers() {
        Bank bank = new Bank();
        User u1 = new User("Иван", "12 34 123456");
        User u2 = new User("Степан", "21 43 654321");
        bank.addUser(u1);
        bank.addUser(u2);
        assertThat(bank.getUser("12 34 123456").getName(), is("Иван"));
        assertThat(bank.getUser("21 43 654321").getName(), is("Степан"));
        bank.deleteUser(bank.getUser("12 34 123456"));
        //нужно вспомнить как проверять null в тесте.
//        assertThat(bank.getUser("12 34 123456").getName(), is(null));
    }

//        List<Account> expect = new ArrayList<Account>();
//        expect.add(new Account(10000, "1111 11111 1111 11111"));
//        expect.add(new Account(20000, "2222 11111 1111 11111"));
//        expect.add(new Account(100, "3333 11111 1111 11111"));


}
