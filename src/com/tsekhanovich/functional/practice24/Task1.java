package com.tsekhanovich.functional.practice24;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Pavel Tsekhanovcih 13.11.2018
 * <p>
 * You have two classes:
 * Transaction: uuid: String,  state: State (CANCELED, FINISHED, PROCESSING), sum: Long, created: Date
 * Account: number: String, balance: Long, transactions: List<Transaction>
 * Both classes have getters for all fields with the corresponding names
 * (getState(), getSum(), getTransactions() and so on).
 * Write a method using Stream API that calculates the total sum of canceled transactions
 * for all non-empty accounts (balance > 0). Perhaps, flatMap method can help you to implement it.
 * Classes Transaction, Account and enum State will be available during testing.
 * You can define your own classes for local testing.
 * Important. Use the given template for your method.
 * Pay attention to type of an argument and the returned value. Please, use only Stream API, no cycles.
 */

public class Task1 {

    private final static List<Account> ACCOUNTS = new ArrayList<>();
    private final static List<Transaction> TRANSACTIONAL = new ArrayList<>();

    static {
        TRANSACTIONAL.add(new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a",
                State.CANCELED, 1000L, new Date()));
        ACCOUNTS.add(new Account("1001", 1000L, TRANSACTIONAL));
    }


    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> a.getBalance() > 0)
                .flatMap(a -> a.getTransactions()
                        .stream()
                        .filter(t -> t.getState() == State.CANCELED))
                .mapToLong(Transaction::getSum).sum();
    }

    public static void main(String[] args) {
        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(ACCOUNTS));
    }

}

enum State {

    CANCELED,
    FINISHED,
    PROCESSING
}

class Transaction {

    private String uuid;
    private State state;
    private Long sum;
    private Date created;

    public Transaction(String uuid, State state, Long sum, Date created) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.created = created;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

class Account {

    private String number;
    private Long balance;
    private List<Transaction> transactions;

    public Account(String number, Long balance, List<Transaction> transactions) {
        this.number = number;
        this.balance = balance;
        this.transactions = transactions;
    }

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
