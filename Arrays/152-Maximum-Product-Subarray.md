# Maximum Product Subarray

## Approach

Prefix and Suffix Product Approach (Two Directional Traversal)

## Algorithm

1. Initialize `prefix = 1`, `suffix = 1`, and `ans = Integer.MIN_VALUE`.
2. Traverse the array from left to right using index `i`.
3. If `prefix == 0`, reset it to `1`.
4. If `suffix == 0`, reset it to `1`.
5. Multiply `prefix` by `nums[i]`.
6. Multiply `suffix` by `nums[n - i - 1]` to traverse from right to left.
7. Update `ans` with the maximum among `ans`, `prefix`, and `suffix`.
8. Return `ans`.

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Pattern

Array + Prefix/Suffix + Product

## Java Code

```java
// Solution is available in 152-Maximum-Product-Subarray.java
```