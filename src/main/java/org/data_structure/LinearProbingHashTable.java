package org.data_structure;

public class LinearProbingHashTable<K, V> {

    private Entry<K, V>[] table;

    private int numberOfItems;

    private static final Object REMOVED = new Object();


    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int capacity) {
        table = new Entry[capacity];
        numberOfItems = 0;
    }

    private int hash(Object key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {

        int indexOfBucket = this.hash(key);

        while (table[indexOfBucket] != null) {
            if (table[indexOfBucket].key.equals(key)) {
                table[indexOfBucket].value = value;
                return;
            }
            indexOfBucket = (indexOfBucket + 1) % table.length;
        }

        table[indexOfBucket] = new Entry<>(key, value);
        numberOfItems++;
    }

    public V get(K key) {
        int indexOfBucket = this.hash(key);

        while (table[indexOfBucket] != null || table[indexOfBucket].key == REMOVED) {
            if (table[indexOfBucket].key.equals(key)) {
                return table[indexOfBucket].value;
            }
            indexOfBucket = (indexOfBucket + 1) % table.length;
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    public void remove(K key) {
        if (isEmpty()) {
            throw new RuntimeException("Table is empty");
        }

        int indexOfBucket = this.hash(key);

        while (table[indexOfBucket] != null) {
            if (table[indexOfBucket].key.equals(key)) {
                table[indexOfBucket].key = (K) REMOVED;
                table[indexOfBucket].value = null;
                numberOfItems--;
                return;
            }
            indexOfBucket = (indexOfBucket + 1) % table.length;
        }
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }
}
