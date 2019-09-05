// не правильно указан пакет. название не должно иметь имея домена верхнего уровня
//package com;
package ru.job4j.bank;

public class Account {

    private double values;
    private String requisites;

    /**конструктор
     */
    public Account() {
    }

    /**
     * Конструктор
     * @param values - сумма денег
     * @param requisites - реквизиты (номер) счета
     */
    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    /**
     * возвращает сумму счета
     * @return сумма счета
     */
    public double getValues() {
        return this.values;
    }

    /**
     * Возвращает номер счета
     * @return - реквизиты (номер) счета
     */
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * выполняет транзакцию межту счетами.
     * @param destination - счет назначение,
     * @param amount- сумма средств.
     * @return - возвращает true, если перевод прошол успешно.
     */
    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0
                && amount < this.values
                && destination != null
                && !this.requisites.equals(destination.requisites)) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + values + ", requisites='" + requisites + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.requisites.equals(account.requisites);
    }

    public int hashCode() {
        return this.requisites.hashCode();
    }
}