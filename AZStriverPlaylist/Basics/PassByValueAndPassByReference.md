# Pass by Value vs Pass by Reference in Java

In **Java**, **everything is passed by value** — but understanding what *"value"* means in different contexts is key. Let’s break it down clearly with examples.

---

## 🔹 1. Pass by Value – Always

Java **always** passes arguments **by value**, which means it passes a **copy of the variable**.

However, depending on the **type of variable**, this behaves differently:

---

## ✅ For Primitive Types (int, double, boolean, etc.)

- Java passes a **copy of the actual value**.
- Changes inside the method **do not affect** the original value.

```java
void changeValue(int x) {
    x = 10;
}

public static void main(String[] args) {
    int a = 5;
    changeValue(a);
    System.out.println(a); // Output: 5
}
```

**Explanation:**  
The method gets a **copy of `a`**, not `a` itself. So, changes to `x` don't affect `a`.

---

## ✅ For Objects (including arrays)

- Java still passes **by value**, but the value is the **reference to the object**.
- So, the method gets a **copy of the reference** (a pointer to the same object).
- Modifying the object through the reference affects the original object.

```java
class Person {
    String name;
}

void modify(Person p) {
    p.name = "John";
}

public static void main(String[] args) {
    Person p1 = new Person();
    p1.name = "Alice";
    modify(p1);
    System.out.println(p1.name); // Output: John
}
```

**Explanation:**  
A **copy of the reference** is passed. Both the original and the copied reference point to the **same object in memory**.

---

## ❌ You cannot change the original reference

If you try to reassign the object itself inside the method, it won’t affect the original.

```java
void reassign(Person p) {
    p = new Person();   // Only changes local reference
    p.name = "Bob";
}

public static void main(String[] args) {
    Person p1 = new Person();
    p1.name = "Alice";
    reassign(p1);
    System.out.println(p1.name); // Output: Alice
}
```

**Explanation:**  
`p` now points to a new object, but `p1` outside still points to the old one.

---

## 🔁 Summary Table

| Type      | What’s Passed         | Changes Affected?                     |
|-----------|------------------------|----------------------------------------|
| Primitive | Copy of the value      | ❌ No                                   |
| Object    | Copy of the reference  | ✅ Yes (object data), ❌ No (reference itself) |

---

## 🧠 Key Takeaways

- **Java is strictly pass-by-value.**
- For **primitives**, it's the value of the variable.
- For **objects**, it's the value of the reference (pointer to object).
- You can **modify the object**, but not **reassign the reference** in the caller’s context.