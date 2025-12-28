
# Hashing and Its Notes

## **Overview**
Hashing is a technique used to map data of arbitrary size to fixed-size values, often for efficient searching, insertion, and deletion in data structures like hash tables. It uses a **hash function** to compute an index (hash value) that determines where the data is stored or retrieved.

---

## **Key Concepts**

### **1. Hash Function**
- A function that converts input data (key) into a fixed-sized integer (hash value or index).
- Example: 
  ```java
  int hashValue = key.hashCode() % tableSize;
  ```
- **Characteristics of a good hash function**:
  - **Deterministic**: The same input always produces the same hash.
  - **Uniform Distribution**: Distributes keys evenly across the hash table.
  - **Fast**: Computation should be efficient.
  - **Minimized Collisions**: Reduces the occurrence of two keys hashing to the same index.

---

### **2. Hash Table**
A data structure that stores key-value pairs. It uses the hash value (from the hash function) to determine where to place the key-value pair in an array-like structure.

- **Key Operations**:
  - **Insert**: Add key-value pairs to the hash table.
  - **Search**: Find the value associated with a key.
  - **Delete**: Remove a key-value pair from the hash table.

---

### **3. Collisions**
Collisions occur when two different keys hash to the same index. Handling collisions is essential for hash tables to function correctly.

- **Collision Resolution Techniques**:
  1. **Open Addressing**: Resolves collisions by probing (searching) for an empty slot.
     - **Linear Probing**: Check the next slot sequentially.
     - **Quadratic Probing**: Use a quadratic formula to find the next slot.
     - **Double Hashing**: Use a secondary hash function for probing.
  2. **Chaining**: Store all colliding keys at the same index using a linked list or another data structure.

---

### **4. Load Factor**
The load factor is the ratio of the number of elements to the size of the hash table. It determines when to resize the table to maintain performance.

- Formula:  
  \[
  	ext{Load Factor} = \frac{\text{Number of Elements}}{\text{Size of Table}}
  \]
- Common threshold: 0.75 (resizing occurs when the load factor exceeds this value).

---

## **Advantages of Hashing**
1. **Efficient**: Provides average-case \(O(1)\) time complexity for insertion, deletion, and search.
2. **Dynamic**: Can handle dynamic datasets efficiently by resizing.

---

## **Disadvantages of Hashing**
1. **Collisions**: Require resolution strategies, which can increase complexity.
2. **Space Overhead**: May require additional space (e.g., resizing or chaining structures).
3. **Poor Hash Function**: Can lead to uneven distribution and degraded performance.

---

## **Applications of Hashing**
1. **Data Structures**:
   - Hash tables (e.g., Java’s `HashMap` and `HashSet`).
   - Caches.
2. **Cryptography**:
   - Secure Hash Algorithms (e.g., SHA-256).
3. **Database Indexing**:
   - Efficient lookup of records.
4. **Load Balancing**:
   - Distributing tasks among servers.
5. **Check for Duplicates**:
   - Finding duplicates in arrays or datasets.

---

## **Notes on Hashing**
1. Hashing is not sorted; if sorted data is required, use other structures (e.g., binary search trees).
2. The choice of hash function is critical for efficiency.
3. In open addressing, the hash table must never be completely full.
4. Proper handling of the load factor ensures the performance remains optimal.
