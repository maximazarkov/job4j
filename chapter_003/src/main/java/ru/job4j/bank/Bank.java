// не правильно указан пакет. название не должно иметь имея домена верхнего уровня
//package com;
package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс условного банка. Позволяет ввести пользователей и провести межжу ними перевод (транзакцию)
 * @author Azarkov Maxim.
 * @version 0.3
 */
public class Bank {
    /**
     * список пользователей для обработкки транзакций.
     * @since 0.1
     */
    private Map<User, ArrayList<Account>> users = new TreeMap<>();

    /**
     * метод добавления пользователя. Создается мана с привязкой пользователя и его будущего аккаунта.
     * @param user - пользователь.
     * @since 0.2
     */
    public void addUser(User user) {
//        if (this.users.get(user) == null)
            this.users.put(user, new ArrayList<>());
//        this.users.putIfAbsent(user, new ArrayList<>());  //@since java 8
    }

    /**
     * Метод удаления пользователя из списка пользователей
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
     * @since 0.3 28.10.2019
     */
    public void addAccountToUser(String passport, Account account) {
////  Q: 1. Зачем вам здесь получать всех пользователей, если вы добавляете аккаунт
////  только одному? Замечания из соображений того, что паспорт является уникальным

//A: т.к.данных о пользователе, которые хранятся в Map<> нет в сигнатуре метода
//   то нам нужно найти пользователя на основе маспорта, который передан в параметрах.
//   Соотвеитственно, загоняем Map<> в поток...
        this.users.keySet().stream()
//   ...вытаскиваем нужного нам пользователя по паспорту...
                .filter(passpUser -> passpUser.getPassport().equals(passport))
//   ...затем к этому пользователю добавлям новый счет (аккаунт)
                .map(usrAcc -> getUserAccounts(usrAcc).add(account))
//   ...(попытался применить следующий вариант, результат тот же)...
//                .map(user -> this.users.get(user).add(account))
//   ...в завершение, по сути, холостой метод, т.к. не нашел иного терминального метода.
                .collect(Collectors.toList());
//   Под данную реальзацию написал отдельный метод. Понимаю, что если бы мы
//   хранили данные о пользователе и его счетах в разных коллекциях, не вопрос
//   достаточно было бы прикрутить новый счет только к паспорту. Но Мапу по моему
//   мы добавляли к каком-то из заданий (давно это было). Соотвественно реализация стрима
//   выполнена в данном виде.
    }

    /**
     * Метод проверяет актуальность аккаунта, подключенного к пользователю.
     * @param user - пользователь.
     * @param account - проверяемый аккаунт
     * @return - список актуальных аккаунтов
     * @since 0.3
     */
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> accounts = this.users.get(user);
        return accounts != null ? accounts.get(accounts.indexOf(account)) : null;
    }

    /**
     * возвращает аккаунт пользователя по паспорту и реквизитам (номеру) счета.
     * @param passport - паспорт пользователя.
     * @param srcRequisite - реквизыты (номер) счета.
     * @return - возвращает актуальный аккаунт.
     * since 0.3.
     */
    private Account getActualAccount(String passport, String srcRequisite) {
        ArrayList<Account> accounts = getUserAccounts(passport);
        return accounts.stream()
                .filter(acc -> acc.getRequisites().equals(srcRequisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Удаляем аккаунь (отключаем аккаун от пользователя)
     * @param pasport- пользователь
     * @param account - отключаемый аккаунт
     * @since 0.3
     */
    public void deleteUserAccountFromUser(String pasport, Account account) {
////    Q: 2. Зачем получать пользователе из пользователей. Если он у вас сидит
////    уже в переменой user. Вы у нее должны вызывать remove

//      A: принцип, которым я пользовался тот же, что и в примере выше.
//      Вся проблема, что я работаю с Мапой и пока других методов
//      "вычленения" юзера по паспорту из Мапы я не нашел.
//      Так же поэкперементировал с отдельным тестом
//      и для удобства изменил неверные названия "user" на "acc"
//      в методе .map()
        this.users.keySet().stream()
                .filter(user -> user.getPassport().equals(pasport))
                .map(acc -> this.users.get(acc).remove(account))
                .collect(Collectors.toList());
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
     * @since 0.2 26.10.2019
     */
    public ArrayList<Account> getUserAccounts(String passport) {
        ArrayList<Account> accounts = new ArrayList<>();
        this.users.keySet().stream()
                .filter(passpUser -> passpUser.getPassport().equals(passport))
                .forEach(user -> accounts.addAll(this.users.get(user)));
//                .collect(Collectors.toList());
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
        Account srcUsrAcc = getActualAccount(srcPassport, srcRequisite);
        Account destUsrAcc = getActualAccount(destPassport, dstRequisite);
        return srcUsrAcc != null && destUsrAcc != null && srcUsrAcc.transfer(destUsrAcc, amount);
    }

    /**
     * Метод позволяет определить пользователя по паспорту
     * @param passport - паспорт  интересующего нас пользователя
     * @return - найденый пользователь по введенному паспорту
     * * @since 0.2
     */
    public User getUser(String passport) {
        final User user = this.users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(new User(null, null));
        return user;
    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}