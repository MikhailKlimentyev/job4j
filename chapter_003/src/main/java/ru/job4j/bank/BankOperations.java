package ru.job4j.bank;

import java.util.ArrayList;
import java.util.Collections;
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
        this.userAccountsListMap.putIfAbsent(user, this.getUserAccounts(user.getPassport()));
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
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                if (entry.getValue() != null) {
                    accounts.addAll(entry.getValue());
                    accounts.add(account);
                    entry.setValue(accounts);
                } else {
                    entry.setValue(Collections.singletonList(account));
                }
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
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                accounts.addAll(entry.getValue());
                accounts.remove(account);
                if (accounts.isEmpty()) {
                    entry.setValue(null);
                    break;
                } else {
                    entry.setValue(accounts);
                    break;
                }
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
        boolean result = false;
        Account srcAccount = null;
        Account destAccount = null;
        List<Account> srcAccounts = new ArrayList<>();
        List<Account> destAccounts = new ArrayList<>();
        int srcAccountIndex = 0;
        int destAccountIndex = 0;
        if (amount <= 0) {
            return result;
        }
        for (Map.Entry<User, List<Account>> entry : this.userAccountsListMap.entrySet()) {
            if (entry.getKey().getPassport().equals(srcPassport)) {
                srcAccounts.addAll(entry.getValue());
                for (Account account : srcAccounts) {
                    if (account.getRequisites().equals(srcRequisite)) {
                        if (account.getValue() - amount >= 0) {
                            srcAccountIndex = srcAccounts.indexOf(account);
                            srcAccount = account;
                            break;
                        } else {
                            return result;
                        }
                    }
                }
            }
            if (entry.getKey().getPassport().equals(destPassport)) {
                destAccounts.addAll(entry.getValue());
                for (Account account : destAccounts) {
                    if (account.getRequisites().equals(dstRequisite)) {
                        destAccountIndex = destAccounts.indexOf(account);
                        destAccount = account;
                        break;
                    }
                }
            }
            if (srcAccount != null && destAccount != null) {
                srcAccounts.set(srcAccountIndex, srcAccount.setValue(srcAccount.getValue() - amount));
                destAccounts.set(destAccountIndex, destAccount.setValue(destAccount.getValue() + amount));
                result = true;
                break;
            }
        }
        return result;
    }
}
