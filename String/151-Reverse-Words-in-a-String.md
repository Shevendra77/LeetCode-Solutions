# 151. Reverse Words in a String

## Intuition

We traverse the string from **right to left** and extract each word.

* Skip extra spaces.
* Use two pointers to find the complete word.
* Append each word to a `StringBuilder`.
* Add only one space between words.

## Approach

**Reverse Traversal + Two Pointers**

## Algorithm

1. Start `i` from the end of the string.
2. Skip extra spaces using `i`.
3. Set `j = i` and move backward to find the complete word.
4. Append the word to `ans`.
5. Skip spaces using `j`.
6. If another word exists, append a single space.
7. Set `i = j` and repeat.
8. Return `ans`.

## Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)`

## Java Code

```java
// Solution is available in 151-Reverse-Words-in-a-String.java
```
