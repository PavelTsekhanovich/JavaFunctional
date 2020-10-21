package com.tsekhanovich.functional.practice2;

/**
 * @author Pavel Tsekhanovcih 09.11.2018
 * <p>
 * Write a lambda expression that accepts a long value and returns a next even number.
 * It is guaranteed an input number is non-negative.
 * Solution format. Submit your lambda expression in any valid format with ; on the end.
 * <p>
 * Examples: x -> x; (x) -> x; (x) -> { return x; };
 */

public class Task1 {

    public static void main(String[] args) {

        Numbers example1 = Math::max;
        Numbers example2 = (x, y) -> x > y ? x : y;
        Numbers example3 = (x, y) -> {
            if (x > y) return x;
            else return y;
        };

        System.out.println(example1.max(7, 9));
        System.out.println(example2.max(7, 9));
        System.out.println(example3.max(7, 9));

    }
}

interface Numbers {

    int max(int a, int b);
}
