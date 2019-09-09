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
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().add(account);
                break;
            }
        }
    }

    /**
     * Delete account from user.
     *
     * @param passport the passport
     * @param account  the account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                entry.getValue().remove(account);
            }
        }
    }

    /**
     * Gets user accounts.
     *
     * @param passport the passport
     * @return the user accounts
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = null;
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                accounts = entry.getValue();
                break;
            }
        }
        return accounts;
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
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                List<Account> accounts = entry.getValue();
                for (Account account : accounts) {
                    if (account.getRequisites().equals(requisite)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }
}