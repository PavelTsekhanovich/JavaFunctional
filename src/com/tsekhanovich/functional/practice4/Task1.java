package com.tsekhanovich.functional.practice4;

import java.util.function.BiFunction;
import java.util.stream.LongStream;

/**
 * @author Pavel Tsekhanovcih 10.11.2018
 * <p>
 * Write a lambda expression that accepts two long arguments as a range borders and
 * calculates (returns) production of all numbers in this range (inclusively).
 * It's guaranteed that 0 <= left border <= right border. if left border == right border then the result is any border.
 * Solution format. Submit your lambda expression in any valid format with ; on the end.
 * <p>
 * Examples: (x, y) -> x + y; (x, y) -> { return x + y; };
 */

public class Task1 {

    public static void main(String[] args) {
        BiFunction<Long, Long, Long> function = (x, y) ->
                LongStream.rangeClosed(x, y).reduce(1L, Math::multiplyExact);
        System.out.println(function.apply(3L, 5L));
    }
}
