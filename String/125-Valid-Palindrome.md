# 125. Valid Palindrome

## Intuition

A palindrome reads the same forward and backward.

Instead of creating a new string, we use **two pointers**:

- One pointer starts from the beginning.
- The other starts from the end.

We skip all non-alphanumeric characters and compare the remaining characters after converting them to lowercase. If any pair doesn't match, the string is not a palindrome.

---

## Approach

1. Initialize two pointers:
   - `left = 0`
   - `right = s.length() - 1`
2. Move `left` forward until it points to an alphanumeric character.
3. Move `right` backward until it points to an alphanumeric character.
4. Compare both characters after converting them to lowercase.
5. If they are different, return `false`.
6. Otherwise, move both pointers inward.
7. Repeat until `left >= right`.
8. If all characters match, return `true`.

---

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

---

## Java Code

```java
// Solution is available in 125-Valid-Palindrome.java
```