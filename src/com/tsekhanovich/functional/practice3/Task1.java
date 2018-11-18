package com.tsekhanovich.functional.practice3;

import java.util.stream.Stream;

/**
 * @author Pavel Tsekhanovcih 10.11.2018
 *
 * Write a lambda expression that accepts seven (!) string arguments and
 * returns a string in upper case concatenated from all of them (in the order of arguments).
 * Note. The correct solution may not work in your local environment because you don't
 * have suitable functional interface. The testing system has the interface and can test your solution.
 * Solution format. Submit your lambda expression with seven arguments in any valid format with ; on the end.
 *
 * Examples (only with two args): (x, y)  -> x + y; (x, y) -> { return x + y; };
 */

public class Task1 {

    public static void main(String[] args) {
        Strings<String, String, String, String, String, String, String, String> string1 =
                (s1, s2, s3, s4, s5, s6, s7) ->
                        (s1 + s2 + s3 + s4 + s5 + s6 + s7).toUpperCase();

        Strings<String, String, String, String, String, String, String, String> string2 =
                (a, b, c, d, e, r, t) ->
                        Stream.of(a, b, c, d, e, r, t).reduce("", String::concat).toUpperCase();

        Strings<String, String, String, String, String, String, String, String> string3 =
                (a, b, c, d, e, f, g) ->
                        Stream.of(a, b, c, d, e, f, g).map(String::toUpperCase).reduce("", String::concat);

        System.out.println(string1.apply("A", "B", "C", "D", "E", "F", "G"));
        System.out.println(string2.apply("A", "B", "C", "D", "E", "F", "G"));
        System.out.println(string3.apply("A", "B", "C", "D", "E", "F", "G"));
    }
}

@FunctionalInterface
interface Strings<A, B, C, D, E, F, G, R> {

    R apply(A a, B b, C c, D d, E e, F f, G g);
}
