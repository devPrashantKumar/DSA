# Binary Search Bounds in Java

## Concepts

### Lower Bound (`lowerBound`)
- Finds the **first position** where `target` can be inserted **without disturbing the order**.
- Returns the **index of the first element** that is **greater than or equal to** `target`.
- If `target` is **greater than all elements**, it returns `arr.length`.

### Upper Bound (`upperBound`)
- Finds the **first position** where `target` is **strictly greater**.
- Returns the **index of the first element** that is **greater than `target`**.
- If **no such element exists**, it returns `arr.length`.

# Floor and Ceil in Java

## Concepts

### Floor (`floor`)
- Finds the **greatest element** in the array **less than or equal to** the `target`.
- If no such element exists, returns `-1`.

### Ceil (`ceil`)
- Finds the **smallest element** in the array **greater than or equal to** the `target`.
- If no such element exists, returns `-1`.