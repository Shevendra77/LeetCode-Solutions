# 136. Single Number

## Intuition

Every element appears twice except one. Using the XOR (`^`) operation, duplicate numbers cancel each other out because:

- `a ^ a = 0`
- `a ^ 0 = a`

By XORing all elements in the array, every pair becomes `0`, leaving only the single number.

## Approach

1. Initialize a variable `ans = 0`.
2. Traverse the array.
3. XOR each element with `ans`.
4. Since duplicate numbers cancel each other out, only the single number remains.
5. Return `ans`.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 136-Single-Number.java
```