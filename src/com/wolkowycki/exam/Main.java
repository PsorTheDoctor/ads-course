package com.wolkowycki.exam;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // Problem 6
    private static String mostFrequentWord(String text) {

        String[] words = text.split(" ");

        Map<String, Integer> newWords = new HashMap<>();

        int mostOccurrences = 1;
        String mostFrequentWord = "";

        for (String word : words) {
            word = word.toLowerCase();

            char lastChar = word.charAt(word.length() - 1);
            if (lastChar == ',' || lastChar == '.')
                word = word.substring(0, word.length() - 2);

            if (!newWords.containsKey(word)) {
                newWords.put(word, 1);
            } else {
                int occurrences = newWords.get(word) + 1;
                newWords.replace(word, occurrences);

                if (occurrences > mostOccurrences) {
                    mostOccurrences = occurrences;
                    mostFrequentWord = word;
                }
            }
        }
        return mostFrequentWord;
    }

    public static void main(String[] args) {

        String text = "The cattle were running back and forth, but there was no wolf to be seen, heard or smelled, " +
                "so the shepherd decided to take a little nap in a bed of grass and early summer flowers. " +
                "Soon he was awakened by a sound he had never heard before.";
        String word = mostFrequentWord(text);
        System.out.println(word);
    }
}
