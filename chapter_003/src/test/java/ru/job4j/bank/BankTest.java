package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class BankTest {
    @Test
    public void whenAddAndDeleteTwoUsers() {
        Bank bank = new Bank();
        bank.addUser(new User("Иван", "12 34 123456"));
        bank.addUser(new User("Степан", "21 43 654321"));
        assertThat(bank.getUser("12 34 123456").getName(), is("Иван"));
        assertThat(bank.getUser("21 43 654321").getName(), is("Степан"));
        bank.deleteUser(bank.getUser("12 34 123456"));
        String result = bank.getUser("12 34 123456").getName();
        assertNull(result);
    }

    @Test
    public void whenNotFoundUser() {
        Bank bank = new Bank();
        User u = new User();
        bank.addUser(new User("Иван", "12 34 123456"));
        String result = bank.getUser("98 76 543210").getName();
        assertThat(result, is(u.getName()));
        assertNull(result);
    }

    @Test
    public void whenAddTwoAccaunstFromPassportThenFindTwoAccaunts() {
        Bank bank = new Bank();
        bank.addUser(new User("Иван", "12 34 123456"));
        bank.addAccountToUser("12 34 123456", new Account(10000, "1111 11111 1111 11111"));
        bank.addAccountToUser("12 34 123456", new Account(20000, "2222 11111 1111 11111"));

        List<Account> result = bank.getUserAccounts("12 34 123456");

        List<Account> expect = new ArrayList<Account>();
        expect.add(new Account(10000, "1111 11111 1111 11111"));
        expect.add(new Account(20000, "2222 11111 1111 11111"));

        assertThat(result, is(expect));
    }

    @Test
    public void whenAddTwoAccaunstFromPassportNotFoundAccounts() {
        Bank bank = new Bank();
        bank.addUser(new User("Иван", "12 34 123456"));
        bank.addAccountToUser("12 34 123456", new Account(10000, "1111 11111 1111 11111"));
        bank.addAccountToUser("12 34 123456", new Account(20000, "2222 11111 1111 11111"));

        List<Account> result = bank.getUserAccounts("55 44 321321");
        List<Account> expect = new ArrayList<Account>();
        assertThat(result, is(expect));
    }

    @Test
    public void whenDeleteOneUserAccaunstFromPassport() {
        Bank bank = new Bank();
        bank.addUser(new User("Иван", "12 34 123456"));
        Account accForDelete = new Account(10000, "1111 11111 1111 11111");
        bank.addAccountToUser("12 34 123456", accForDelete);
        bank.addAccountToUser("12 34 123456", new Account(20000, "2222 11111 1111 11111"));

        bank.deleteUserAccountFromUser("12 34 123456", accForDelete);
        List<Account> result = bank.getUserAccounts("12 34 123456");

        List<Account> expect = new ArrayList<Account>();
        expect.add(new Account(20000, "2222 11111 1111 11111"));

        assertThat(result, is(expect));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        String srcPassport = "12 34 123456";
        Account srcAccount =  new Account(10000, "1111 11111 1111 11111");
        String dstPassport = "21 43 654321";
        Account dstAccount = new Account(20000, "2222 11111 1111 11111");

        bank.addUser(new User("Иван", srcPassport));
        bank.addUser(new User("Степан", dstPassport));

        bank.addAccountToUser(srcPassport, srcAccount);
        bank.addAccountToUser(dstPassport, dstAccount);

        boolean result  = bank.transferMoney(srcPassport, srcAccount.getRequisites(),
                dstPassport, dstAccount.getRequisites(), 5000);

        assertThat(result, is(true));
    }


}
