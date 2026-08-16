# Integer Overflow Safety in Java

When performing arithmetic operations on integers, the result can exceed the range supported by the data type.

For Java `int`:

```text
Integer.MIN_VALUE = -2³¹ = -2147483648
Integer.MAX_VALUE =  2³¹ - 1 =  2147483647
```

If an arithmetic operation exceeds this range, Java's `int` arithmetic can overflow and produce an incorrect value.

---

# Example: Reverse Digits

Consider reversing an integer:

```java
reverseNum = reverseNum * 10 + digit;
```

Before performing this operation, we need to make sure that:

```text
reverseNum * 10 + digit <= Integer.MAX_VALUE
```

Otherwise, `int` overflow can occur.

---

## Overflow-Safe Formula

Instead of calculating:

```java
reverseNum * 10 + digit
```

first, rearrange the condition:

```text
reverseNum * 10 + digit <= Integer.MAX_VALUE
```

Subtract `digit` from both sides:

```text
reverseNum * 10 <= Integer.MAX_VALUE - digit
```

Divide by `10`:

```text
reverseNum <= (Integer.MAX_VALUE - digit) / 10
```

Therefore, the safe condition is:

```java
if ((Integer.MAX_VALUE - digit) / 10 >= reverseNum) {
    reverseNum = reverseNum * 10 + digit;
} else {
    return 0;
}
```

This checks for overflow **before** performing the multiplication.

---

# Why Not Check After the Operation?

This is unsafe:

```java
reverseNum = reverseNum * 10 + digit;

if (reverseNum > Integer.MAX_VALUE) {
    return 0;
}
```

The problem is that the overflow may already have happened while calculating:

```java
reverseNum * 10 + digit
```

Once an `int` overflows, the original value is lost.

Therefore:

> **Always check whether an operation is safe before performing it.**

---

# Example

Suppose:

```text
reverseNum = 214748364
digit = 7
```

We want to calculate:

```text
214748364 * 10 + 7
= 2147483647
```

This is exactly:

```text
Integer.MAX_VALUE
```

So it is safe.

The condition:

```java
(Integer.MAX_VALUE - digit) / 10 >= reverseNum
```

becomes:

```text
(2147483647 - 7) / 10 >= 214748364
2147483640 / 10 >= 214748364
214748364 >= 214748364
```

Therefore, the operation is safe.

---

## Overflow Example

Suppose:

```text
reverseNum = 214748364
digit = 8
```

Then:

```text
214748364 * 10 + 8
= 2147483648
```

But:

```text
Integer.MAX_VALUE = 2147483647
```

So the result cannot be represented by an `int`.

The condition detects this:

```text
(2147483647 - 8) / 10
= 214748363
```

And:

```text
214748363 < 214748364
```

Therefore, we return `0` instead of performing the overflowing operation.

---

# Negative Integer Overflow

There is another important edge case:

```java
Integer.MIN_VALUE
```

Its value is:

```text
-2147483648
```

But the positive value:

```text
2147483648
```

cannot be represented by an `int`.

Therefore:

```java
Math.abs(Integer.MIN_VALUE)
```

does **not** give `2147483648`.

It remains:

```text
-2147483648
```

because Java `int` cannot represent `2147483648`.

### Safe Handling

One simple approach is:

```java
if (x == Integer.MIN_VALUE) {
    return 0;
}
```

Then it is safe to do:

```java
x = Math.abs(x);
```

For example:

```java
public static int reverseDigitsOfNumber(int x) {
    if (x == Integer.MIN_VALUE)
        return 0;

    int sign = (x < 0) ? -1 : 1;
    x = Math.abs(x);

    int reverseNum = 0;

    while (x > 0) {
        int digit = x % 10;
        x /= 10;

        if ((Integer.MAX_VALUE - digit) / 10 >= reverseNum) {
            reverseNum = reverseNum * 10 + digit;
        } else {
            return 0;
        }
    }

    return reverseNum * sign;
}
```

---

# Alternative Overflow Check

The following two conditions are equivalent:

### Version 1

```java
if ((Integer.MAX_VALUE - digit) / 10 >= reverseNum) {
    reverseNum = reverseNum * 10 + digit;
} else {
    return 0;
}
```

### Version 2

```java
if ((Integer.MAX_VALUE - digit) / 10 < reverseNum) {
    return 0;
} else {
    reverseNum = reverseNum * 10 + digit;
}
```

The second version checks explicitly for the overflow case.

---

# General Overflow Pattern

For an operation:

```text
a * 10 + digit
```

and maximum allowed value:

```text
MAX
```

we want:

```text
a * 10 + digit <= MAX
```

Rearranging:

```text
a <= (MAX - digit) / 10
```

So the general pattern is:

```java
if (a > (MAX - digit) / 10) {
    // overflow
}
```

Only after this check should we perform:

```java
a = a * 10 + digit;
```

---

# Integer Range

For Java `int`:

```text
Integer.MIN_VALUE = -2147483648
Integer.MAX_VALUE =  2147483647
```

For Java `long`:

```text
Long.MIN_VALUE = -9223372036854775808
Long.MAX_VALUE =  9223372036854775807
```

The same overflow-safety principle applies to both.

---

# Key Takeaways

1. **Check overflow before performing the arithmetic operation.**
2. For:
   ```text
   reverseNum * 10 + digit
   ```
   use:
   ```java
   reverseNum <= (Integer.MAX_VALUE - digit) / 10
   ```
3. `Integer.MIN_VALUE` is a special case because:
   ```java
   Math.abs(Integer.MIN_VALUE)
   ```
   cannot be represented as an `int`.
4. Never rely on checking the result after an overflowing operation.
5. Rearrange the mathematical condition so that the check itself cannot overflow.

---

# Complexity of Reverse Digits

If `N` has `d` digits:

```text
d = O(log₁₀N)
```

Therefore:

- **Time Complexity:** `O(log₁₀N)`
- **Space Complexity:** `O(1)`
