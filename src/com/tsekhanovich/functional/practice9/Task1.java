package com.tsekhanovich.functional.practice9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * You have a class Account (number: String, balance: Long, isLocked: boolean), the list accounts of type
 * List<Account> and the method filter(List<T> elems, Predicate<T> predicate) for filtering the given list of type
 * T by the predicate.
 * The class Account has the next methods: getNumber(), getBalance(), isLocked()
 * for getting the values of the corresponding fields.
 * <p>
 * Write a code for filtering the accounts list in two ways:
 * - get list with all non-empty accounts (balance > 0) and save it to the variable nonEmptyAccounts
 * - get all non-locked accounts with too much money (balance >= 100 000 000) and save
 * it to the variable accountsWithTooMuchMoney
 * <p>
 * The class Account, the list accounts (List<Account>) and the method filter(...) will be available during testing.
 * Important. Use the given code template for your solution. Do not change it!
 * <p>
 * Example of use the filter method. The code below gets only even number from the list.
 */

public class Task1 {

    public static final List<Account> ACCOUNTS = new ArrayList<>();

    static {
        ACCOUNTS.add(new Account("NO1", 100L, true));
        ACCOUNTS.add(new Account("NO2", 30L, false));
        ACCOUNTS.add(new Account("NO3", 10000000L, true));
    }

    private static <T> List<T> filter(List<T> inputList, Predicate<T> predicate) {
        return inputList.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Account> nonEmptyAccounts = filter(ACCOUNTS, x -> x.getBalance() > 0);
        List<Account> accountsWithTooMuchMoney = filter(ACCOUNTS, x
                -> x.getBalance() >= 100000000 && !x.isLocked());

        nonEmptyAccounts.stream().forEach(System.out::println);
        accountsWithTooMuchMoney.stream().forEach(System.out::println);
    }
}

class Account {

    private String number;
    private Long balance;
    private boolean isLocked;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Account(String number, Long balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }
}
