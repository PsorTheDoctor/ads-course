package com.wolkowycki.hashing;

import java.util.ArrayList;
import java.util.List;

class LinearProbing<K, V> {

    private List<HashNode<K, V>> arr;
    private int capacity;
    private int size;
    private HashNode<K, V> dummyNode;

    LinearProbing() {
        capacity = 20;
        size = 0;
        arr = new ArrayList<>();

        for (int i = 0; i < capacity; i++)
            arr.add(null);
    }

    int hashCode(K key) {
        return (int) key % capacity;
    }

    void insert(K key, V value) {

        HashNode<K, V> temp = new HashNode<>(key, value);
        int hashIndex = hashCode(key);

        // Find next free space
        while (arr.get(hashIndex) != null
                && arr.get(hashIndex).key != key
                && (int) arr.get(hashIndex).key != -1) {
            hashIndex++;
            hashIndex %= capacity;
        }
        // If new node to be inserted increase the current size
        if (arr.get(hashIndex) == null || (int) arr.get(hashIndex).key == -1)
            size++;

        arr.set(hashIndex, temp);
    }

    V delete(K key) {
        int hashIndex = hashCode(key);

        // Find the node with given key
        while (arr.get(hashIndex) != null) {
            // If node found
            if (arr.get(hashIndex).key == key) {
                HashNode<K, V> temp = arr.get(hashIndex);

                // Insert dummy node here for further use
                arr.set(hashIndex, dummyNode);
                size--;
                return temp.value;
            }
            hashIndex++;
            hashIndex %= capacity;
        }
        return null;
    }

    V get(K key) {
        int hashIndex = hashCode(key);
        int counter = 0;

        // Find the node with given key
        while (arr.get(hashIndex) != null) {
            if (counter++ > capacity) // to avoid infinite loop
                return null;

            // If node found return its value
            if (arr.get(hashIndex).key == key)
                return arr.get(hashIndex).value;

            hashIndex++;
            hashIndex %= capacity;
        }
        // If not found return null
        return null;
    }

    int size() { return size; }

    boolean isEmpty() { return size == 0; }

    void display() {
        for (int i = 0; i < capacity; i++) {
            if (arr.get(i) != null && (int) arr.get(i).key != -1)
                System.out.println("key = " + arr.get(i).key
                        + " value = " + arr.get(i).value);
        }
    }
}
