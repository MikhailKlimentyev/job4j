package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOperations {

    private Map<User, List<Account>> userAccountsListMap = new HashMap<>();

    /**
     * Gets user accounts list map.
     *
     * @return the user accounts list map
     */
    public Map<User, List<Account>> getUserAccountsListMap() {
        return userAccountsListMap;
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        this.userAccountsListMap.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Delete user.
     *
     * @param user the user
     */
    public void deleteUser(User user) {
        this.userAccountsListMap.remove(user);
    }

    /**
     * Add account to user.
     *
     * @param passport the passport
     * @param account  the account
     */
    public void addAccountToUser(String passport, Account account) {
        this.userAccountsListMap.entrySet()
            .stream()
            .filter(entry -> entry.getKey().getPassport().equals(passport))
            .findFirst()
            .ifPresent(entry -> entry.getValue().add(account));
    }

    /**
     * Delete account from user.
     *
     * @param passport the passport
     * @param account  the account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.userAccountsListMap.entrySet()
            .stream()
            .filter(entry -> entry.getKey().getPassport().equals(passport))
            .findFirst()
            .ifPresent(entry -> entry.getValue().remove(account));
    }

    /**
     * Gets user accounts.
     *
     * @param passport the passport
     * @return the user accounts
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userAccountsListMap.entrySet()
            .stream()
            .filter(entry -> entry.getKey().getPassport().equals(passport))
            .map(entry -> entry.getValue())
            .findFirst()
            .orElse(null);
    }

    /**
     * Transfer money boolean.
     *
     * @param srcPassport  the src passport
     * @param srcRequisite the src requisite
     * @param destPassport the dest passport
     * @param dstRequisite the dst requisite
     * @param amount       the amount
     * @return the boolean
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite,
                                 double amount) {
        if (0 >= amount) {
            return false;
        }
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, dstRequisite);
        if (srcAccount != null && destAccount != null && 0 <= srcAccount.getValue() - amount) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            return true;
        }
        return false;
    }

    private Account getAccount(String passport, String requisite) {
        return this.userAccountsListMap.entrySet()
            .stream()
            .filter(entry -> entry.getKey().getPassport().equals(passport))
            .map(entry -> entry.getValue())
            .flatMap(accounts -> accounts.stream())
            .filter(account -> account.getRequisites().equals(requisite))
            .findFirst()
            .orElse(null);
    }
}