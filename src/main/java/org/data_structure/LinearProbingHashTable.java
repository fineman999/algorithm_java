package org.data_structure;

public class LinearProbingHashTable<K, V> {

    private static final float LOAD_FACTOR = 0.6f;
    private Entry<K, V>[] table;

    private int numberOfItems;

    private static final Object REMOVED = new Object();


    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int capacity) {
        table = new Entry[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new Entry<>(null, null);
        }
        numberOfItems = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {

        int indexOfBucket = this.hash(key);

        while (table[indexOfBucket].key != null) {
            if (table[indexOfBucket].key.equals(key)) {
                table[indexOfBucket].value = value;
                return;
            }
            indexOfBucket = (indexOfBucket + 1) % table.length;
        }

        table[indexOfBucket] = new Entry<>(key, value);
        numberOfItems++;

        if (isResizingRequired()) resize();
    }

    public V get(K key) {
        int indexOfBucket = this.hash(key);

        while (table[indexOfBucket].key != null || table[indexOfBucket].key == REMOVED) {
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


    private boolean isResizingRequired() {
        return (float) numberOfItems / table.length > LOAD_FACTOR;
    }


    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        int resizeLength = table.length * 2;
        table = new Entry[resizeLength];
        numberOfItems = 0;

        for (int i = 0; i < resizeLength; i++) {
            table[i] = new Entry<>(null, null);
        }

        for (Entry<K, V> entry : oldTable) {
            if (entry.key != null && entry.key != REMOVED) {
                put(entry.key, entry.value);
            }
        }
    }

    public int size() {
        return numberOfItems;
    }

    public int getCapacity() {
        return table.length;
    }
}
