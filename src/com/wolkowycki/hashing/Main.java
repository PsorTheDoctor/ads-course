package com.wolkowycki.hashing;

class Main {
    public static void main(String[] args) {

//        LinearProbing<Integer, Integer> lp = new LinearProbing<>();
//
//        lp.insert(1, 1);
//        lp.insert(2, 2);
//        lp.insert(2, 3);
//        lp.display();
//
//        System.out.println(lp.size());
//        System.out.println(lp.delete(2));
//        System.out.println(lp.size());
//        System.out.println(lp.isEmpty());
//        System.out.println(lp.get(2));

        DoubleHashing dh = new DoubleHashing(100);

        dh.insert("prime", 97);
        dh.insert("even", 96);
        dh.insert("odd", 95);

        dh.printHashTable();
    }
}
