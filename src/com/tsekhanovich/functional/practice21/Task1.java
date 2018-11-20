package com.tsekhanovich.functional.practice21;

import java.util.stream.LongStream;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 *
 * Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.
 *
 * Important. Use the provided template for your method.
 * Pay attention to type of an argument and the returned value. Please, don't use cycles.
 */

public class Task1 {

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end).filter(x -> x % 2 != 0).sum();
    }

    public static void main(String[] args) {
        System.out.println(sumOfOddNumbersInRange(2, 5));
    }

}
