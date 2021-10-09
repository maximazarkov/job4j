package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс аккаунт содержит номер счета (реквизитов) и баланс на данном счете.
 * @author Azarkov Maxim.
 * @version 1.0 07.10.2021
 */
public class Account {
    private double balance;
    private String requisites;

    /**
     * Конструктор
     * @param balance - сумма денег
     * @param requisites - реквизиты (номер) счета
     */
    public Account(String requisites, double balance) {
        this.balance = balance;
        this.requisites = requisites;
    }

    /**
     * Возвращает сумму денег на счете
     * @return сумма счета
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Вносит сумму денег на счет
     * @param balance сносимая сумма денег
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    /**
     * Возвращает номер счета
     * @return - реквизиты (номер) счета
     */
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Выполняет транзакцию между счетами.
     * @param destination - счет назначение,
     * @param amount- сумма средств.
     * @return - возвращает true, если перевод прошел успешно.
     */
    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0
                && amount < this.balance
                && destination != null
                && !this.requisites.equals(destination.requisites)) {
            success = true;
            this.balance -= amount;
            destination.balance += amount;
        }
        return success;
    }


    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", requisites='" + requisites + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, requisites);
    }
}