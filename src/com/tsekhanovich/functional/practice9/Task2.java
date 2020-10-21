package com.tsekhanovich.functional.practice9;

import java.util.Objects;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * You need to write your own functional interface (TernaryIntPredicate) and use it with a lambda expression.
 * The interface must have a single non-static (and non-default)
 * method test with three int arguments that returns boolean value.
 * Besides, you need to write a lambda expression with three int arguments using your TernaryIntPredicate.
 * <p>
 * The lambda expression has to return true if all passed values are different otherwise false.
 * The name of the instance is allValuesAreDifferentPredicate. It should be a static field.
 * <p>
 * Important. Use the provided template for your solution. Do not change it!
 */

public class Task2 {

    public static void main(String[] args) {
        TernaryIntPredicate<Integer, Integer, Integer, Boolean> function = (a, b, c) ->
                !Objects.equals(a, b) &&
                        !Objects.equals(b, c) &&
                        !Objects.equals(c, a);

        System.out.println(function.test(1, 2, 3));
        System.out.println(function.test(1, 1, 1));
    }
}

@FunctionalInterface
interface TernaryIntPredicate<A, B, C, R> {

    R test(A a, B b, C c);
}
