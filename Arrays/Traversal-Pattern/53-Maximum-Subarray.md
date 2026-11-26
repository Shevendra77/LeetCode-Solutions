````md
# 53. Maximum Subarray

## Intuition

The goal is to find the contiguous subarray with the largest sum.

At each index, we have two choices:

- Start a new subarray from the current element.
- Continue the previous subarray.

We choose the option that gives the maximum sum. This is the core idea behind **Kadane's Algorithm**.

---

## Approach

1. Initialize `currentSum` and `maxSum` with the first element.
2. Traverse the array from index `1`.
3. Update `currentSum` as the maximum of:
   - Current element (`nums[i]`)
   - Previous subarray sum + current element (`currentSum + nums[i]`)
4. Update `maxSum` if `currentSum` is greater.
5. Return `maxSum`.

---

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

---

## Java Code

```java
// Solution is available in 53-Maximum-Subarray.java
````

```
```
