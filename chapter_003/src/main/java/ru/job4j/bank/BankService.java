package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3. Банковские переводы [#10038 #104495].
 * Класс условного банка. Позволяет ввести пользователей и провести между ними перевод (транзакцию)
 * @author Azarkov Maxim.
 * @version 1.0 07.10.2021
 *
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления пользователя. Создается мана с привязкой пользователя и его будущего аккаунта.
     * По умолчанию к этому user добавляется пустой список - new ArrayList<Account>(). Если пользователь отсутствует
     * в списке пользователей, то он вносится в список.
     * @param user - пользователь.
     * @since 1.0 09.10.2021
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
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
     * Возвращается счет по паспорту и реквизитам
     * @param passport паспорт.
     * @param requisite реквизиты
     * @return счет пользователя.
     * @since v.1.0 12.10.2021
     */
    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = getUserAccounts(passport);
        return accounts.stream()
                .filter(acc -> acc.getRequisites().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод добавляет счет к пользователю
     * новый счет (аккаунт)
     * @param passport - номер паспорта пользователя.
     * @param account - аккаунт пользователя.
     * @since 0.3 28.10.2019
     */
    public void addAccount(String passport, Account account) {
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
        List<Account> accounts = this.users.get(user);
        return accounts != null ? accounts.get(accounts.indexOf(account)) : null;
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
    public List<Account> getUserAccounts(User user) {
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
     * @since 1.0 12.10.2021
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                  String destPassport, String dstRequisite, double amount) {
        Account srcUsrAcc = findByRequisite(srcPassport, srcRequisite);
        Account destUsrAcc = findByRequisite(destPassport, dstRequisite);
        return srcUsrAcc != null && destUsrAcc != null && srcUsrAcc.transfer(destUsrAcc, amount);
    }

    /**
     * Поиск по паспорту
     * @param passport - паспорт клиента
     * @return - найденный клиент
     * @since 1.0 07.10.2021
     */
    public User findByPassport(String passport) {
        return this.users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public String toString() {
        return "Bank{" + "accounts=" + users + "}";
    }
}