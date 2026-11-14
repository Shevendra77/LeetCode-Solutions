# 1004. Max Consecutive Ones III

**LeetCode:** [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

**Difficulty:** Medium

**Topics:** Array, Sliding Window, Binary Search, Prefix Sum

## Problem Statement

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` zeros.

The problem is equivalent to: **find the longest subarray that contains at most `k` zeros.**

---

## Approach 1: Brute Force

### Intuition

Generate every subarray and count the zeros in it.

If the zero count is at most `k`, update the maximum length. If it exceeds `k`, stop extending from this starting index, because adding more elements can never reduce the zero count.

### Algorithm

1. Initialize `maxLen = 0`.
2. For each starting index `i`, set `zeroCount = 0`.
3. For each ending index `j` from `i` to `n - 1`:
   1. If `nums[j] == 0`, increment `zeroCount`.
   2. If `zeroCount <= k`, update `maxLen` with `j - i + 1`.
   3. Otherwise, break the inner loop.
4. Return `maxLen`.

### Java Code

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeroCount++;
                }

                if (zeroCount <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}
```

### Complexity Analysis

- **Time:** O(N²). Each starting index may scan to the end of the array.
- **Space:** O(1)

---

## Approach 2: Sliding Window Using `while`

### Intuition

Instead of checking every subarray, maintain a window `[left, right]` that always contains at most `k` zeros.

- Expand the window by moving `right`.
- If the window now has more than `k` zeros, shrink it from the left until it is valid again.
- After each step, the window is valid, so its length is a candidate answer.

### Algorithm

1. Initialize `left = 0`, `maxLen = 0`, `zeroCount = 0`.
2. For `right` from `0` to `n - 1`:
   1. If `nums[right] == 0`, increment `zeroCount`.
   2. While `zeroCount > k`:
      - If `nums[left] == 0`, decrement `zeroCount`.
      - Increment `left`.
   3. Update `maxLen` with `right - left + 1`.
3. Return `maxLen`.

### Java Code

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

### Complexity Analysis

- **Time:** O(N). `right` visits each element once and `left` only moves forward, so each element is added and removed at most once.
- **Space:** O(1)

---

## Approach 3: Sliding Window Using `if`

### Intuition

We only need the **length** of the longest valid window, not the window itself. So the window never needs to shrink.

When the window becomes invalid (more than `k` zeros), move `left` forward by just **one** step. This slides the window instead of shrinking it, so its size stays the same.

- While the window is valid, it grows with `right`.
- Once it becomes invalid, it keeps its size and slides right.
- The size therefore never decreases, and it only grows when a truly valid, larger window exists.

As a result, `maxLen` ends up correct, even though the window may temporarily contain more than `k` zeros and `zeroCount` may be greater than `k` at times.

### Algorithm

1. Initialize `left = 0`, `maxLen = 0`, `zeroCount = 0`.
2. For `right` from `0` to `n - 1`:
   1. If `nums[right] == 0`, increment `zeroCount`.
   2. If `zeroCount > k`:
      - If `nums[left] == 0`, decrement `zeroCount`.
      - Increment `left`.
   3. Update `maxLen` with `right - left + 1`.
3. Return `maxLen`.

### Java Code

```java
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```

### Complexity Analysis

- **Time:** O(N)
- **Space:** O(1)

---

## Dry Run (Approach 2, `while`)

**Input:**

```text
nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
k = 2
```

We can flip at most two zeros.

| right | nums[right] | zeroCount (after shrinking) | left | Window Length | maxLen |
|---:|---:|---:|---:|---:|---:|
| 0 | 1 | 0 | 0 | 1 | 1 |
| 1 | 1 | 0 | 0 | 2 | 2 |
| 2 | 1 | 0 | 0 | 3 | 3 |
| 3 | 0 | 1 | 0 | 4 | 4 |
| 4 | 0 | 2 | 0 | 5 | 5 |
| 5 | 0 | 2 (was 3) | 4 | 2 | 5 |
| 6 | 1 | 2 | 4 | 3 | 5 |
| 7 | 1 | 2 | 4 | 4 | 5 |
| 8 | 1 | 2 | 4 | 5 | 5 |
| 9 | 1 | 2 | 4 | 6 | 6 |
| 10 | 0 | 2 (was 3) | 5 | 6 | 6 |

At `right = 5`, the third zero pushes `zeroCount` to 3, so `left` moves from `0` to `4`, past three `1`s and the zero at index 3. The same thing happens at `right = 10`, where `left` moves from `4` to `5`.

**Output:**

```text
6
```

One longest valid subarray is `nums[5..10]`:

```text
[0, 1, 1, 1, 1, 0]
```

It contains two zeros, which can be flipped to ones, giving six consecutive `1`s.

---

## Comparison of All Three Approaches

| Approach | Time | Space | Window Always Valid? |
|---|---|---|---|
| Brute Force | O(N²) | O(1) | Yes |
| Sliding Window (`while`) | O(N) | O(1) | Yes |
| Sliding Window (`if`) | O(N) | O(1) | No (size is what matters) |

## Important Concepts

### 1. Variable Size Sliding Window

Used when the subarray size is not fixed and we need to maintain a condition, here "at most `k` zeros".

### 2. Why `right - left + 1`?

Both `left` and `right` are included in the window.

```java
left = 2;
right = 5;

length = 5 - 2 + 1; // 4 -> indices 2, 3, 4, 5
```

### 3. `while` vs `if`

| `while` | `if` |
|---|---|
| Shrinks until the window is valid | Moves `left` by only one position |
| Window is always valid, so `zeroCount <= k` | Window may hold more than `k` zeros |
| Window size can go down | Window size never goes down |
| `maxLen` is always the size of a valid window | `maxLen` is correct because it only grows for valid windows |
| O(N) | O(N) |

## Interview Takeaway

**Primary Approach:** Variable size sliding window using `while`. It is the easiest to explain and to prove correct.

Remember:

- Expand the window using `right`.
- Track the zeros inside the window.
- Shrink using `left` when zeros exceed `k`.
- Update the maximum window length.

**Pattern:** Longest subarray with at most `K` zeros (or `K` distinct elements, or `K` replacements).