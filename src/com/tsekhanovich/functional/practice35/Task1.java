package com.tsekhanovich.functional.practice35;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/**
 * @author Pavel Tsekhanovcih 20.11.2018
 *
 * Write three operators:
 *
 * A reduce operator that accepts an initial value (seed) and a combiner function and then returns a new
 * function that combines all values in the given integer range (inclusively)
 * into one integer value (it's a simple form of reduction).
 * In terms of the reduce operator define a sum operator for summing integer values in the given range.
 * In terms of the reduce operator define a product operator for multiplying integer values in the given range.
 * Try not to use Stream API. Write the reducer yourself.
 * To simplify the problem all functions are declared, you need to finish their realization.
 * Look carefully at definition of each operator.
 * During testing all three operators will be tested. The left boundary <= the right boundary.
 */

public class Task1 {

    public static void main(String[] args) {
        System.out.println(sumOperator.applyAsInt(1, 4));
        System.out.println(productOperator.applyAsInt(1, 4));
    }

    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (x, y) -> (z, d) -> IntStream.rangeClosed(z, d).reduce(x, y);

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (left, right) -> left + right);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (left, right) -> left * right);

}
