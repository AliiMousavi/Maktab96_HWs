package Q4.HashMap;

import Q4.HashMap.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] entries;
    private int size;

    public MyHashMap() {
        this.entries = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];

        if (entry == null) {
            entries[index] = new Entry<>(key, value);
            size++;
        } else {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
            } else {
                Entry<K, V> newEntry = new Entry<>(key, value);
                newEntry.setNext(entry);
                entries[index] = newEntry;
                size++;
            }
        }

        if ((double) size / entries.length > LOAD_FACTOR) {
            resize();
        }
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = entries[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.getNext();
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List<V> getAllValues() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                values.add(entry.getValue());
                entry = entry.getNext();
            }
        }

        return values;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % entries.length;
    }

    private void resize() {
        int newCapacity = entries.length * 2;
        Entry<K, V>[] newEntries = new Entry[newCapacity];

        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                int newIndex = getIndex(entry.getKey());
                Entry<K, V> nextEntry = entry.getNext();
                entry.setNext(newEntries[newIndex]);
                newEntries[newIndex] = entry;
                entry = nextEntry;
            }
        }

        entries = newEntries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object item : entries) {
            if (item != null) {
                sb.append(item.toString()).append(" ");
            }
        }
        return "{" + sb.toString().trim() + "}";
    }

    public void replaceValue(K key, V newValue) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        Entry<K, V> entry = entries[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(newValue);
                return;
            }
            entry = entry.getNext();
        }
        throw new IllegalArgumentException("Key not found in HashMap");
    }

}