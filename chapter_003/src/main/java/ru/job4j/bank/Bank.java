package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс условного банка. Позволяет ввести пользователей и провести между ними перевод (транзакцию)
 * @author Azarkov Maxim.
 * @version 0.3
 */
public class Bank {
    /**
     * список пользователей для обработки транзакций.
     * @since 0.1
     */
    private final Map<User, ArrayList<Account>> users = new TreeMap<>();

    /**
     * Метод добавления пользователя. Создается мана с привязкой пользователя и его будущего аккаунта.
     * @param user - пользователь.
     * @since 0.2
     */
    public void addUser(User user) {
            this.users.put(user, new ArrayList<>());
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
     * Метод подключим пользователя к аккаунту. Если и пользователь есть в списке клиентов, то для него создается
     * новый счет (аккаунт)
     * @param passport - номер паспорта пользователя.
     * @param account - аккаунт пользователя.
     * @since 0.3 28.10.2019
     */
    public void addAccountToUser(String passport, Account account) {
        this.users.keySet().stream()
                .filter(passportUser -> passportUser.getPassport().equals(passport))
                .map(usrAcc -> getUserAccounts(usrAcc).add(account))
                .collect(Collectors.toList());
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
     * Возвращает аккаунт пользователя по паспорту и реквизитам (номеру) счета.
     * @param passport - паспорт пользователя.
     * @param srcRequisite - реквизиты (номер) счета.
     * @return - возвращает актуальный аккаунт.
     * @since 0.3.
     */
    private Account getActualAccount(String passport, String srcRequisite) {
        ArrayList<Account> accounts = getUserAccounts(passport);
        return accounts.stream()
                .filter(acc -> acc.getRequisites().equals(srcRequisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Удаляем аккаунт (отключаем аккаунт от пользователя)
     * @param passport- пользователь
     * @param account - отключаемый аккаунт
     * @since 0.3
     */
    public void deleteUserAccountFromUser(String passport, Account account) {
        this.users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(acc -> this.users.get(acc).remove(account))
                .collect(Collectors.toList());
    }

    /**
     * Получить список счетов (аккаунтов) пользователя
     * @param user - пользователь, по которому ведется проверка
     * @return - список аккаунтов (счетов), прикрепленных к пользователю
     * @since 0.1
     */
    public ArrayList<Account> getUserAccounts(User user) {
        return  users.get(user);
    }

    /**
     * получить список счетов (аккаунтов) пользователя
     * @param passport - данные паспорта интересуемого пользователя
     * @return - список аккаунтов (счетов), прикрепленных к пользователю
     * @since 0.2 26.10.2019
     */
    public ArrayList<Account> getUserAccounts(String passport) {
        ArrayList<Account> accounts = new ArrayList<>();
        this.users.keySet().stream()
                .filter(passportUser -> passportUser.getPassport().equals(passport))
                .forEach(user -> accounts.addAll(this.users.get(user)));
        return accounts;
    }

    /**
     * Метод выполняющий трансфер между пользователями
     * @param srcPassport - пользователь отправитель
     * @param srcRequisite - аккаунт отправителя
     * @param destPassport - пользователь получатель
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
     * @param passport - паспорт интересующего нас пользователя
     * @return - найденный пользователь по введенному паспорту
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