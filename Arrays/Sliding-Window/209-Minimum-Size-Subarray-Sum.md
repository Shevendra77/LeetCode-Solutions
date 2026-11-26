# Minimum Size Subarray Sum

**Difficulty:** Medium

**Topic:** Array, Variable Size Sliding Window, Two Pointers

## 🧠 Problem Understanding

Given an array of positive integers `nums` and an integer `target`, find the minimum length of a contiguous subarray whose sum is greater than or equal to `target`.

If no such subarray exists, return `0`.

## Example 1

**Input:**
```text
target = 7
nums = [2, 3, 1, 2, 4, 3]
```

**Output:**
```text
2
```

**Explanation:**

The valid subarrays whose sum is greater than or equal to `7` include:

- `[2, 3, 1, 2]` → Sum = 8, Length = 4
- `[3, 1, 2, 4]` → Sum = 10, Length = 4
- `[1, 2, 4]` → Sum = 7, Length = 3
- `[4, 3]` → Sum = 7, Length = 2

Minimum subarray length = `2`.

## Example 2

**Input:**
```text
target = 4
nums = [1, 4, 4]
```

**Output:**
```text
1
```

**Explanation:**

The subarray `[4]` has a sum of `4` and its length is `1`.

## Example 3

**Input:**
```text
target = 11
nums = [1, 1, 1, 1, 1, 1, 1, 1]
```

**Output:**
```text
0
```

**Explanation:**

No contiguous subarray has a sum greater than or equal to `11`.

## Approach: Variable Size Sliding Window

### Intuition

We need to find the minimum length of a contiguous subarray whose sum is greater than or equal to the target.

A Variable Size Sliding Window is useful because the window size changes dynamically.

We use three variables:

- `left`: Stores the starting index of the current window.
- `sum`: Stores the sum of the current window.
- `minLength`: Stores the minimum valid subarray length found so far.

We expand the window by moving the `right` pointer and adding elements to `sum`.

Whenever `sum >= target`, the current window is valid. We calculate its length, update `minLength`, and shrink the window by removing elements from the left.

We continue until the entire array has been traversed.

### Steps

1. Initialize `left = 0`.
2. Initialize `sum = 0`.
3. Initialize `minLength = Integer.MAX_VALUE`.
4. Traverse the array using the `right` pointer.
5. Add the current element to `sum`.
6. If `sum >= target`, calculate the current window length using `right - left + 1`.
7. Update `minLength` using `Math.min()`.
8. Remove `nums[left]` from the current sum.
9. Increment `left` to shrink the window.
10. Repeat the shrinking process while `sum >= target`.
11. Return `0` if no valid subarray is found; otherwise, return `minLength`.

### Java Code

```java
class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window using the right pointer
        for (int right = 0; right < nums.length; right++) {

            // Add the current element to the window sum
            sum += nums[right];

            // Shrink the window while the sum satisfies the target
            while (sum >= target) {

                // Calculate the current window length
                int currentLength = right - left + 1;

                // Update the minimum subarray length
                minLength = Math.min(minLength, currentLength);

                // Remove the leftmost element from the window
                sum -= nums[left];

                // Move the left pointer to shrink the window
                left++;
            }
        }

        // Return 0 if no valid subarray is found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

### Compact Alternative

```java
for (int right = 0; right < nums.length; right++) {

    sum += nums[right];

    while (sum >= target) {

        minLength = Math.min(minLength, right - left + 1);

        sum -= nums[left++];
    }
}

return minLength == Integer.MAX_VALUE ? 0 : minLength;
```

Same logic and complexity, just written more tersely.

---

## Dry Run

**Input:**
```text
target = 7
nums = [2, 3, 1, 2, 4, 3]
```

**Initial Values:**
```text
left = 0
sum = 0
minLength = Integer.MAX_VALUE
```

**Array Traversal:**

| Right | nums[right] | Sum after adding | Shrinking steps (while sum >= 7) | Window after shrinking | Min Length |
|---:|---:|---:|---|---|---:|
| 0 | 2 | 2 | none | [2] | INF |
| 1 | 3 | 5 | none | [2, 3] | INF |
| 2 | 1 | 6 | none | [2, 3, 1] | INF |
| 3 | 2 | 8 | `[2,3,1,2]` len 4 → remove 2 → sum 6 | [3, 1, 2] | 4 |
| 4 | 4 | 10 | `[3,1,2,4]` len 4 → remove 3 → sum 7; `[1,2,4]` len 3 → remove 1 → sum 6 | [2, 4] | 3 |
| 5 | 3 | 9 | `[2,4,3]` len 3 → remove 2 → sum 7; `[4,3]` len 2 → remove 4 → sum 3 | [3] | 2 |

**Final Output:**
```text
2
```

---

## Edge Cases

| Input | Output | Why |
|---|---:|---|
| `target = 7, nums = [2,3,1,2,4,3]` | 2 | Minimum valid length is 2 |
| `target = 4, nums = [1,4,4]` | 1 | Single element satisfies target |
| `target = 11, nums = [1,1,1,1]` | 0 | No valid subarray |
| `target = 5, nums = [5]` | 1 | Single element equals target |
| `target = 3, nums = [1,1,1]` | 3 | Entire array is required |

## Complexity Analysis

- **Time Complexity:** O(n) – Each element is added and removed at most once because both pointers move only forward.
- **Space Complexity:** O(1) – Only a few variables are used; no extra data structure is required.

## Key Concepts

- Variable Size Sliding Window
- Two Pointers
- Subarray
- Expand and Shrink Window
- Minimum Length
- `Math.min()`
- `Integer.MAX_VALUE`

## Interview Note

The most important logic in this problem is:

```java
while (sum >= target) {

    minLength = Math.min(minLength, right - left + 1);

    sum -= nums[left];
    left++;
}
```

Whenever the current window sum becomes greater than or equal to the target, we have found a valid subarray.

We calculate its length and update the minimum length.

Then we shrink the window from the left to find a smaller valid subarray.

**Important Formula:**

```java
right - left + 1
```

This calculates the length of the current subarray.

**Common Pitfall:** Using `if (sum >= target)` instead of `while (sum >= target)` will not shrink the window repeatedly, so we may miss a shorter valid subarray.

**Note:** This sliding window approach works because all array elements are positive (as specified in LeetCode 209). It does not generally work with negative numbers.

**Recommended Approach: Variable Size Sliding Window (Two Pointers).**