# Time and Space Complexity

## What They Measure

**Time Complexity** — how the runtime of an algorithm grows as the input size (n) grows.
**Space Complexity** — how much extra memory an algorithm needs as n grows.

Both are usually expressed using **asymptotic notation**, which describes growth rate rather than exact operations — ignoring machine-specific constants and focusing on how performance scales for large inputs.

---

## Asymptotic Notations

| Notation | Meaning | Use |
|---|---|---|
| **Big O (O)** | Upper bound (worst case) | Most commonly used |
| **Big Omega (Ω)** | Lower bound (best case) | Less common in practice |
| **Big Theta (Θ)** | Tight bound (average/exact growth) | Precise analysis |

In practice, most people say "Big O" even when they mean the tight bound — it's the industry shorthand.

---

## Common Time Complexities (Best to Worst)

| Complexity | Name | Example |
|---|---|---|
| O(1) | Constant | Array index access, hash map lookup |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Single loop through array |
| O(n log n) | Linearithmic | Merge sort, quick sort (avg) |
| O(n²) | Quadratic | Nested loops, bubble sort |
| O(n³) | Cubic | Triple nested loops |
| O(2ⁿ) | Exponential | Recursive Fibonacci (naive), subsets |
| O(n!) | Factorial | Permutations, traveling salesman (brute force) |

**Growth intuition (n = 1,000):**
- O(log n) ≈ 10
- O(n) = 1,000
- O(n log n) ≈ 10,000
- O(n²) = 1,000,000
- O(2ⁿ) = astronomically large

---

## How to Analyze Time Complexity

1. **Loops:** A single loop over n elements → O(n). Nested loops → multiply (O(n) × O(n) = O(n²)).
2. **Sequential statements:** Add complexities, then keep the dominant term.
   `O(n) + O(n²) → O(n²)`
3. **Conditionals (if/else):** Take the branch with the larger complexity.
4. **Recursion:** Use the **recurrence relation**.
   - Example: Binary search → T(n) = T(n/2) + O(1) → O(log n)
   - Example: Merge sort → T(n) = 2T(n/2) + O(n) → O(n log n)
   - **Master Theorem** is the standard tool for solving these recurrences (see below).
5. **Drop constants and lower-order terms:**
   `O(3n² + 5n + 2)` → `O(n²)`

---

## Space Complexity

