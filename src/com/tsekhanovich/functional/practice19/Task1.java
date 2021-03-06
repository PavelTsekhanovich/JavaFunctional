package com.tsekhanovich.functional.practice19;

import java.util.stream.IntStream;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * You have two IntStream. The first stream contains even numbers and the second stream contains odd numbers.
 * Create the third stream that contains numbers from both streams which is divisible by 3 and 5.
 * After calling collect(Collectors.toList()) the stream should return sorted list (ascending) of these numbers.
 * Two first suitable numbers in the sorted list must be skipped.
 * <p>
 * Important. You need return a prepared IntStream from a template method, not a list of integers.
 * Pay attention to the method template. Do not change the signature of this method.
 */

public class Task1 {

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream)
                .filter(s -> s % 3 == 0 && s % 5 == 0)
                .sorted()
                .skip(2);
    }

}
