package com.wolkowycki.exercises;

import java.util.Comparator;
import java.util.Vector;

public class Main {
    // Returns the sum of the first n natural numbers
    static int sum(int n) {
        if (n < 1) {
            return n;
        }
        return n + sum(n - 1);
    }

    // Returns the sum of the first n even numbers' squares
    static int evenSquares(int n) {
        if (n > 0) {
            int even = n * 2;
            return even * even + evenSquares(n - 1);
        }
        return 0;
    }

    // Returns the nth Fibonacci number
    static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }

    // Returns true if string s with the length l contains
    // char c; otherwise false
    static boolean linear(String s, char c, int l) {
        if (l > 0) {
            if (c == s.charAt(l - 1)) {
                return true;
            } else {
                return linear(s, c, l - 1);
            }
        }
        return false;
    }

    // A table holds n sorted numbers.
    // The task is to determine if the table contains two numbers
    // whose sum is equal to the value of parameter x.
    static boolean contains(int[] array, int x) {

        int n = array.length;
        int leftPivot = 0;
        int rightPivot = 0;

        // The sum of left and right pivots must be lower than n - 1,
        // because it ensures they aren't refer to the same number
        while (leftPivot + rightPivot < n - 1) {
            int left = array[leftPivot];
            int right = array[n - rightPivot - 1];

            if (left + right == x) {
                return true;
            } else if (left + right < x) {
                leftPivot++;
            } else {
                rightPivot++;
            }
        }
        return false;
    }

    private static Vector<Integer> sort(Vector<Integer> v) {
        v.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return v;
    }

    static boolean areAnagrams(String s1, String s2) {

        boolean areAnagrams = false;

        if (s1.length() == s2.length()) {
            Vector<Integer> v1 = new Vector<>();
            Vector<Integer> v2 = new Vector<>();

            for (int i = 0; i < s1.length(); i++) {
                v1.add((int) s1.charAt(i));
                v2.add((int) s2.charAt(i));
            }
            if (sort(v1).equals(sort(v2))) {
                areAnagrams = true;
            }
        }
        return areAnagrams;
    }

    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4};
        System.out.println(contains(a, 7));
        System.out.println(areAnagrams("least", "steal"));
    }
}
