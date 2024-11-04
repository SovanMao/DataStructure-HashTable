public class UnorderedArray<T> {
    private T[] arr;
    private int deleted = 0; // Count how many delete() called
    private int initialInsert = 0; // Threshold for insertCount
    private int insertCount = 0; // Count insert() after value (initialInsert size) is initialized in array
    private int nullCount; // Track nulls for debugging

    @SuppressWarnings("unchecked")
    public UnorderedArray(int size) {
        arr = (T[]) new Object[size]; // Use Object array and cast
        this.nullCount = size;
    }

    // Method to insert value into the first null position in the array
    public void insert(T x) {
        try {
            if (size() <= this.initialInsert) {
                this.insertCount++;
            }
            int indexToBeInsert = size() - nullCount;
            this.initialInsert++;
            if (arr[indexToBeInsert] == null) {
                arr[indexToBeInsert] = x;
                nullCount--;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array filled. Cannot insert '" + x + "'. Please resize.");
        }
    }

    // Method to delete a value
    public boolean delete(T x) {
        int index = find(x);
        if (index != -1) {
            arr[index] = null;
            shiftNull();
            deleted++;
            this.nullCount++;
            return true;
        } else {
            return false;
        }
    }

    // Method for shifting null values to the end of the array
    public T[] shiftNull() {
        T[] result = (T[]) new Object[arr.length];
        int j = 0;
        for (T i : arr) {
            if (i != null) {
                result[j++] = i;
            }
        }
        this.arr = result;
        return this.arr;
    }

    // Method to find an element by value
    public int find(T x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    // Method to get element at specific index
    public T get(int index) {
        try {
            return arr[index] != null ? arr[index] : null;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: valid range is 0 - " + (arr.length - 1));
            return null;
        }
    }

    // Method to get the array size
    public int size() {
        return this.arr.length;
    }

    // Method to resize the array
    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        try {
            T[] newArr = (T[]) new Object[newSize];
            System.arraycopy(arr, 0, newArr, 0, Math.min(arr.length, newSize));
            this.arr = newArr;
            this.nullCount += (newSize - arr.length);
        } catch (NegativeArraySizeException e) {
            System.out.println("Array size cannot be negative.");
        }
    }
}
