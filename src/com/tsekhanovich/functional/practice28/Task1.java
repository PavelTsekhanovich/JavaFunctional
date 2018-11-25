package com.tsekhanovich.functional.practice28;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Pavel Tsekhanovcih 18.11.2018
 *
 * You have two classes:
 * Account: number: String, balance: Long
 * Transaction: uuid: String, sum: Long, account: Account
 * Both classes have getters for all fields with the corresponding names
 * (getNumber(), getSum(), getAccount() and so on).
 * Write a collector that calculates the total sum of transactions
 * (long type, not integer) by each account (i.e. by account number).
 * The collector will be applied to a stream of transactions.
 * Classes Transaction and Account will be available during testing. You can create your own classes for local testing.
 * Important. You should write only the collector in any valid formats but without ; on the end.
 * It will be passed as an argument to the collect() method of a stream as shown below.
 */

public class Task1 {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("uuid", 100L, new Account()));

        Map<String, Long> totalSumOfTransByEachAccount = transactions.stream()
                .collect(Collectors.groupingBy(x -> x.getAccount().getNumber(), Collectors.summingLong(Transaction::getSum)));

    }
}

class Account {

    private String number;
    private Long balance;

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
}

class Transaction {

    private String uuid;
    private Long sum;
    private Account account;

    public Transaction(String uuid, Long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

