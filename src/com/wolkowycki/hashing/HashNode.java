package com.wolkowycki.hashing;

// A node of chains
class HashNode<K, V> {
    K key;
    V value;
    int hashCode;

    HashNode<K, V> next;

    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    HashNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
