package com.wolkowycki.exam;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // Problem 2
    private static int getNumberEqual(int[] x, int n, int val) {

        if (n > 0) {
            int index = n - 1;
            int isEqual = x[index] == val ? 1 : 0;
            return isEqual + getNumberEqual(x, index, val);
        }
        return 0;
    }

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

        // Problem 2
        int[] x = {7,4,1,3,5,6,4,8};
        System.out.println(getNumberEqual(x, 8, 4));

        // Problem 6
        String text = "The cattle were running back and forth, but there was no wolf to be seen, heard or smelled, " +
                "so the shepherd decided to take a little nap in a bed of grass and early summer flowers. " +
                "Soon he was awakened by a sound he had never heard before.";
        // String word = mostFrequentWord(text);
        // System.out.println(word);
    }
}
