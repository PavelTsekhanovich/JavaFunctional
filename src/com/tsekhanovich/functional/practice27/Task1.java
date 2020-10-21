package com.tsekhanovich.functional.practice27;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Pavel Tsekhanovcih 13.11.2018
 * <p>
 * Write a collector that partitions all words in a stream into two groups:
 * palindromes (true) and usual words (false). The collector should return Map<Boolean, List<String>>.
 * All input words will be in the same case (lower).
 * <p>
 * Let's remind, a palindrome is a word or phrase which reads the same backward or forward,
 * such as noon or level. In our case, a palindrome is always a word.
 * For details, see https://en.wikipedia.org/wiki/Palindrome
 * <p>
 * Hint: the method reverse() of StringBuilder may help you.
 * <p>
 * Important. You should write only the collector in any valid formats but without ; on the end.
 * It will be passed as an ﻿argument to the collect() method of a stream as shown below.
 */

public class Task1 {

    public static void main(String[] args) {
        String[] words = {"aaaa", "aaa", "a", "aa"};
        Map<Boolean, List<String>> palindromeOrNoMap = Arrays.stream(words)
                .collect(Collectors.partitioningBy(a -> a.equals(new StringBuilder(a).reverse().toString())));
        System.out.println(palindromeOrNoMap);
    }
}
