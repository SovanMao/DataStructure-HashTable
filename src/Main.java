public class Main {
    public static void main(String[] args) {
        // Test UnorderedArray class
//        System.out.println("Testing UnorderedArray:");
//        UnorderedArray<Integer> unorderedArray = new UnorderedArray<>(5);
//        unorderedArray.insert(10);
//        unorderedArray.insert(20);
//        unorderedArray.insert(30);
//
//        System.out.println("Array after inserts: ");
//        for (int i = 0; i < unorderedArray.size(); i++) {
//            System.out.println("Index " + i + ": " + unorderedArray.get(i));
//        }
//
//        unorderedArray.delete(20);
//        System.out.println("\nArray after deleting 20:");
//        for (int i = 0; i < unorderedArray.size(); i++) {
//            System.out.println("Index " + i + ": " + unorderedArray.get(i));
//        }
//
//        // Resize the array and test insertions
//        unorderedArray.resize(10);
//        unorderedArray.insert(40);
//        unorderedArray.insert(50);
//
//        System.out.println("\nArray after resizing and additional inserts:");
//        for (int i = 0; i < unorderedArray.size(); i++) {
//            System.out.println("Index " + i + ": " + unorderedArray.get(i));
//        }

//

//        LinearProbing<Integer> linearHashTable = new LinearProbing<>(10);
//        linearHashTable.insert("cba", 3); // Insert pqr
//        linearHashTable.insert("abc", 1); // Insert abc
//        linearHashTable.insert("bac", 2);
//        System.out.println(linearHashTable);


//        // Create a Quadratic Probing Hash Table with a size of 10
//        QuadraticProbing<Integer> hashTable = new QuadraticProbing<>(10);
//        hashTable.insert("cat", 3); //2
//        hashTable.insert("act", 1);

//        hashTable.insert("abc", 2); //4
//        hashTable.insert("bca", 4);
//        hashTable.insert("cab", 9);
//        System.out.println(hashTable);


        // Create a DoubleHashing instance with a specified size
//        DoubleHashing<Integer> hashTable = new DoubleHashing<>(10);
//
//        // Inserting key-value pairs into the hash table
//        hashTable.insert("cat", 4);//2
//        hashTable.insert("tac", 5);
//        hashTable.insert("act", 5);
//
//        hashTable.insert("xyz", 4);//3
//        hashTable.insert("yzx", 5);
//
////        hashTable.insert("abc", 1); //4
////        hashTable.insert("bac", 2);
////        hashTable.insert("cab", 3);
//
//
//
//        // Print the current state of the hash table
//        System.out.println(hashTable);
//
//

//        // Create a Double Hashing Hash Table with a smaller size of 5 to force collisions
//        DoubleHashing<Integer> hashTable = new DoubleHashing<>(5);
//
//        // Insert key-value pairs that are more likely to collide
//        hashTable.insert("apple", 1);
//        hashTable.insert("banana", 2);
//        hashTable.insert("grape", 3);
//        hashTable.insert("orange", 4);
//        hashTable.insert("peach", 5);
//        hashTable.insert("plum", 6);  // This insertion should force a collision resolution
//
//        // Print the hash table to observe how entries are distributed after handling collisions
//        System.out.println("Hash Table after Insertions:");
//        System.out.println(hashTable);
//
//        // Attempt to search for some keys to confirm placement
//        System.out.println("Searching for 'banana': " + hashTable.search("banana"));
//        System.out.println("Searching for 'plum': " + hashTable.search("plum"));
//
//        // Delete a key and observe the result
//        hashTable.delete("grape");
//        System.out.println("Hash Table after Deleting 'grape':");
//        System.out.println(hashTable);
//
//        // Insert another item to observe further probing behavior
//        hashTable.insert("kiwi", 7);
//        System.out.println("Hash Table after inserting 'kiwi':");
//        System.out.println(hashTable);

        // Create a Separate Chaining Hash Table with a size of 10
//        SeparateChaining<Integer> hashTable = new SeparateChaining<>(10);
//
//        // Insert key-value pairs
//        hashTable.insert("one", 1);
//        hashTable.insert("two", 2);
//        hashTable.insert("three", 3);
//        hashTable.insert("four", 4);
//        hashTable.insert("five", 5);
//
//        // Print the hash table
//        System.out.println(hashTable);
//
//        // Search for a key
//        String searchKey = "two";
//        Integer searchResult = hashTable.search(searchKey);
//        System.out.println("Search result for key '" + searchKey + "': " + searchResult);
//
//        // Delete a key
//        String deleteKey = "three";
//        hashTable.delete(deleteKey);
//        System.out.println("Deleted key: '" + deleteKey + "'");
//
//        // Try to search for the deleted key
//        Integer deletedSearchResult = hashTable.search(deleteKey);
//        System.out.println("Search result for deleted key '" + deleteKey + "': " + deletedSearchResult);
//
//        // Print the hash table again
//        System.out.println(hashTable);

    }
}
