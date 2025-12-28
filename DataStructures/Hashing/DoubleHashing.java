package DataStructures.Hashing;

public class DoubleHashing {
    String[] hashTable;
    int usedCells;

    public DoubleHashing(int size) {
        this.hashTable = new String[size];
        this.usedCells = 0;
    }

    // Primary hash function
    public int primaryHash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % hashTable.length;
    }

    // Secondary hash function
    public int secondaryHash(String key) {
        int prime = hashTable.length - 1; // A prime number less than table size
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return prime - (sum % prime);
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Index: " + i + " Key: " + hashTable[i]);
        }
    }

    public double loadFactor() {
        return (usedCells * 1.0) / hashTable.length;
    }

    public void resizeHashTable() {
        String[] tempArray = hashTable;
        hashTable = new String[2 * hashTable.length];
        usedCells = 0;
        for (String element : tempArray) {
            if (element != null && !element.equals("DELETED")) {
                insertElement(element);
            }
        }
    }

    public void insertElement(String key) {
        double loadFactor = loadFactor();
        if (loadFactor >= 0.75) {
            resizeHashTable();
        }

        int primaryHash = primaryHash(key);
        int secondaryHash = secondaryHash(key);

        for (int i = 0; i < hashTable.length; i++) {
            int newIndex = (primaryHash + i * secondaryHash) % hashTable.length;

            if (hashTable[newIndex] == null || hashTable[newIndex].equals("DELETED")) {
                hashTable[newIndex] = key;
                usedCells++;
                break;
            }
        }
    }

    public boolean searchElement(String key) {
        int primaryHash = primaryHash(key);
        int secondaryHash = secondaryHash(key);

        for (int i = 0; i < hashTable.length; i++) {
            int newIndex = (primaryHash + i * secondaryHash) % hashTable.length;

            if (hashTable[newIndex] == null) {
                return false;
            }
            if (hashTable[newIndex].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteElement(String key) {
        int primaryHash = primaryHash(key);
        int secondaryHash = secondaryHash(key);

        for (int i = 0; i < hashTable.length; i++) {
            int newIndex = (primaryHash + i * secondaryHash) % hashTable.length;

            if (hashTable[newIndex] != null && hashTable[newIndex].equals(key)) {
                hashTable[newIndex] = "DELETED";
                usedCells--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DoubleHashing doubleHashing = new DoubleHashing(7);

        doubleHashing.insertElement("Apple");
        doubleHashing.insertElement("Banana");
        doubleHashing.insertElement("Cherry");
        doubleHashing.insertElement("Dates");
        doubleHashing.insertElement("Elderberry");

        System.out.println("Hash Table:");
        doubleHashing.printHashTable();

        System.out.println("\nSearching for 'Banana': " + doubleHashing.searchElement("Banana"));
        System.out.println("Deleting 'Cherry': " + doubleHashing.deleteElement("Cherry"));
        System.out.println("\nHash Table after deletion:");
        doubleHashing.printHashTable();
    }

    
}
