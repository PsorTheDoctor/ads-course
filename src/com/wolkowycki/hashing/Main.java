package com.wolkowycki.hashing;

class Main {
    public static void main(String[] args) {

        // Separate chaining
        HashTable<String, Integer> table = new HashTable<>();
        table.add("this", 1);
        table.add("coder", 2);
        table.add("this", 4);
        table.add("hi", 5);

        System.out.println(table.size());
        System.out.println(table.remove("this"));
        System.out.println(table.remove("this"));
        System.out.println(table.size());
        System.out.println(table.isEmpty());
    }
}
