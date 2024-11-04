public class QuadraticProbing<T> implements HashTable<T> {
    private static class Entry<T> {
        String key;
        T value;

        Entry(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<T>[] table;
    private int size;
    private int count;

    @SuppressWarnings("unchecked")
    public QuadraticProbing(int size) {
        this.size = size;
        this.table = new Entry[size];
        this.count = 0;
    }

    @Override
    public void insert(String key, T value) {
        if (count >= size) {
            System.out.println("Hash table is full. Cannot insert '" + key + "'.");
            return; // You may consider resizing the table instead.
        }

        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int probeIndex = (index + i * i) % size; // Quadratic probing
            if (table[probeIndex] == null) {
                table[probeIndex] = new Entry<>(key, value);
                count++;
                return;
            } else if (table[probeIndex].key.equals(key)) {
                // Update existing key
                table[probeIndex].value = value;
                return;
            }
        }
    }

    @Override
    public T search(String key) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int probeIndex = (index + i * i) % size; // Quadratic probing
            if (table[probeIndex] == null) {
                return null; // Key not found
            }
            if (table[probeIndex].key.equals(key)) {
                return table[probeIndex].value; // Found the value
            }
        }
        return null; // Key not found
    }

    @Override
    public void delete(String key) {
        int index = hash(key);
        for (int i = 0; i < size; i++) {
            int probeIndex = (index + i * i) % size; // Quadratic probing
            if (table[probeIndex] == null) {
                System.out.println("Key '" + key + "' not found for deletion.");
                return;
            }
            if (table[probeIndex].key.equals(key)) {
                table[probeIndex] = null; // Mark the entry as deleted
                count--;
                return;
            }
        }
        System.out.println("Key '" + key + "' not found for deletion.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuadraticProbing HashTable:\n");
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
        return Math.abs(key.hashCode()) % size; // Hash function to get initial index
    }
}
