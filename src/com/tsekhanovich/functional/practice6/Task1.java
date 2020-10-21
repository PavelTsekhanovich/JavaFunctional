package com.tsekhanovich.functional.practice6;

import java.util.function.Function;

/**
 * @author Pavel Tsekhanovcih 10.11.2018
 * <p>
 * Using closure write a lambda expression that calculates a ∗ x2 + b ∗ x + c where a, b, c are
 * context final variables. They will be available in the context during testing. Note, the result is double.
 * Solution format. Submit your lambda expression in any valid format with ; on the end.
 * <p>
 * Examples: (x, y) -> x + y; (x, y) -> { return x + y; }
 */

public class Task1 {

    public static void main(String[] args) {

        final int a = 2;
        final int b = 3;
        final int c = 4;

        Function<Integer, Double> function1 = x -> a * Math.pow(x, 2) + b * x + c;
        System.out.println(function1.apply(7));

    }
}
