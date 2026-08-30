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




-------------------------------------------------

# Binary Search: Upper Bound, Lower Bound, Ceil, Floor

## Definitions

**Lower Bound** — the index of the **first element `≥ num`** (smallest index where you could insert `num` while keeping the array sorted, choosing the leftmost position if duplicates of `num` exist).
> "Give me the earliest spot where something at-least-`num` starts."

**Upper Bound** — the index of the **first element `> num`** (the position right after the last occurrence of `num`, or where `num` would go if inserted to the *right* of any duplicates).
> "Give me the earliest spot where something strictly-greater-than-`num` starts."

**Ceil** — the **smallest value in the array that is `≥ num`**. Same search condition as lower bound (`arr[mid] >= num`), but conceptually you care about the *value*, not the index — "round `num` up to the nearest value present in the array."

**Floor** — the **largest value in the array that is `≤ num`**. Search condition `arr[mid] <= num`, searching from the *other direction* — "round `num` down to the nearest value present in the array."

## How they relate

| Concept | Condition searched | Answer sentinel | Direction of search |
|---|---|---|---|
| lowerBound | `arr[mid] >= num` | `arr.length` (not found) | leftmost |
| upperBound | `arr[mid] > num` | `arr.length` (not found) | leftmost |
| ceil | `arr[mid] >= num` | `-1` (not found) | leftmost |
| floor | `arr[mid] <= num` | `-1` (not found) | rightmost |

**Key insight**: `lowerBound` and `ceil` search the *exact same condition* — they only differ in what they return (index vs. sentinel convention) and what "not found" means. `floor` is the mirror image of `lowerBound`/`ceil`: instead of shrinking `right` when the condition holds, it grows `left`, because you're hunting for the *largest* qualifying value rather than the *smallest*.

## Concrete example

For `arr = {1, 5, 7, 9, 10, 14, 18}` and `num = 11`:
- **lowerBound(11)** → index `5` (value `14`, since `14` is the first element `≥ 11`)
- **upperBound(11)** → index `5` (value `14`, since `14` is the first element `> 11`) — same as lowerBound here because `11` isn't in the array
- **ceil(11)** → `5` → value **14** (smallest array value `≥ 11`)
- **floor(11)** → `4` → value **10** (largest array value `≤ 11`)
