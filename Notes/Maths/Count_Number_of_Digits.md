# Count Number of Digits in a Given Number

There are two common approaches to count the number of digits in a number.

---

## Approach 1: Repeatedly Divide by 10

### Logic

Every time we divide a number by `10`, its last digit is removed.

For example:

```text
12345 → 1234 → 123 → 12 → 1 → 0
```

Therefore, the number of iterations is equal to the number of digits.

### Code

```java
public static int countDigits(int n) {
    int count = 0;

    while (n > 0) {
        int digit = n % 10;
        n = n / 10;
        count++;
    }

    return count;
}
```

> `digit = n % 10` extracts the last digit.  
> `n = n / 10` removes the last digit.

### Complexity

- **Time:** `O(log₁₀(n))`
- **Space:** `O(1)`

### Why `O(log₁₀(n))`?

For a number with `d` digits:

```text
10^(d-1) <= n < 10^d
```

Therefore:

```text
d ≈ log₁₀(n)
```

Since the loop removes one digit in every iteration, it runs `O(log₁₀(n))` times.

---

## Approach 2: Using Logarithm

For a positive integer `n`, the number of digits can be calculated using:

```text
Number of digits = floor(log₁₀(n)) + 1
```

### Code

```java
public static int countDigits(int n) {
    return (int) Math.floor(Math.log10(n)) + 1;
}
```

### Example

For:

```text
n = 12345
```

We have:

```text
log₁₀(12345) ≈ 4.091
```

Therefore:

```text
floor(4.091) + 1
= 4 + 1
= 5
```

So `12345` has **5 digits**.

### Complexity

- **Time:** `O(1)`
- **Space:** `O(1)`

---

## Edge Cases

### 1. `n = 0`

`log₁₀(0)` is undefined, so handle `0` separately.

```java
if (n == 0) {
    return 1;
}
```

`0` has exactly **1 digit**.

### 2. Negative Numbers

For negative numbers, use the absolute value:

```java
n = Math.abs(n);
```

For example:

```text
-12345 → 12345 → 5 digits
```

> Be careful with `Integer.MIN_VALUE` when using `Math.abs(int)`, because its positive value cannot be represented as an `int`. For general integer handling, use `long` or convert to `long` before applying `Math.abs()`.

---

## Summary

| Approach | Time Complexity | Space Complexity |
|---|---:|---:|
| Repeated division by 10 | `O(log₁₀(n))` | `O(1)` |
| Logarithm | `O(1)` | `O(1)` |

### Key Takeaways

- `% 10` → extracts the last digit.
- `/ 10` → removes the last digit.
- Repeated division → `O(log₁₀(n))`.
- `floor(log₁₀(n)) + 1` → number of digits for positive `n`.
- `n = 0` must be handled separately for the logarithmic approach.
