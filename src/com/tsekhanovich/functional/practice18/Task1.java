package com.tsekhanovich.functional.practice18;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * Create a stream that will detect bad words in a text according to a bad words list.
 * All words in the text are divided by whitespaces (always only one whitespace between two words).
 * <p>
 * After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text.
 * The result should be dictionary ordered (in lexicographical order, i.e. sorted) and bad words shouldn't repeat.
 * <p>
 * Important. You need return a prepared stream from the template method, not a list of bad words.
 * Pay attention to the method template. Do not change it!
 */

public class Task1 {

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return badWords.stream()
                .filter(text::contains)
                .distinct()
                .sorted();
    }

}