Space complexity accounts for:
- **Input space** — memory for the input itself (often excluded from analysis).
- **Auxiliary space** — extra memory the algorithm uses (this is usually what's actually meant by "space complexity").

### Common Cases
| Complexity | Example |
|---|---|
| O(1) | In-place swapping, iterative algorithms with fixed variables |
| O(n) | Storing a copy of the array, hash map of n elements |
| O(n) | Recursive call stack (e.g., naive recursion depth n) |
| O(log n) | Recursive calls in balanced divide-and-conquer (e.g., binary search recursion) |
| O(n²) | 2D matrix/table (common in DP) |

**Key point on recursion:** Every recursive call adds a frame to the call stack, so recursion depth directly contributes to space complexity — even if no extra data structures are used.

---

## Time-Space Tradeoff

Often you can reduce time complexity by using more memory (or vice versa):
- **Memoization/caching:** Trades O(n) or O(n²) extra space to cut exponential time down to polynomial time (e.g., Fibonacci: O(2ⁿ) time/O(1) space → O(n) time/O(n) space).
- **Hash maps:** Use O(n) space to bring lookup-heavy problems from O(n²) down to O(n) time.

---

## Quick Reference Examples

```
Constant:    O(1)         → return arr[0]
Logarithmic: O(log n)     → binary search
Linear:      O(n)         → for i in arr: print(i)
Linearithmic:O(n log n)   → merge sort
Quadratic:   O(n²)        → for i in arr: for j in arr: ...
Exponential: O(2ⁿ)        → recursive subset generation
```

---

# Solving Recurrences with the Master Theorem

When an algorithm recursively calls itself, its time complexity is expressed as a **recurrence relation** — an equation defining T(n) in terms of T of some smaller input. The Master Theorem is a shortcut for solving recurrences of a specific shape without doing a full recursion-tree expansion every time.

## The form it applies to

```
T(n) = a·T(n/b) + f(n)
```

- **a** = number of recursive subproblems (a ≥ 1)
- **n/b** = size of each subproblem (b > 1)
- **f(n)** = cost of the work done outside the recursive calls (dividing/combining)

## The three cases

The theorem compares f(n) against `n^(log_b a)` — this quantity represents the cost of the recursive branching alone, ignoring the combine step.

**Case 1 — recursion dominates**
If f(n) grows *slower* than `n^(log_b a)` (specifically, f(n) = O(n^(log_b a − ε)) for some ε > 0):
```
T(n) = Θ(n^(log_b a))
```
The work is concentrated in the massive number of tiny subproblems at the bottom of the recursion tree.

**Case 2 — balanced**
If f(n) grows at the *same rate* as `n^(log_b a)` (f(n) = Θ(n^(log_b a))):
```
T(n) = Θ(n^(log_b a) · log n)
```
Work is spread evenly across all levels of the tree, and there are log n levels.

**Case 3 — combine step dominates**
If f(n) grows *faster* than `n^(log_b a)` (f(n) = Ω(n^(log_b a + ε)), plus a regularity condition), then:
```
T(n) = Θ(f(n))
```
Most of the work happens at the top level (the combine step), so it drowns out the recursive cost.

## Worked examples

**Merge sort:** `T(n) = 2T(n/2) + O(n)`
- a=2, b=2 → `n^(log_2 2) = n^1 = n`
- f(n) = n → matches Case 2 (balanced)
- **T(n) = Θ(n log n)** ✓

**Binary search:** `T(n) = T(n/2) + O(1)`
- a=1, b=2 → `n^(log_2 1) = n^0 = 1`
- f(n) = O(1) → matches Case 2
- **T(n) = Θ(log n)** ✓

**Naive matrix multiplication (divide and conquer):** `T(n) = 8T(n/2) + O(n²)`
- a=8, b=2 → `n^(log_2 8) = n^3`
- f(n) = n² grows slower than n³ → Case 1
- **T(n) = Θ(n³)**

**Strassen's algorithm:** `T(n) = 7T(n/2) + O(n²)`
- a=7, b=2 → `n^(log_2 7) ≈ n^2.81`
- f(n) = n² grows slower than n^2.81 → Case 1
- **T(n) = Θ(n^2.81)** — better than naive O(n³), which is the whole point of Strassen's trick.

## The limits of the theorem

It doesn't apply when:
- **a < 1**, or **b ≤ 1**, or f(n) is negative
- The recurrence is **not clean** — e.g. `T(n) = 2T(n/2) + n/log n` falls in a gap between Case 2 and Case 3 that the basic theorem can't resolve (needs the more general Akra–Bazzi method)
- Subproblems have **different sizes**, e.g. `T(n) = T(n/3) + T(2n/3) + O(n)` — this needs a recursion-tree argument instead, or Akra–Bazzi (this particular one still works out to O(n log n))

---

# Beyond Master Theorem — The Akra–Bazzi Method

The Akra–Bazzi method is a generalization of the Master Theorem for recurrences that the Master Theorem can't handle — specifically, recurrences with **unequal subproblem sizes** or **non-polynomial divide/combine costs**.

## The general form it solves

```
T(x) = g(x) + Σ aᵢ·T(bᵢ·x + hᵢ(x))    for i = 1 to k
```

- **aᵢ** — weight of the i-th recursive call (aᵢ > 0)
- **bᵢ** — the fraction each subproblem shrinks by (0 < bᵢ < 1) — these can be *different* for each term, unlike Master Theorem's single b
- **hᵢ(x)** — a small perturbation term (bounded, handles rounding like floors/ceilings)
- **g(x)** — the non-recursive work (like f(n) in Master Theorem)

## How to solve it

1. Find the unique real value **p** such that:
```
Σ aᵢ·bᵢ^p = 1
```
2. Then:
```
T(x) = Θ( x^p · (1 + ∫₁ˣ g(u)/u^(p+1) du) )
```

That integral term is doing the same job as the "compare f(n) to n^(log_b a)" step in the Master Theorem — it's checking how g(x) stacks up against the natural growth rate x^p.

## Why it's needed

**Case A — unequal subproblem sizes.** Take the earlier example:
```
T(n) = T(n/3) + T(2n/3) + O(n)
```
Master Theorem doesn't apply (subproblems aren't the same size). With Akra–Bazzi: solve `(1/3)^p + (2/3)^p = 1` → p = 1. Then the integral of g(u)/u² works out such that:
```
T(n) = Θ(n log n)
```
This matches the recursion-tree intuition — the tree has depth O(log n) and does O(n) work per level, same as balanced merge sort.

