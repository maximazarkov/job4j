package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Assert.assertEquals(user, bank.findByPassport("3434"));
    }

    @Test
    public void addUserAndFindByPassportImperativeOptional() {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> user = bank.findByPassportImperativeOptional("3211");
        Assert.assertFalse(user.isPresent());
    }

    @Test
    public void addUserAndFindByPassportImperativeOptionalGetNull() {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> user = bank.findByPassportImperativeOptional(null);
        Assert.assertFalse(user.isPresent());
    }

    @Test
    public void addUserAndFindByPassportFuncOptional() {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> user = bank.findByPassportFuncOptional("3211");
        Assert.assertFalse(user.isPresent());
    }

    @Test
    public void addUserAndFindByPassportFuncOptionalGetNull() {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> user = bank.findByPassportFuncOptional(null);
        Assert.assertFalse(user.isPresent());
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Assert.assertEquals(Double.valueOf(150D),
                Double.valueOf(bank.findByRequisite("3434", "5546").getBalance()));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        Assert.assertEquals(Double.valueOf(200D),
                Double.valueOf(bank.findByRequisite(user.getPassport(), "113").getBalance()));
//        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }

    @Test (expected = NullPointerException.class)
    public void whenAddAndDeleteTwoUsers() {
        BankService bankService = new BankService();
        bankService.addUser(new User("12 34 123456", "Иван"));
        bankService.addUser(new User("21 43 654321", "Степан"));
        Assert.assertEquals(bankService.findByPassport("12 34 123456").getUsername(), "Иван");
        Assert.assertEquals(bankService.findByPassport("21 43 654321").getUsername(), "Степан");
        bankService.deleteUser(bankService.findByPassport("12 34 123456"));
        Assert.assertNull(bankService.findByPassport("12 34 123456").getUsername());
        bankService.deleteUser(bankService.findByPassport("21 43 654321"));
        Assert.assertNull(bankService.findByPassport("21 43 654321").getUsername());
    }

    @Test
    public void whenNotFoundUser() {
        BankService bankService = new BankService();
        bankService.addUser(new User("12 34 123456", "Иван"));
        User u = new User("98 76 543210", "Степан");
        Assert.assertNotEquals(bankService.findByPassport("12 34 123456").getUsername(), u.getUsername());
    }

    @Test
    public void whenAddTwoAccountsFromPassportThenFindTwoAccounts() {
        BankService bankService = new BankService();
        bankService.addUser(new User("12 34 123456", "Иван"));
        bankService.addAccount("12 34 123456", new Account("1111", 10000));
        bankService.addAccount("12 34 123456", new Account("2222", 20000));

        List<Account> result = bankService.getUserAccounts("12 34 123456");

        List<Account> expect = new ArrayList<>();
        expect.add(new Account("1111", 10000));
        expect.add(new Account("2222", 20000));

        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenAddTwoUserAndTwoAccountsThenFindTwoAccounts() {
        BankService bankService = new BankService();
        bankService.addUser(new User("12 34 123456", "Иван"));
        bankService.addAccount("12 34 123456", new Account("1111", 10000));
        bankService.addUser(new User("21 43 654321", "Степан"));
        bankService.addAccount("21 43 654321", new Account("2222", 20000));

        List<Account> result = bankService.getUserAccounts("12 34 123456");
        List<Account> expect = new ArrayList<>();
        expect.add(new Account("1111", 10000));
        Assert.assertEquals(result, expect);

        result = bankService.getUserAccounts("21 43 654321");
        expect = new ArrayList<>();
        expect.add(new Account("2222", 20000));
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenAddTwoAccountsFromPassportNotFoundAccounts() {
        BankService bankService = new BankService();
        bankService.addUser(new User("12 34 123456", "Иван"));
        bankService.addAccount("12 34 123456", new Account("1111", 10000));
        bankService.addAccount("12 34 123456", new Account("2222", 20000));

        List<Account> result = bankService.getUserAccounts("55 44 321321");
        List<Account> expect = new ArrayList<>();
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenDeleteOneUserAccountsFromPassport() {
        BankService bankService = new BankService();
        bankService.addUser(new User("12 34 123456", "Иван"));
        Account accForDelete = new Account("1111", 10000);
        bankService.addAccount("12 34 123456", accForDelete);
        bankService.addAccount("12 34 123456", new Account("2222", 20000));
        System.out.println(bankService);

        bankService.deleteUserAccountFromUser("12 34 123456", accForDelete);
        System.out.println(bankService);
        List<Account> result = bankService.getUserAccounts("12 34 123456");

        List<Account> expect = new ArrayList<>();
        expect.add(new Account("2222", 20000));
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenDeletingTheAccountOfTheSecondUserOnThePassport() {
        BankService bankService = new BankService();
        Account accForDelete = new Account("2222", 20000);
        bankService.addUser(new User("12 34 123456", "Иван"));
        bankService.addUser(new User("21 43 654321", "Степан"));
        bankService.addAccount("12 34 123456", new Account("1111", 10000));
        bankService.addAccount("21 43 654321", accForDelete);

        List<Account> result = bankService.getUserAccounts("12 34 123456");
        List<Account> expect = new ArrayList<>();
        expect.add(new Account("1111", 10000));
        Assert.assertEquals(result, expect);

        result = bankService.getUserAccounts("21 43 654321");
        expect = new ArrayList<>();
        expect.add(accForDelete);
        Assert.assertEquals(result, expect);

        bankService.deleteUserAccountFromUser("21 43 654321", accForDelete);

        result = bankService.getUserAccounts("12 34 123456");
        expect = new ArrayList<>();
        expect.add(new Account("1111", 10000));
        Assert.assertEquals(result, expect);

        result = bankService.getUserAccounts("21 43 654321");
        expect = new ArrayList<>();
        Assert.assertEquals(result, expect);
    }

    @Test
    public void whenTransferMoney() {
        BankService bankService = new BankService();
        String srcPassport = "12 34 123456";
        Account srcAccount =  new Account("1111", 10000);
        String dstPassport = "21 43 654321";
        Account dstAccount = new Account("2222", 20000);

        bankService.addUser(new User(srcPassport, "Иван"));
        bankService.addUser(new User(dstPassport, "Степан"));

        bankService.addAccount(srcPassport, srcAccount);
        bankService.addAccount(dstPassport, dstAccount);

        boolean result  = bankService.transferMoney(srcPassport, srcAccount.getRequisites(),
                dstPassport, dstAccount.getRequisites(), 5000);

        Assert.assertTrue(result);
    }
}
