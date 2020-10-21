package com.tsekhanovich.functional.practice17;

import java.util.stream.LongStream;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * Write a method using Stream API to check the input number is prime or not.
 * Let's agree that input value is always greater than 1 (i.e. 2, 3, 4, 5, ....).
 * Use the provided template for your method.
 * <p>
 * A prime number is a value greater than 1 that has no positive divisors other than 1 and itself.
 * See https://en.wikipedia.org/wiki/Prime_number
 * <p>
 * Important. This problem has a simple and clear solution with streams. Please, do not use cycles.
 */

public class Task1 {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    public static boolean isPrime(final long number) {
        return LongStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(19));
    }

}
