package com.tsekhanovich.functional.practice5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Pavel Tsekhanovcih 10.11.2018
 *
 * Write a lambda expression that accepts a list of strings and returns new
 * list of distinct strings (without repeating).
 * The order of elements in the result list may be any (elements will be sorted by the testing system).
 * If the input list doesn't contain any strings then the result list should be empty.
 * Hints: it is possible to use sets, maps, lists and so on for helping.
 * Solution format. Submit your lambda expression in any valid format with ; on the end.
 *
 * Examples: x -> x; (x) -> { return x; };
 */

public class Task1 {

    public static void main(String[] args) {

        Function<List<String>, List<String>> function1 = list ->
                list.stream().distinct().sorted().collect(Collectors.toList());

        Function<List<String>, List<String>> function2 = list ->
                new ArrayList<>(new HashSet<>(list));

        System.out.println(function1.apply(Arrays.asList("java", "scala", "java", "clojure", "clojure")));
        System.out.println(function2.apply(Arrays.asList("java", "scala", "java", "clojure", "clojure")));

    }
}