**Case B — the "gap" recurrences.** Take:
```
T(n) = 2T(n/2) + n/log n
```
Master Theorem's three cases require f(n) to be polynomially larger, equal to, or smaller than n^(log_b a) — but n/log n is neither polynomially bigger nor smaller than n (they differ only by a log factor), so none of the three cases cleanly fires. Akra–Bazzi handles this fine: p = 1 (since a=2, b=1/2 gives 2·(1/2)¹=1), and the integral becomes:
```
∫₁ⁿ (u/log u) / u² du = ∫₁ⁿ 1/(u log u) du = ln(ln n)
```
giving:
```
T(n) = Θ(n log log n)
```

## The practical takeaway

You'll rarely need to grind through the integral by hand outside a theory course — the value of knowing Akra–Bazzi exists is recognizing *when* the Master Theorem doesn't apply (unequal splits, or f(n) sitting in the gap between cases) so you don't force-fit it and get a wrong answer. In practice, for unequal-split recurrences, drawing out the recursion tree for a few levels and spotting the pattern is often faster than invoking Akra–Bazzi formally.

---

# Amortized Analysis

Regular worst-case analysis asks: "what's the cost of the *most expensive* single operation?" **Amortized analysis** asks a different question: "what's the *average* cost per operation, over the worst possible *sequence* of operations?" It's not about probability or average-case input — it's a guarantee over a sequence, even an adversarial one.

The classic motivating example is a **dynamic array** (like Python's `list` or Java's `ArrayList`).

## The dynamic array example

Appending to a dynamic array is usually O(1) — just write to the next free slot. But when the array is full, it must:
1. Allocate a new array (typically double the size)
2. Copy every existing element over — O(n)

So a single append can cost O(n). Worst-case-per-operation analysis would say "append is O(n)," which is technically true but misleading — it makes the array look bad compared to a resizing scheme that costs a little every time.

Amortized analysis says: look at n appends *in total*. Resizes happen at sizes 1, 2, 4, 8, 16, ... doubling each time. The total copying work across all resizes is:
```
1 + 2 + 4 + 8 + ... + n ≈ 2n
```
This is a geometric series that sums to roughly 2n — **not** n². Spread that 2n cost across n operations, and each append costs **O(1) amortized**, even though occasional individual appends are O(n).

## The three main techniques

**1. Aggregate method**
Compute the total cost of n operations, divide by n. (This is exactly what we did above: total cost ≈ 3n for n appends → O(1) each.)

**2. Accounting (banker's) method**
Assign each operation an amortized "charge" — some operations are overcharged, building up "credit," and expensive operations pay for themselves using stored-up credit rather than a fresh charge.
- Example: charge each append 3 credits (1 for its own write, 2 banked). When a resize hits, the banked credits from the n/2 elements already in the array pay for copying them.

**3. Potential method**
Define a potential function Φ that captures "stored energy" in the data structure (e.g., Φ = 2·(number of elements) − (array capacity)). The amortized cost of an operation is:
```
amortized cost = actual cost + ΔΦ
```
This is the most rigorous and general technique — often used to prove amortized bounds for more complex structures like splay trees or Fibonacci heaps.

## Other classic examples

| Structure/Operation | Worst-case single op | Amortized |
|---|---|---|
| Dynamic array append | O(n) | O(1) |
| Dynamic array (with shrink-on-delete) | O(n) | O(1) |
| Binary counter increment | O(log n) (bit flips) | O(1) |
| Union-Find (path compression + union by rank) | O(log n) | O(α(n)) — inverse Ackermann, effectively constant |
| Splay tree operation | O(n) | O(log n) |

**Binary counter intuition:** incrementing can flip many trailing 1-bits to 0 (a cascade), but a bit that flips to 0 only flips back to 1 after being flipped to 1 again — so flips are naturally rate-limited, and the total flips over n increments is O(n), giving O(1) amortized per increment.

## Why it matters in practice

Amortized analysis is why "just use a dynamic array/ArrayList/vector" is sound advice — you get array-like O(1) access with append behavior that's O(1) on average, so you rarely need to pre-size things. It's also the reason hash table resizing, union-find, and self-adjusting trees are considered efficient despite having expensive-looking individual operations.
