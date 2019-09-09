package ru.job4j.bank;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOperationsTest {

    @Test
    public void whenAddUserThenMapWithUser() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, new ArrayList<>());
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenUserDeletedWhenAddUserThenMapWithUser() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        bankOperations.deleteUser(ivan);
        bankOperations.addUser(ivan);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, new ArrayList<>());
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void whenAdd2UsersThenMapWith2Users() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "666");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, new ArrayList<>());
        expectedMap.put(petr, new ArrayList<>());
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserWhenAddTheSameUserThenMapWithInitialUser() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        bankOperations.addUser(ivan);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, new ArrayList<>());
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserWhenDeleteUserThenEmptyMap() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        bankOperations.deleteUser(ivan);
        assertThat(bankOperations.getUserAccountsListMap().size(), is(0));
    }

    @Test
    public void givenMapWith2UsersWhenDeleteUserThenMapWithAnotherUser() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "666");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        bankOperations.deleteUser(ivan);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(petr, new ArrayList<>());
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenEmptyMapWhenDeleteUserThenEmptyMap() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.deleteUser(ivan);
        assertThat(bankOperations.getUserAccountsListMap().size(), is(0));
    }

    @Test
    public void givenMapWithUserWhenAddAccountToUserThenAccountAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account account = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(account));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenDeleteAccountFromUserWhenAddAccountToUserThenAccountAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account account = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        bankOperations.deleteAccountFromUser(ivan.getPassport(), account);
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(account));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserWhenAdd2AccountsToUserThen2AccountsAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account firstAccount = new Account(17.0, "74747");
        Account secondAccount = new Account(15.5, "74747rfr");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), firstAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Arrays.asList(firstAccount, secondAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void whenAddAccountsTo2UsersThenAccountsAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        Account ivanAccount = new Account(17.0, "74747");
        Account petrFirstAccount = new Account(15, "4rfr");
        Account petrSecondAccount = new Account(15, "4rfr");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrFirstAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrSecondAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(ivanAccount));
        expectedMap.put(petr, Arrays.asList(petrFirstAccount, petrSecondAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserWhenAdd2IdenticalAccountsToUserThen2IdenticalAccountsAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account firstAccount = new Account(17.0, "74747");
        Account secondAccount = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), firstAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Arrays.asList(secondAccount, secondAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenEmptyMapWhenSpecifyInvalidPassportInOrderToAddAccountThenAccountsNotAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account account = new Account(17.0, "74747");
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserWhenSpecifyInvalidPassportInOrderToAddAccountThenAccountsNotAdded() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        Account ivanAccount = new Account(17.0, "74747");
        Account petrAccount = new Account(15, "4rfr");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(ivanAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserHavingSingleAccountWhenDeleteAccountThenUserHasNoAccounts() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account account = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        bankOperations.deleteAccountFromUser(ivan.getPassport(), account);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, new ArrayList<>());
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserHavingSeveralAccountsWhenDeleteAccountThenUserHasAnotherAccount() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account firstAccount = new Account(17.0, "74747");
        Account secondAccount = new Account(2.5, "666");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), firstAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondAccount);
        bankOperations.deleteAccountFromUser(ivan.getPassport(), firstAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(secondAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void givenMapWithUserHaving2IdenticalAccountsWhenDeleteAccountThenUserHasAnotherAccount() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account firstAccount = new Account(17.0, "74747");
        Account secondAccount = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), firstAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondAccount);
        bankOperations.deleteAccountFromUser(ivan.getPassport(), firstAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(secondAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void whenDeleteOneUserAccountThenUserHasNoAccountsAndAnotherUserHasNoChangesAccounts() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "666");
        Account ivanAccount = new Account(17.0, "74747");
        Account firstPetrAccount = new Account(2.5, "666");
        Account secondPetrAccount = new Account(8, "4444");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.deleteAccountFromUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), firstPetrAccount);
        bankOperations.addAccountToUser(petr.getPassport(), secondPetrAccount);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, new ArrayList<>());
        expectedMap.put(petr, Arrays.asList(firstPetrAccount, secondPetrAccount));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void whenDeleteAccountSpecifyingInvalidPassportThenAccountNotDeleted() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account account = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        bankOperations.deleteAccountFromUser(ivan.getPassport() + "1", account);
        Map<User, List<Account>> expectedMap = new HashMap<>();
        expectedMap.put(ivan, Collections.singletonList(account));
        assertThat(bankOperations.getUserAccountsListMap(), is(expectedMap));
    }

    @Test
    public void whenUserHasOneAccountThenGetAccount() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        Account account = new Account(17.0, "74747");
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()), is(Collections.singletonList(account)));
    }

    @Test
    public void whenUserHasSeveralAccountsThenGetAccounts() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        Account firstAccount = new Account(17.0, "74747");
        Account secondAccount = new Account(25.3, "333");
        bankOperations.addAccountToUser(ivan.getPassport(), firstAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondAccount);
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()), is(Arrays.asList(firstAccount, secondAccount)));
    }

    @Test
    public void whenUserHasNoAccountThenGetNoAccount() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        bankOperations.addUser(ivan);
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()), is(new ArrayList<>()));
    }

    @Test
    public void whenUserAccountDeletedThenGetNoAccount() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        Account account = new Account(17.0, "74747");
        bankOperations.addUser(ivan);
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        bankOperations.deleteAccountFromUser(ivan.getPassport(), account);
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()), is(new ArrayList()));
    }

    @Test
    public void whenSeveralUsersWithAccountsThenGetAccounts() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        Account firstIvanAccount = new Account(17.0, "74747");
        Account secondIvanAccount = new Account(8.5, "5555");
        Account petrAccount = new Account(3, "rfgrgf");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        bankOperations.addAccountToUser(ivan.getPassport(), firstIvanAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondIvanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()),
            is(Arrays.asList(firstIvanAccount, secondIvanAccount)));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()),
            is(Collections.singletonList(petrAccount)));
    }

    @Test
    public void whenGetAccountsWithSpecifyingInvalidPassportThenNull() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        Account account = new Account(17.0, "74747");
        bankOperations.addAccountToUser(ivan.getPassport(), account);
        assertThat(bankOperations.getUserAccounts(petr.getPassport()), is(nullValue()));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyThenTrueAndAccountValueChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = 2.5;
        assertTrue(bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(), ivanRequisites,
            amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue - amount));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue + amount));
    }

    @Test
    public void given3UsersWhenTransferMoneyBetween2UsersThenTrueAndAccountValueChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        User alex = new User("Alex", "666");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        bankOperations.addUser(alex);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        String alexRequisites = "666";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        double alexValue = 1000.65;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        Account alexAccount = new Account(alexValue, alexRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        bankOperations.addAccountToUser(alex.getPassport(), alexAccount);
        double amount = 2.5;
        assertTrue(bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(), ivanRequisites,
            amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue - amount));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue + amount));
        assertThat(bankOperations.getUserAccounts(alex.getPassport()).get(0).getValue(),
            is(alexValue));
    }

    @Test
    public void given2UsersWithSeveralAccountsWhenTransferMoneyThenTrueAndAccountValueChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String firstIvanRequisites = "8888";
        String secondIvanRequisites = "88884";
        String firstPetrRequisites = "74747";
        String secondPetrRequisites = "74747ff";
        double firstIvanValue = 3.5;
        double secondIvanValue = 100500;
        double firstPetrValue = 17.0;
        double secondPetrValue = 100501.6;
        Account firstIvanAccount = new Account(firstIvanValue, firstIvanRequisites);
        Account secondIvanAccount = new Account(secondIvanValue, secondIvanRequisites);
        Account firstPetrAccount = new Account(firstPetrValue, firstPetrRequisites);
        Account secondPetrAccount = new Account(secondPetrValue, secondPetrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), firstIvanAccount);
        bankOperations.addAccountToUser(ivan.getPassport(), secondIvanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), firstPetrAccount);
        bankOperations.addAccountToUser(petr.getPassport(), secondPetrAccount);
        double amount = 2.5;
        assertTrue(bankOperations.transferMoney(ivan.getPassport(), secondIvanRequisites, petr.getPassport(),
            firstPetrRequisites, amount));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(1).getValue(),
            is(secondIvanValue - amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(firstPetrValue + amount));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(firstIvanValue));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(1).getValue(),
            is(secondPetrValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWith0ValueThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = 0;
        assertFalse(bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(), ivanRequisites,
            amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithNegativeValueThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = -1.0;
        assertFalse(bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(), ivanRequisites,
            amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithInvalidSourceRequisitesThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = -1.0;
        assertFalse(
            bankOperations.transferMoney(petr.getPassport(), petrRequisites + "_invalid", ivan.getPassport(),
                ivanRequisites, amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithInvalidDestinationRequisitesThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = -1.0;
        assertFalse(
            bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(),
                ivanRequisites + "_invalid", amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithInvalidSourcePassportThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = -1.0;
        assertFalse(
            bankOperations.transferMoney(petr.getPassport() + "_invalid", petrRequisites, ivan.getPassport(),
                ivanRequisites, amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithInvalidDestinationPassportThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = -1.0;
        assertFalse(
            bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport() + "_invalid",
                ivanRequisites, amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithAmountExceedSourceAmountThenFalseAndAccountValuesNotChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = 17.01;
        assertFalse(
            bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(),
                ivanRequisites, amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue));
    }

    @Test
    public void given2UsersWithSingleAccountsWhenTransferMoneyWithAmountEqualToSourceAmountThenTrueAndAccountValueChanged() {
        BankOperations bankOperations = new BankOperations();
        User ivan = new User("Ivan", "12345");
        User petr = new User("Petr", "333");
        bankOperations.addUser(ivan);
        bankOperations.addUser(petr);
        String ivanRequisites = "8888";
        String petrRequisites = "74747";
        double ivanValue = 3.5;
        double petrValue = 17.0;
        Account ivanAccount = new Account(ivanValue, ivanRequisites);
        Account petrAccount = new Account(petrValue, petrRequisites);
        bankOperations.addAccountToUser(ivan.getPassport(), ivanAccount);
        bankOperations.addAccountToUser(petr.getPassport(), petrAccount);
        double amount = 17.0;
        assertTrue(bankOperations.transferMoney(petr.getPassport(), petrRequisites, ivan.getPassport(), ivanRequisites,
            amount));
        assertThat(bankOperations.getUserAccounts(petr.getPassport()).get(0).getValue(),
            is(petrValue - amount));
        assertThat(bankOperations.getUserAccounts(ivan.getPassport()).get(0).getValue(),
            is(ivanValue + amount));
    }
}
