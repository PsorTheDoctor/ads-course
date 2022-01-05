package com.wolkowycki.hashing;

class DoubleHashing {

    private int hashTableSize;
    private int size;
    private HashNode[] table;
    private int totalPrimeSize;

    DoubleHashing(int tableSize) {
        size = 0;
        hashTableSize = tableSize;
        table = new HashNode[hashTableSize];

        for (int i = 0; i < hashTableSize; i++)
            table[i] = null;

        totalPrimeSize = getPrime();
    }

    int getPrime() {
        for (int i = hashTableSize - 1; i >= 1; i--) {
            int cnt = 0;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0)
                    cnt++;
            }
            if (cnt == 0 )
                return i;
        }
        return 3;
    }

    int size() { return size; }

    boolean isEmpty() { return size == 0; }

    void makeEmpty() {
        size = 0;
        for (int i = 0; i < hashTableSize; i++)
            table[i] = null;
    }

    int getKey(String key) {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);

        while(table[hash1] != null && !table[hash1].key.equals(key)) {
            hash1 += hash2;
            hash1 %= hashTableSize;
        }
        return (int) table[hash1].value;
    }

    void insert(String key, int value) {
        if (size == hashTableSize)
            System.out.println("Table is full.");

        int hash1 = myHash1(key);
        int hash2 = myHash2(key);

        while (table[hash1] != null) {
            hash1 += hash2;
            hash1 %= hashTableSize;
        }
        table[hash1] = new HashNode<>(key, value);
        size++;
    }

    void remove(String key) {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);

        while (table[hash1] != null && !table[hash1].key.equals(key)) {
            hash1 += hash2;
            hash1 %= hashTableSize;
        }
        table[hash1] = null;
        size--;
    }

    // Gives a hash value for a given string
    // based on linear probing
    private int myHash1(String s) {
        int myHashVal = s.hashCode();
        myHashVal %= hashTableSize;

        if (myHashVal < 0)
            myHashVal += hashTableSize;

        return myHashVal;
    }

    // Now after linear probing, quadratic probing is used in which
    // two myHash functions are used as it is double chaining
    private int myHash2(String s) {
        return totalPrimeSize - myHash1(s) % totalPrimeSize;
    }

    void printHashTable() {
        for (int i = 0; i < hashTableSize; i++) {
            if (table[i] != null)
                System.out.println(table[i].key + " " + table[i].value);
        }
    }
}
