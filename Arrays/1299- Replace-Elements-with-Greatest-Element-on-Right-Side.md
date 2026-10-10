# 1299. Replace Elements with Greatest Element on Right Side

## Intuition

For every element, we need to find the greatest element on its right side. The last element must be replaced with `-1` because there are no elements to its right.

Instead of checking all elements on the right for every index, we can traverse the array from right to left and maintain the maximum element seen so far.

## Approach

1. Initialize `max = -1`.
2. Traverse the array from right to left, starting from `arr.length - 1`.
3. Store the current element in a temporary variable `temp`.
4. Replace `arr[i]` with `max`.
5. Update `max = Math.max(max, temp)`.
6. Continue until the first element is processed.
7. Return the modified array.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in
// 1299-Replace-Elements-with-Greatest-Element-on-Right-Side.java
```

## Example

**Input:** `[17, 18, 5, 4, 6, 1]`

**Output:** `[18, 6, 6, 6, 1, -1]`

## LeetCode Link

https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/