package com.tsekhanovich.functional.practice26;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Tsekhanovcih 13.11.2018
 * <p>
 * Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.
 * <p>
 * Important. You should write only the collector in any valid formats but without ; on the end.
 * It will be passed as an argument to the collect() method of a stream as shown below.
 */

public class Task1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3);
        long val = numbers.stream().collect(Collectors.reducing(1, Math::multiplyExact));
        System.out.println(val);
    }
}
