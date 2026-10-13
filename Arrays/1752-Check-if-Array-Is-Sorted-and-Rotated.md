# 1752. Check if Array Is Sorted and Rotated

## Intuition

A sorted array can be rotated any number of positions, including zero.

We need to check whether the array has been rotated from a sorted array.

If we compare each element with the next element, including the last element with the first element, there should be **at most one decrease**.

For example:

`[3, 4, 5, 1, 2]`

Here, `5 > 1` is the only decrease, so the answer is `true`.

## Approach

1. Initialize `count = 0` to count the decreases.
2. Traverse the array using a loop.
3. Compare `nums[i]` with `nums[(i + 1) % n]`.
4. If `nums[i] > nums[(i + 1) % n]`, increment `count`.
5. If `count` is greater than `1`, the array is not a valid sorted rotation.
6. Return `count <= 1`.

**Why use `% n`?**

`(i + 1) % n` gives the next index. When we reach the last element, it returns index `0`, allowing us to compare the last element with the first element.

This also handles an already sorted array, where the circular comparison produces one decrease at the last-to-first boundary.

## Code

```java
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}
```

## Complexity

- **Time Complexity:** O(n) — We traverse the array once.
- **Space Complexity:** O(1) — We use only a few variables.

## Examples

**Example 1**

Input: `nums = [3, 4, 5, 1, 2]`

Output: `true`

Explanation: The array can be obtained by rotating `[1, 2, 3, 4, 5]`.

**Example 2**

Input: `nums = [2, 1, 3, 4]`

Output: `false`

Explanation: There are two decreases in the circular comparison.

**Example 3**

Input: `nums = [1, 2, 3]`

Output: `true`

Explanation: The array is already sorted, so zero rotations are needed.

**Example 4**

Input: `nums = [1, 1, 2, 2, 3]`

Output: `true`

Explanation: Duplicate elements are allowed, and the array is already sorted.

## Key Learning

- A rotation can happen zero or more times.
- Duplicate elements are allowed.
- Count decreases using circular comparison.
- If `count <= 1`, return `true`; otherwise, return `false`.
