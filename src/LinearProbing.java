public class LinearProbing<T> implements HashTable<T> {
    private Entry<T>[] table;
    private int size;
    private static final int DELETED = -1;

    private static class Entry<T> {
        String key;
        T value;

        Entry(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public LinearProbing(int size) {
        this.size = size;
        this.table = new Entry[size];
    }

    @Override
    public void insert(String key, T value) {
        int index = hash(key);
        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % size; // Linear probing
        }
        table[index] = new Entry<>(key, value);
    }

    @Override
    public T search(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % size; // Linear probing
        }
        return null; // Key not found
    }

    @Override
    public void delete(String key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null; // Mark as deleted
                return;
            }
            index = (index + 1) % size; // Linear probing
        }
        System.out.println("Key '" + key + "' not found for deletion.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinearProbing HashTable:\n");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append("Bucket ").append(i).append(": [").append(table[i].key).append(", ").append(table[i].value).append("]\n");
            } else {
                sb.append("Bucket ").append(i).append(": null\n");
            }
        }
        return sb.toString();
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }
}
