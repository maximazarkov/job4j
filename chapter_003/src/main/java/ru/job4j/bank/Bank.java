// не правильно указан пакет. название не должно иметь имея домена верхнего уровня
//package com;
package ru.job4j.bank;

import ru.job4j.sortuser.User;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Bank {
    /**
     * список пользователей для обработкки транзакций.
     */
    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    /**
     * метод добавления пользователя. Создается мана с привязкой пользователя и его будущего аккаунта.
     * @param user - пользователь.
     */
    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    /**
     * Метод улеления пользователя из списка пользователей
     * @param user - пользователь.
     */
    public void delete(User user) {
        this.treemap.remove(user);
    }

    /**
     * Метод подключнич пользователч к аккаунту.
     * @param user - имя пользователя.
     * @param account - аккаунт пользователя.
     */
    public void add(User user, Account account) {
        this.treemap.get(user).add(account);
    }

    /**
     * Метод проверяет актуальность аккаунта, подключенного к пользователю.
     * @param user - пользователь.
     * @param account - проверяемый аккаунт
     * @return - список актуальных аккаунтов
     */
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    /**
     * Удаляем аккаунь (отключаем аккаун от пользователя)
     * @param user - пользователь
     * @param account - отключаемый аккаунт
     */
    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    /**
     * получить аккаунт пользователя
     * @param user - интересуемый пользователь
     * @return - список аккаутов, прикрепленных к пользователю
     */
    public List<Account> getAccounts(User user) {
        return this.treemap.get(user);
    }

    /**
     * Метод выполняющий трансфер между пользователями
     * @param user1 - пользователь отправитель
     * @param account1 - аккаутн отправителя
     * @param user2 - пользователт получатель
     * @param account2 - аккаунт получателя
     * @param amount - сумма трансфера
     * @return - возвращает результат успешности операции
     */
    public boolean transfer(User user1, Account account1,
                            User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}