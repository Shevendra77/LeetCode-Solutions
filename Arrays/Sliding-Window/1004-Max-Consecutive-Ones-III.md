# Max Consecutive Ones III

**Difficulty:** Medium

**Topic:** Array, Variable-Size Sliding Window, Two Pointers

## 🧠 Problem Understanding

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s if we can flip at most `k` zeros into ones.

In simple words:

- We can convert at most `k` zeros into ones.
- We need to find the longest contiguous subarray.
- Return the maximum length of that subarray.

**Reframing:** Flipping at most `k` zeros is the same as finding the **longest subarray that contains at most `k` zeros**.

## Example 1

**Input:**
```text
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
```

**Output:**
```text
6
```

**Explanation:**

We can flip at most two zeros into ones.

One possible longest subarray (indices 4 to 9):

```text
[0,0,1,1,1,1]
```

After flipping two zeros:

```text
[1,1,1,1,1,1]
```

Maximum consecutive ones = `6`.

## Example 2

**Input:**
```text
nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
k = 3
```

**Output:**
```text
10
```

**Explanation:**

The longest subarray with at most three zeros is indices `2` to `11`:

```text
[1,1,0,0,1,1,1,0,1,1]
```

It contains exactly three zeros (at indices 4, 5 and 9). After flipping them:

```text
[1,1,1,1,1,1,1,1,1,1]
```

Maximum consecutive ones = `10`.

## Approach: Variable-Size Sliding Window

### Intuition

We need to find the longest subarray containing at most `k` zeros.

Instead of checking every possible subarray (O(n²)), we use the **Variable-Size Sliding Window** technique.

We maintain:

- `left`: Starting index of the current window.
- `right`: Ending index of the current window.
- `countZero`: Counts zeros inside the current window.
- `maxLen`: Stores the maximum valid window length found so far.

**Window Condition:**

```text
countZero <= k
```

If the number of zeros becomes greater than `k`, shrink the window from the left until it becomes valid again.

### Steps

1. Initialize `left = 0`.
2. Initialize `maxLen = 0`.
3. Initialize `countZero = 0`.
4. Traverse the array using the `right` pointer.
5. If `nums[right] == 0`, increment `countZero`.
6. While `countZero > k`, shrink the window from the left:
   - If `nums[left] == 0`, decrement `countZero`.
   - Increment `left`.
7. Calculate the current window length using `right - left + 1`.
8. Update `maxLen`.
9. Return `maxLen`.

### Java Code

```java
class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;       // Starting index of the window
        int maxLen = 0;     // Maximum valid window length
        int countZero = 0;  // Number of zeros in the current window

        // Expand the window using right pointer
        for (int right = 0; right < nums.length; right++) {

            // Count zeros entering the window
            if (nums[right] == 0) {
                countZero++;
            }

            // Shrink the window if zeros exceed k
            while (countZero > k) {

                if (nums[left] == 0) {
                    countZero--;
                }

                left++;
            }

            // Update maximum valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

---

## Dry Run (Iteration by Iteration)

**Input:**
```text
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
```

**Initial Values:**
```text
left = 0
countZero = 0
maxLen = 0
```

The table shows values **after** the shrink step in each iteration.

| Iteration | right | nums[right] | countZero | left | Calculation | maxLen |
|---|---:|---:|---:|---:|---|---:|
| 1 | 0 | 1 | 0 | 0 | 0 - 0 + 1 = 1 | 1 |
| 2 | 1 | 1 | 0 | 0 | 1 - 0 + 1 = 2 | 2 |
| 3 | 2 | 1 | 0 | 0 | 2 - 0 + 1 = 3 | 3 |
| 4 | 3 | 0 | 1 | 0 | 3 - 0 + 1 = 4 | 4 |
| 5 | 4 | 0 | 2 | 0 | 4 - 0 + 1 = 5 | 5 |
| 6 | 5 | 0 | 2 | 4 | 5 - 4 + 1 = 2 | 5 |
| 7 | 6 | 1 | 2 | 4 | 6 - 4 + 1 = 3 | 5 |
| 8 | 7 | 1 | 2 | 4 | 7 - 4 + 1 = 4 | 5 |
| 9 | 8 | 1 | 2 | 4 | 8 - 4 + 1 = 5 | 5 |
| 10 | 9 | 1 | 2 | 4 | 9 - 4 + 1 = 6 | 6 |
| 11 | 10 | 0 | 2 | 5 | 10 - 5 + 1 = 6 | 6 |

**Important: Iteration 6**

At `right = 5`:

```text
nums[right] = 0
countZero = 3
k = 2
```

Since `countZero > k`, we shrink the window.

```text
nums[left] = 1 → countZero remains 3
left = 1

nums[left] = 1 → countZero remains 3
left = 2

nums[left] = 1 → countZero remains 3
left = 3

nums[left] = 0 → countZero becomes 2
left = 4
```

Now the window becomes valid because:

```text
countZero = 2
k = 2
```

**Iteration 11** also shrinks the window: a new zero enters (`countZero = 3`), so `left` moves past the zero at index 4, giving `countZero = 2` and `left = 5`.

**Final Output:**
```text
6
```

---

## Edge Cases

| Input | Output | Why |
|---|---:|---|
| `nums = [1,1,1], k = 0` | 3 | No zeros, whole array is valid |
| `nums = [0,0,0], k = 0` | 0 | No flips allowed, no ones exist |
| `nums = [0,0,0], k = 2` | 2 | Can flip only two zeros |
| `nums = [0,0,0], k = 5` | 3 | `k` exceeds zeros, whole array becomes ones |
| `nums = [1,0,1,0,1], k = 1` | 3 | One flip joins two neighbouring groups |
| `k = 0` (any array) | Same as *Max Consecutive Ones I* | Longest run of existing ones |

## Complexity Analysis

- **Time Complexity:** O(n) – Both `left` and `right` pointers only move forward and each traverses the array at most once. The inner `while` loop does not make it O(n²), because `left` never moves backward (amortized O(1) per element).
- **Space Complexity:** O(1) – Only a few variables are used.

## Key Concepts

- Array Traversal
- Variable-Size Sliding Window
- Two Pointers
- Zero Counting
- Window Expansion
- Window Shrinking
- Maximum Window Length

## Interview Note

**1. When does `right` increment?**

In every iteration of the `for` loop, it expands the window.

**2. When does `left` increment?**

When `countZero > k`, the `while` loop shrinks the window.

**3. Does `maxLen` update in every iteration?**

Yes. It executes after the `while` loop in every `for` loop iteration.

**4. Why use `while` instead of `if`?**

In this specific problem, one new element enters per step, so at most one zero is added and `countZero` exceeds `k` by at most 1. The `while` loop is still the safer, standard template: `left` may need to skip over several `1`s before it removes a zero and the window becomes valid again.

**5. Important Formula:**

```java
maxLen = Math.max(maxLen, right - left + 1);
```

This calculates the current valid window length and stores the maximum length found so far.

**6. Follow-up optimization (non-shrinking window):**

Since we only want the *maximum* length, the window never needs to shrink. Instead, slide it forward by one when it becomes invalid:

```java
int left = 0, countZero = 0;
for (int right = 0; right < nums.length; right++) {
    if (nums[right] == 0) countZero++;
    if (countZero > k) {
        if (nums[left] == 0) countZero--;
        left++;
    }
}
return nums.length - left;
```

The window size never decreases, so its final size is the answer. Same O(n) time, but the `if` replaces the `while`.

**Recommended Approach: Variable-Size Sliding Window.**