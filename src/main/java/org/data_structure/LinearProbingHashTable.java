package org.data_structure;

public class LinearProbingHashTable<K, V> {
    private final Entry<K, V>[] table;

    private int numberOfItems;

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

        while (table[indexOfBucket] != null) {
            if (table[indexOfBucket].key.equals(key)) {
                return table[indexOfBucket].value;
            }
            indexOfBucket = (indexOfBucket + 1) % table.length;
        }
        return null;
    }

    public Entry<K, V> remove(K key) {
        if (isEmpty()) {
            throw new RuntimeException("Table is empty");
        }

        int indexOfBucket = this.hash(key);

        while (table[indexOfBucket] != null) {
            if (table[indexOfBucket].key.equals(key)) {
                Entry<K, V> retunEntry = table[indexOfBucket];
                table[indexOfBucket] = null;
                numberOfItems--;
                return retunEntry;
            }
            indexOfBucket = (indexOfBucket + 1) % table.length;
        }
        return null;
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }
}
