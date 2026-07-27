# 151. Reverse Words in a String

## Intuition

The given string may contain leading, trailing, or multiple spaces between words.

Before reversing the words, we first remove unnecessary spaces.

We use:

- `trim()` to remove leading and trailing spaces.
- `split("\\s+")` to split the string into words using one or more spaces as the separator.
- Traverse the words array from the end to the beginning.
- Use a `StringBuilder` to efficiently build the reversed string.

---

## Approach

1. Remove leading and trailing spaces using `trim()`.
2. Split the string into words using `split("\\s+")`.
3. Create a `StringBuilder` to store the result.
4. Traverse the words array from the last word to the first.
5. Append each word to the `StringBuilder`.
6. Add a single space after each word except the last one.
7. Return the final reversed string.

---

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---

## Java Code

```java
// Solution is available in 151-Reverse-Words-in-a-String.java
```