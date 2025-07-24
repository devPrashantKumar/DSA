
# Types of Sorting Algorithms

Sorting algorithms can be categorized based on various factors, such as their time complexity, space complexity, stability, and whether they are comparison-based or non-comparison-based. Below are the common types of sorting algorithms:

## 1. Comparison-Based Sorting Algorithms
These algorithms sort by comparing elements to one another.

- **Bubble Sort**  
  - **Time Complexity**: O(n²)  
  - **Space Complexity**: O(1)  
  - **Stable**: Yes  
  - **Description**: Repeatedly compares adjacent elements and swaps them if they are in the wrong order. It continues this process until the list is sorted.

- **Selection Sort**  
  - **Time Complexity**: O(n²)  
  - **Space Complexity**: O(1)  
  - **Stable**: No  
  - **Description**: Finds the smallest (or largest) element from the unsorted part of the list and swaps it with the first unsorted element.

- **Insertion Sort**  
  - **Time Complexity**: O(n²)  
  - **Space Complexity**: O(1)  
  - **Stable**: Yes  
  - **Description**: Builds the sorted list one item at a time by inserting elements from the unsorted part into their correct position in the sorted part.

- **Merge Sort**  
  - **Time Complexity**: O(n log n)  
  - **Space Complexity**: O(n)  
  - **Stable**: Yes  
  - **Description**: Divides the list into two halves, sorts each half recursively, and then merges the two sorted halves.

- **Quick Sort**  
  - **Time Complexity**: O(n log n) on average, O(n²) in worst case  
  - **Space Complexity**: O(log n)  
  - **Stable**: No  
  - **Description**: Selects a "pivot" element, partitions the array around the pivot, and recursively sorts the subarrays.

- **Heap Sort**  
  - **Time Complexity**: O(n log n)  
  - **Space Complexity**: O(1)  
  - **Stable**: No  
  - **Description**: Builds a max heap and repeatedly extracts the largest element from the heap and places it at the end of the sorted array.

- **Tim Sort**  
  - **Time Complexity**: O(n log n)  
  - **Space Complexity**: O(n)  
  - **Stable**: Yes  
  - **Description**: A hybrid sorting algorithm based on merge sort and insertion sort. It is used in languages like Java and Python for sorting.

## 2. Non-Comparison-Based Sorting Algorithms
These algorithms do not compare elements directly. Instead, they exploit the structure of the data to achieve sorting in different ways.

- **Counting Sort**  
  - **Time Complexity**: O(n + k), where k is the range of input  
  - **Space Complexity**: O(k)  
  - **Stable**: Yes  
  - **Description**: Counts the frequency of each element in the input and uses this information to place the elements in their correct position.

- **Radix Sort**  
  - **Time Complexity**: O(nk), where k is the number of digits  
  - **Space Complexity**: O(n + k)  
  - **Stable**: Yes  
  - **Description**: Sorts numbers by processing individual digits starting from the least significant digit (LSD) or most significant digit (MSD).

- **Bucket Sort**  
  - **Time Complexity**: O(n + k), where k is the number of buckets  
  - **Space Complexity**: O(n + k)  
  - **Stable**: Yes  
  - **Description**: Distributes the elements into a number of buckets, sorts each bucket, and then concatenates the sorted buckets.

## 3. Hybrid Sorting Algorithms
These algorithms combine the strengths of two or more sorting techniques.

- **IntroSort**  
  - **Time Complexity**: O(n log n)  
  - **Space Complexity**: O(log n)  
  - **Stable**: No  
  - **Description**: A hybrid of quicksort, heapsort, and insertion sort. It starts with quicksort and switches to heapsort if the recursion depth exceeds a certain level.

- **Block Sort**  
  - **Time Complexity**: O(n log n)  
  - **Space Complexity**: O(n)  
  - **Stable**: Yes  
  - **Description**: Similar to merge sort but it performs better when the data has a block-like structure.

## 4. External Sorting Algorithms
These are used when the dataset is too large to fit in memory, and external storage like hard drives is involved.

- **Merge Sort (External)**  
  - **Time Complexity**: O(n log n)  
  - **Space Complexity**: Depends on the disk  
  - **Stable**: Yes  
  - **Description**: Used for large datasets by dividing the data into chunks, sorting each chunk, and then merging them.

## Comparison Summary

| Algorithm        | Time Complexity      | Space Complexity | Stable | Typical Use Case        |
|------------------|----------------------|------------------|--------|-------------------------|
| Bubble Sort      | O(n²)                | O(1)             | Yes    | Small datasets, simple |
| Selection Sort   | O(n²)                | O(1)             | No     | Small datasets          |
| Insertion Sort   | O(n²)                | O(1)             | Yes    | Small datasets, nearly sorted data |
| Merge Sort       | O(n log n)           | O(n)             | Yes    | Large datasets          |
| Quick Sort       | O(n log n) (avg)     | O(log n)         | No     | General purpose         |
| Heap Sort        | O(n log n)           | O(1)             | No     | Priority queues         |
| Tim Sort         | O(n log n)           | O(n)             | Yes    | Used in Java and Python |
| Counting Sort    | O(n + k)             | O(k)             | Yes    | When the range is small |
| Radix Sort       | O(nk)                | O(n + k)         | Yes    | Sorting large numbers   |
| Bucket Sort      | O(n + k)             | O(n + k)         | Yes    | Uniformly distributed data |
| IntroSort        | O(n log n)           | O(log n)         | No     | General purpose         |

This should give you a comprehensive overview of the various types of sorting algorithms and their characteristics.
