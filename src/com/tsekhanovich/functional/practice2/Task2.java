package com.tsekhanovich.functional.practice2;

import java.util.function.Function;

/**
 * @author Pavel Tsekhanovcih 09.11.2018
 *
 * Write a lambda expression that accepts a long value and returns a next even number.
 * It is guaranteed an input number is non-negative.
 * Solution format. Submit your lambda expression in any valid format with ; on the end.
 *
 * Examples: x -> x; (x) -> x; (x) -> { return x; };
 */

public class Task2 {

    public static void main(String[] args) {
        Function<Long, Long> nextEven = x ->
                (x + 1) % 2 == 0 ? x + 1 : x + 2;

        Function<Long, Long> nextEven2 = x ->
                x + (2 - x % 2);

        System.out.println(nextEven.apply(2L));
        System.out.println(nextEven2.apply(2L));
    }
}