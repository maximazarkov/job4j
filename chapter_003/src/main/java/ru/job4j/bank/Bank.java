// не правильно указан пакет. название не должно иметь имея домена верхнего уровня
//package com;
package ru.job4j.bank;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Класс условного банка. Позволяет ввести пользователей и провести межжу ними перевод (транзакцию)
 * @author Azarkov Maxim.
 * @version 0.2
 */
public class Bank {
    /**
     * список пользователей для обработкки транзакций.
     * @since 0.1
     */
    private TreeMap<User, ArrayList<Account>> users = new TreeMap<>();

    /**
     * метод добавления пользователя. Создается мана с привязкой пользователя и его будущего аккаунта.
     * @param user - пользователь.
     * @since 0.2
     */
    public void addUser(User user) {
//        if (this.users.get(user) == null)
//            this.users.put(user, new ArrayList<>());
        this.users.putIfAbsent(user, new ArrayList<>());  //@since java 8
    }

    /**
     * Метод улеления пользователя из списка пользователей
     * @param user - пользователь.
     * @since 0.1
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * Метод подключнич пользователч к аккаунту.
     * @param passport - номер паспорта пользователя.
     * @param account - аккаунт пользователя.
     * @since 0.1
     */
    public void addAccountToUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                ArrayList<Account> usrAcc = getUserAccounts(user);
                usrAcc.add(account);
                this.users.putIfAbsent(user, usrAcc);
                break;
            }
        }
    }

    /**
     * Метод проверяет актуальность аккаунта, подключенного к пользователю.
     * @param user - пользователь.
     * @param account - проверяемый аккаунт
     * @return - список актуальных аккаунтов
     * @since 0.1
     */
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> accounts = this.users.get(user);
        return accounts.get(accounts.indexOf(account));
    }

    /**
     * возвращает аккаунт пользователя по паспорту и реквизитам (номеру) счета.
     * @param passport - паспорт пользователя.
     * @param srcRequisite - реквизыты (номер) счета.
     * @return - возвращает актуальный аккаунт.
     * since 0.2.
     */
    private Account getActualAccount(String passport, String srcRequisite) {
        ArrayList<Account> accounts = getUserAccounts(passport);
        Account account = new Account();
        for (Account acc : accounts) {
            if (acc.getRequisites().equals(srcRequisite)) {
                account = acc;
            }
        }
        return account;
    }

    /**
     * Удаляем аккаунь (отключаем аккаун от пользователя)
     * @param pasport- пользователь
     * @param account - отключаемый аккаунт
     * @since 0.1
     */
    public void deleteUserAccountFromUser(String pasport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(pasport)) {
                ArrayList<Account> accounts = this.users.get(user);
                accounts.remove(account);
                this.users.replace(user, accounts);
                break;
            }
        }
    }

    /**
     * получить список счетов (аккаунтов) пользователя
     * @param user - интересуемый пользователь
     * @return - список аккаутов, прикрепленных к пользователю
     * @since 0.1
     */
    public ArrayList<Account> getUserAccounts(User user) {
        return  users.get(user);
    }

    /**
     * получить список счетов (аккаунтов) пользователя
     * @param passport - данные паспорта интересуемого пользователя
     * @return - список аккаутов (счетов), прикрепленных к пользователю
     * @since 0.1
     */
    public ArrayList<Account> getUserAccounts(String passport) {
        ArrayList<Account> accounts = new ArrayList<>();
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                accounts = this.users.get(user);
            }
        }
        return accounts;
    }

    /**
     * Метод выполняющий трансфер между пользователями
     * @param srcPassport - пользователь отправитель
     * @param srcRequisite - аккаутн отправителя
     * @param destPassport - пользователт получатель
     * @param dstRequisite - аккаунт получателя
     * @param amount - сумма трансфера
     * @return - возвращает результат успешности операции
     * @since 0.1
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        User srcUser = getUser(srcPassport);
        ArrayList<Account> srcUsrAccLst = getUserAccounts(srcUser);
        User destUser = getUser(destPassport);
        ArrayList<Account> destUsrAccLst = getUserAccounts(destUser);

        return this.users.get(srcUser).contains(srcUsrAccLst)
                && this.users.get(destUser).contains(destUsrAccLst)
                && getActualAccount(srcPassport, srcRequisite).transfer(
                getActualAccount(destPassport, dstRequisite), amount);
    }

    /**
     * Метод позволяет определить пользователя по паспорту
     * @param passport - паспорт  интересующего нас пользователя
     * @return - найденый пользователь по введенному паспорту
     * * @since 0.2
     */
    public User getUser(String passport) {
        User result = new User();
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }


    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}


// Реализовать коллекцию Map для банка
// Реализовать коллекцию Map <User, List<Account>>, обозначающую что у каждого пользователя может
// быть список банковских счетов.
// Необходимо реализовать возможность перечислять деньги, как с одного счёта User на другой счёт
// того же User, так и на счёт другого User.
//public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport,
// String dstRequisite, double amount) - метод для перечисления денег с одного счёта на другой счёт:
//        если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
