# Catalan Numbers

# What They Are

Catalan numbers are a sequence of natural numbers that show up
whenever you're counting the ways to correctly "nest" or "balance"
something — balanced parentheses, valid binary trees, valid BST
shapes, polygon triangulations, and more.

Sequence (C_0, C_1, C_2, ...):

``` text
1, 1, 2, 5, 14, 42, 132, 429, 1430, ...
```

------------------------------------------------------------------------

# Formulas

**Direct (binomial) formula:**

``` text
C_n = C(2n, n) / (n + 1) = (2n)! / ((n + 1)! * n!)
```

**Recursive formula:**

``` text
C_0 = 1
C_n = sum_{i=0}^{n-1} C_i * C_(n-1-i)      for n >= 1
```

The recursive form falls directly out of "pick a split point, solve
the left part and the right part independently, multiply the
possibilities" — this is why Catalan numbers appear naturally in
divide-style recursive counting problems.

**Growth rate (asymptotic):**

``` text
C_n ~ 4^n / (n^1.5 * sqrt(pi))
```

So Catalan numbers grow like `4^n`, but suppressed by a polynomial
factor of `n^1.5`. This matters for complexity analysis: a recursion
that superficially looks like it branches `2^depth` but is actually
enumerating Catalan-many valid outcomes is bounded by `4^n / sqrt(n)`
once you fold in an `O(n)` cost per outcome (see the "Catalan-bounded
branching" note below).

------------------------------------------------------------------------

# Where Catalan Numbers Show Up

-   **Balanced parentheses**: number of valid strings of `n` pairs of
    `(` and `)`. See [[GenerateParenthesis]] —
    `AZStriverPlaylist/Recursion/GenerateParenthesis.java`.
-   **Binary search trees**: number of *structurally unique* BSTs that
    can be formed from `n` distinct keys (LeetCode "Unique Binary
    Search Trees").
-   **Binary trees**: number of full binary trees with `n + 1` leaves.
-   **Polygon triangulation**: number of ways to triangulate a convex
    polygon with `n + 2` sides.
-   **Dyck paths**: number of monotonic lattice paths from `(0,0)` to
    `(2n,2n)` that stay below the diagonal.
-   **Stack-sortable permutations**: number of permutations of `n`
    elements that can be sorted with a single stack.

The common thread: any problem where you're recursively splitting a
sequence into a "left part" and a "right part" around some pivot, and
the two parts are independently valid — the total count follows the
Catalan recurrence.

------------------------------------------------------------------------

# Catalan-Bounded Branching (Recursion/Complexity Angle)

When a backtracking recursion enumerates *all valid* balanced
sequences (rather than all `2^n` or `2^(2n)` raw combinations), the
naive "binary tree of depth d" bound of `2^d` is misleading — a
pruning/validity condition (e.g. "don't close more brackets than you've
opened") cuts off invalid branches early, so the leaves that actually
get reached are bounded by `C_n`, not `2^d`.

This is exactly the situation in `GenerateParenthesis.java`: the guard
`closed > open` prevents invalid branches from being explored past the
point they become invalid, so the total valid outputs are `C_n`
instead of `4^n`. Multiplying by the `O(n)` cost of materializing each
result string gives the commonly cited complexity:

``` text
O(4^n / sqrt(n))
```

See `AZStriverPlaylist/Recursion/GenerateParenthesis.MD` for the full
derivation in that specific problem's context.
