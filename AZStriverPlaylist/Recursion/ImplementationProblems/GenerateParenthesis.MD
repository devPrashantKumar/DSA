# Generate Parentheses (LeetCode 22)

# Intuition

Build the string one character at a time, tracking how many `(` and `)`
are still available to place (`open` and `closed`, both starting at
`n`).

At each step there are only two choices:

-   Place `(` — always legal as long as `open > 0`.
-   Place `)` — only legal if `closed > open`, i.e. there are more
    closing brackets remaining than opening ones. This guarantees that
    at every prefix of the string, the count of `)` never exceeds the
    count of `(`, which is exactly the definition of a valid balanced
    sequence.

When both counters hit `0`, the string is complete and valid — add it
to the result.

No validity check is needed after the fact: the `closed > open` guard
prevents invalid strings from ever being built.

------------------------------------------------------------------------

# Two Implementations

-   `generateParenthesis` — builds the string via `String`
    concatenation (`str + '('`). Simple, but every call allocates a
    new `String` and copies existing characters.
-   `generateParenthesisUsingStringBuilder` — same algorithm, but
    mutates a shared `StringBuilder` with `append` / `deleteCharAt`
    (backtracking). Avoids the repeated allocation/copy at every
    internal node; only pays a copy cost once per result, via
    `toString()`.

Both are the same asymptotic complexity class — the `StringBuilder`
version just has a smaller constant factor.

------------------------------------------------------------------------

# Why the Branching Is Catalan-Bounded, Not `2^(2n)`

Picture the recursion as a binary tree of depth `2n` (one call per
character placed). Without pruning, that tree would have `2^(2n) =
4^n` leaves — one for every possible sequence of `(` and `)`.

The `closed > open` guard prunes invalid branches immediately, instead
of letting them run to depth `2n` and get discarded at the end. What
survives to a complete leaf is exactly the set of valid balanced
parenthesis strings of length `2n` — and the count of those is the
**nth Catalan number**:

``` text
C_n = (2n)! / ((n + 1)! * n!)
```

Catalan numbers grow as:

``` text
C_n ~ 4^n / (n^1.5 * sqrt(pi))
```

The `4^n` is the same base as the naive `2^(2n)` bound — pruning
doesn't change the base, it knocks the growth down by the polynomial
factor `n^1.5` in the denominator. "Catalan-bounded branching" just
means: the tree looks like it branches by 2 at every node, but the
number of paths that actually reach a leaf is bounded by `C_n`, not by
`2^depth`.

------------------------------------------------------------------------

# Time Complexity

-   Number of valid results ≈ `4^n / n^1.5` (Catalan growth).
-   Building/copying each finished string costs `O(n)` (length is
    `2n`).
-   Multiply: `O(n) * O(4^n / n^1.5) = O(4^n / n^0.5) = O(4^n / sqrt(n))`.

``` text
O(4^n / sqrt(n))
```

------------------------------------------------------------------------

# Space Complexity

-   **Output storage**: `O(4^n / sqrt(n))`, dominated by all the valid
    strings being returned.
-   **Recursion stack**: depth is at most `2n` (one call per character
    placed), so `O(n)` auxiliary space beyond the output.
