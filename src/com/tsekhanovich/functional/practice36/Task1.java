package com.tsekhanovich.functional.practice36;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author Pavel Tsekhanovcih 20.11.2018
 *
 * Write three operators:
 *
 * A reduce operator that accepts an initial value (seed) and a combiner function and then returns a new
 * function that combines all values in the given integer range (inclusively)
 * into one integer value (it's a simple form of reduction).
 * In terms of the reduce operator define a sum operator for summing integer values in the given range.
 * In terms of the reduce operator define a product operator for multiplying integer values in the given range.
 * Try not to use Stream API. Write the reducer yourself.
 * To simplify the problem all functions are declared, you need to finish their realization.
 * Look carefully at definition of each operator.
 * During testing all three operators will be tested. The left boundary <= the right boundary.
 */

public class Task1 {

    private static final Set<User> USERS = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
        return USERS.stream().filter(i -> i.getLogin().equals(login)).findFirst();
    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin).map(User::getAccount)
                .map(Account::getBalance)
                .filter(i -> i > 0)
                .ifPresent(i -> System.out.println(userLogin + ": " + i));
    }

    class Account {
        long balance;
        UUID guid;

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public UUID getGuid() {
            return guid;
        }

        public void setGuid(UUID guid) {
            this.guid = guid;
        }
    }

    class User {
        String login;
        Account account;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
    }

}
