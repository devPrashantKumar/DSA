# Classic Recursion vs. Tail Recursion

## The core difference

**Classic (non-tail) recursion**: the recursive call is *not* the last operation — there's still work to do with its result after it returns.

```java
public static int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);  // multiplication happens AFTER the call returns
}
```

Here, each stack frame must stay alive waiting for its child call to return, because it still needs to multiply by `n`. The call stack looks like:

```
factorial(4)
  → factorial(3)
    → factorial(2)
      → factorial(1)
        → factorial(0) → 1
      ← 1 * 1 = 1
    ← 2 * 1 = 2
  ← 3 * 2 = 6
← 4 * 6 = 24
```

All frames pile up, then unwind doing work on the way back.

**Tail recursion**: the recursive call is the *very last* action — its return value is returned directly, with no pending computation.

```java
public static int factorialTail(int n, int acc) {
    if (n == 0) return acc;
    return factorialTail(n - 1, n * acc);  // nothing left to do after this call
}
```

Each frame hands off completely to the next call — there's no "unwinding work" left. Conceptually, once frame `n` calls frame `n-1`, frame `n` has nothing more to contribute; its stack slot could theoretically be reused.

## Binary search example

```java
return binarySearchUtilForRecursion(arr, data, start, mid-1);
```

This *is* tail-recursive — the result of the recursive call is returned immediately, with no computation applied afterward. Compare to something like:

```java
return 1 + binarySearchUtilForRecursion(...); // NOT tail-recursive — the +1 happens after return
```

## Why it matters — and the Java-specific catch

In languages with **tail-call optimization (TCO)** — Scheme, Haskell, Elixir, and to some extent Scala — the compiler/runtime detects a tail call and reuses the current stack frame instead of pushing a new one. That turns O(log n) or O(n) space into **O(1) space**, and also avoids stack overflow on deep recursion.

**Java does not do TCO.** The JVM has no such optimization (there's long been discussion in the Java/JVM community about adding it, but the standard `javac`/HotSpot pipeline never performs it). So even though a method is written in tail-recursive style, Java still pushes a new stack frame per call — meaning stated O(log n) space complexity for something like binary search is real, not just a theoretical worst case that an optimizing compiler would erase.

Practical consequence: if you tail-recurse deeply enough in Java (say, a non-log-bounded recursion over 50,000+ elements), you can still hit `StackOverflowError`, because Java pays the frame cost regardless of whether the recursion is tail-form or not. If you needed guaranteed O(1) space in Java, you'd have to manually convert to iteration.

**One-line summary**: tail recursion is about *how the code is shaped* (nothing pending after the recursive call); TCO is about *whether the runtime exploits that shape* to save stack space. Java has the former available as a style choice, but never gives you the latter as a free space win.
