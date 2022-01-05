package com.wolkowycki.hashing;

public class QuadraticProbing {

    static void printArray(int[] arr) {
        for (int elem : arr) {
            System.out.println(elem + " ");
        }
    }

    static void hash(int[] table, int size, int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int hashValue = arr[i] % size;

            // Insert in the table if there is no collision
            if (table[hashValue] == -1) {
                table[hashValue] = arr[i];
            } else {
                // If there is a collision iterate through all
                // possible quadratic values
                for (int j = 0; j < size; j++) {
                    int newHashValue = (hashValue + j * j) % size;

                    if (table[newHashValue] == -1) {
                        // Break the loop after inserting
                        // the value in the table
                        table[newHashValue] = arr[i];
                        break;
                    }
                }
            }
        }
        printArray(table);
    }

    public static void main(String[] args) {

        int[] arr = {50, 700, 76, 85, 92, 73, 101};
        int n = arr.length;

        int l = 7; // size of the hash table
        int[] hashTable = new int[l];

        for (int i = 0; i < l; i++)
            hashTable[i] = -1;

        // Quadratic probing
        hash(hashTable, l, arr, n);
    }
}
