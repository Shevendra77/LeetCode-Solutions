# 977. Squares of a Sorted Array

## Intuition

The array is already sorted, but after squaring each element, negative numbers become positive, so the order is no longer sorted.

The largest square will always come from either the leftmost or the rightmost element. We use two pointers to compare both ends and place the larger square at the end of the result array.

## Approach

1. Create a result array of the same size.
2. Initialize three pointers:
   - `left = 0`
   - `right = nums.length - 1`
   - `index = nums.length - 1`
3. Compare the squares of `nums[left]` and `nums[right]`.
4. Place the larger square at `ans[index]`.
5. If the left square is larger, increment `left`; otherwise, decrement `right`.
6. Decrement `index`.
7. Repeat until `left > right`.
8. Return the result array.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

## Java Code

```java
// Solution is available in 977-Squares-of-a-Sorted-Array.java
```