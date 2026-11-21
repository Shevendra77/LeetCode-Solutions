
# 283. Move Zeroes

**Difficulty:** Easy

**Topic:** Array, Two Pointers, Swapping

## 🧠 Problem Understanding

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of non-zero elements.

You must perform this operation in-place without making a copy of the array.

## Example 1

**Input:**
nums = [0,1,0,3,12]

**Output:**
[1,3,12,0,0]

**Explanation:**
Move all zeros to the end while maintaining the relative order of non-zero elements.

## Example 2

**Input:**
nums = [0]

**Output:**
[0]

---

## Approach: Two Pointers + Swapping

### Intuition

Use two pointers to move all non-zero elements to the beginning of the array.

- `i`: Tracks the position where the next non-zero element should be placed.
- `j`: Traverses the entire array.

### Steps

1. Initialize `i = 0`.
2. Traverse the array using `j` from index 0.
3. Check whether `nums[j] != 0`.
4. If the element is non-zero:
   - Swap `nums[i]` and `nums[j]`.
   - Increment `i`.
5. Continue until the array traversal is complete.

### Java Code

class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            // If j is non-zero, swap with i
            if (nums[j] != 0) {

                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
            }
        }
    }
}

---

## Dry Run

**Input:**
nums = [0,1,0,3,12]

**Initial Values:**
i = 0

| j | nums[j] | Operation | i | Array |
|---|---|---|---|---|
| 0 | 0 | Skip | 0 | [0,1,0,3,12] |
| 1 | 1 | Swap(0,1) | 1 | [1,0,0,3,12] |
| 2 | 0 | Skip | 1 | [1,0,0,3,12] |
| 3 | 3 | Swap(1,3) | 2 | [1,3,0,0,12] |
| 4 | 12 | Swap(2,4) | 3 | [1,3,12,0,0] |

**Final Output:**

[1,3,12,0,0]

---

## Complexity Analysis

- Time Complexity: O(n) – Traverse the array once.
- Space Complexity: O(1) – No extra array or data structure is used.

## Key Concepts

- Two Pointers
- Array
- Swapping
- In-place Modification
- Maintaining Relative Order

## Interview Note

The Two Pointers approach moves all non-zero elements to the beginning and automatically shifts zeros to the end.

It maintains the relative order of non-zero elements and uses O(1) extra space.

**Recommended Approach: Two Pointers + Swapping.**
