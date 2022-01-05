package com.wolkowycki.hashing;

class Main {
    public static void main(String[] args) {

        LinearProbing<Integer, Integer> lp = new LinearProbing<>();

        lp.insert(1, 1);
        lp.insert(2, 2);
        lp.insert(2, 3);
        lp.display();

        System.out.println(lp.size());
        System.out.println(lp.delete(2));
        System.out.println(lp.size());
        System.out.println(lp.isEmpty());
        System.out.println(lp.get(2));
    }
}
