package com.wolkowycki.exercises;

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

    public static void main(String[] args) {
        System.out.println(evenSquares(1));
    }
}
