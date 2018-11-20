package com.tsekhanovich.functional.practice20;

import java.util.stream.LongStream;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 *
 * Many java developers wrote methods to calculate a factorial value using a recursive or iterative algorithm.
 * It's time to do it with streams.
 * The factorial of n is calculated by the product of integer number from 1 to n (inclusive).
 * The factorial of 0 is equal to 1.
 *
 * Important. Use the given template for your factorial method.
 * Pay attention to type of an argument and the returned value. Please, don't use cycles or recursion.
 */

public class Task1 {

    public static long factorial(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, Math::multiplyExact);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
