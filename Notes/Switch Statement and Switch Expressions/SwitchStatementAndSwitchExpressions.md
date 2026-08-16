# Switch Case and Switch Expression in Java

## 1. Traditional `switch` Statement

The `switch` statement is used to execute different blocks of code based on the value of an expression.

### Syntax

    switch (expression) {
        case value1:
            // code
            break;

        case value2:
            // code
            break;

        default:
            // code
    }

### Example

    int day = 2;

    switch (day) {
        case 1:
            System.out.println("Monday");
            break;

        case 2:
            System.out.println("Tuesday");
            break;

        case 3:
            System.out.println("Wednesday");
            break;

        default:
            System.out.println("Invalid day");
    }

Output:

    Tuesday

---

## 2. `break` in Traditional Switch

In a traditional `switch`, if `break` is not used, execution falls through to the next case.

### Example

    int day = 2;

    switch (day) {
        case 1:
            System.out.println("Monday");

        case 2:
            System.out.println("Tuesday");

        case 3:
            System.out.println("Wednesday");

        default:
            System.out.println("Invalid day");
    }

Output:

    Tuesday
    Wednesday
    Invalid day

### With `break`

    switch (day) {
        case 1:
            System.out.println("Monday");
            break;

        case 2:
            System.out.println("Tuesday");
            break;

        case 3:
            System.out.println("Wednesday");
            break;

        default:
            System.out.println("Invalid day");
    }

Only the matching case is executed.

---

## 3. Multiple Cases With Same Logic

Multiple cases can execute the same block of code.

    int day = 6;

    switch (day) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            System.out.println("Weekday");
            break;

        case 6:
        case 7:
            System.out.println("Weekend");
            break;

        default:
            System.out.println("Invalid day");
    }

Output:

    Weekend

---

# 4. Switch Expression

A **switch expression** returns a value.

Switch expressions became a standard feature in **Java 14**.

### Syntax

    result = switch (expression) {
        case value1 -> result1;
        case value2 -> result2;
        default -> defaultResult;
    };

### Example

    int day = 2;

    String dayName = switch (day) {
        case 1 -> "Monday";
        case 2 -> "Tuesday";
        case 3 -> "Wednesday";
        default -> "Invalid day";
    };

    System.out.println(dayName);

Output:

    Tuesday

The result of the `switch` is directly assigned to `dayName`.

---

# 5. Arrow Syntax `->`

Modern switch supports the arrow syntax.

    switch (day) {
        case 1 -> System.out.println("Monday");
        case 2 -> System.out.println("Tuesday");
        case 3 -> System.out.println("Wednesday");
        default -> System.out.println("Invalid day");
    }

### Important

With `->`:

- `break` is not required.
- There is no fall-through.
- Only the matching case is executed.

---

# 6. Switch Expression With Multiple Statements

If a case contains multiple statements, use `{}`.

    int day = 2;

    String result = switch (day) {
        case 1 -> {
            System.out.println("Processing Monday");
            yield "Monday";
        }

        case 2 -> {
            System.out.println("Processing Tuesday");
            yield "Tuesday";
        }

        default -> {
            yield "Invalid";
        }
    };

---

# 7. `yield` Keyword

`yield` is used to return a value from a block inside a switch expression.

### Example

    int number = 10;

    String result = switch (number) {
        case 10 -> {
            int value = number * 2;
            yield "Result = " + value;
        }

        default -> {
            yield "Invalid";
        }
    };

Output:

    Result = 20

### `return` vs `yield`

`return` returns a value from a **method**.

    return value;

`yield` returns a value from a **switch expression**.

    yield value;

---

# 8. Traditional Switch vs Switch Expression

### Traditional Switch

    String result;

    switch (day) {
        case 1:
            result = "Monday";
            break;

        case 2:
            result = "Tuesday";
            break;

        default:
            result = "Invalid";
    }

### Switch Expression

    String result = switch (day) {
        case 1 -> "Monday";
        case 2 -> "Tuesday";
        default -> "Invalid";
    };

The switch expression is shorter and avoids accidental fall-through.

---

# 9. Switch With String

`switch` can be used with `String`.

    String role = "ADMIN";

    String message = switch (role) {
        case "ADMIN" -> "Full access";
        case "USER" -> "Limited access";
        case "GUEST" -> "Read-only access";
        default -> "Unknown role";
    };

---

# 10. Switch With Enum

`switch` is commonly used with enums.

    enum Status {
        SUCCESS,
        FAILED,
        PENDING
    }

Example:

    Status status = Status.SUCCESS;

    String message = switch (status) {
        case SUCCESS -> "Operation successful";
        case FAILED -> "Operation failed";
        case PENDING -> "Operation is pending";
    };

If all enum values are covered, `default` is not required.

---

# 11. Switch With Character

    char grade = 'A';

    String result = switch (grade) {
        case 'A' -> "Excellent";
        case 'B' -> "Good";
        case 'C' -> "Average";
        case 'D' -> "Poor";
        default -> "Invalid grade";
    };

---

# 12. Switch With Integer

    int number = 3;

    String result = switch (number) {
        case 1 -> "One";
        case 2 -> "Two";
        case 3 -> "Three";
        default -> "Other";
    };

---

# 13. `break` vs `yield`

| Keyword | Purpose |
|---|---|
| `break` | Exits a traditional switch statement |
| `yield` | Returns a value from a switch-expression block |
| `return` | Returns a value from a method |

### `break`

    switch (day) {
        case 1:
            System.out.println("Monday");
            break;
    }

### `yield`

    String result = switch (day) {
        case 1 -> {
            yield "Monday";
        }

        default -> {
            yield "Invalid";
        }
    };

---

# 14. Switch Statement vs Switch Expression

| Feature | Switch Statement | Switch Expression |
|---|---|---|
| Returns a value | No | Yes |
| `break` | Usually required with `:` | Not required with `->` |
| Fall-through | Possible with `:` | No with `->` |
| `yield` | No | Yes |
| Arrow syntax `->` | Yes | Yes |
| Direct assignment | No | Yes |

---

# 15. Traditional vs Modern Syntax

### Traditional

    String result;

    switch (day) {
        case 1:
            result = "Monday";
            break;

        case 2:
            result = "Tuesday";
            break;

        default:
            result = "Invalid";
    }

### Modern

    String result = switch (day) {
        case 1 -> "Monday";
        case 2 -> "Tuesday";
        default -> "Invalid";
    };

---

# 16. Key Points

- `switch` can be used as a **statement** or an **expression**.
- Traditional switch uses `case`, `break`, and `default`.
- Modern switch supports `->`.
- `->` does **not allow fall-through**.
- A switch expression **returns a value**.
- Use `yield` when a switch-expression case contains multiple statements.
- `break` exits a traditional switch.
- `yield` returns a value from a switch-expression block.
- Switch expressions became a standard feature in **Java 14**.
- `switch` can work with `int`, `char`, `String`, and `enum`.
- Prefer **switch expressions with `->`** when mapping a value to a result.

---

# Quick Revision

### Traditional Switch

    switch (expression) {
        case value:
            // code
            break;

        default:
            // code
    }

Characteristics:

- Uses `case:`
- Usually requires `break`
- Fall-through is possible
- Mainly used as a statement

### Switch Expression

    String result = switch (expression) {
        case value -> "result";
        default -> "default result";
    };

Characteristics:

- Uses `case ->`
- Returns a value
- No fall-through
- `break` is not required
- `yield` is used for multi-statement cases
- Standard feature since Java 14