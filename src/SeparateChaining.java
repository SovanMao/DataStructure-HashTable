import java.util.LinkedList;

public class SeparateChaining<T> implements HashTable<T> {
    // Each index in the hash table contains a LinkedList of Entry objects
    private LinkedList<Entry<T>>[] table;
    private int size;

    // Entry class to hold key-value pairs
    private static class Entry<T> {
        String key;
        T value;

        Entry(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash table with a given size
    @SuppressWarnings("unchecked")
    public SeparateChaining(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>(); // Initialize each bucket as an empty LinkedList
        }
    }

    @Override
    public void insert(String key, T value) {
        int index = hash(key);
        LinkedList<Entry<T>> chain = table[index];

        for (Entry<T> entry : chain) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }

        // If the key does not exist, add a new entry
        chain.add(new Entry<>(key, value));
    }

    @Override
    public T search(String key) {
        int index = hash(key);
        LinkedList<Entry<T>> chain = table[index];

        for (Entry<T> entry : chain) {
            if (entry.key.equals(key)) {
                return entry.value; // Return the value if found
            }
        }

        return null; // Key not found
    }

    @Override
    public void delete(String key) {
        int index = hash(key);
        LinkedList<Entry<T>> chain = table[index];

        for (Entry<T> entry : chain) {
            if (entry.key.equals(key)) {
                chain.remove(entry); // Remove the entry if found
                return;
            }
        }

        System.out.println("Key '" + key + "' not found for deletion.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SeparateChaining HashTable:\n");
        for (int i = 0; i < table.length; i++) {
            sb.append("Bucket ").append(i).append(": ");
            for (Entry<T> entry : table[i]) {
                sb.append("[").append(entry.key).append(", ").append(entry.value).append("] -> ");
            }
            sb.append("null\n");
        }
        return sb.toString();
    }

    // Hash function to calculate the index for a given key
    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }
}
