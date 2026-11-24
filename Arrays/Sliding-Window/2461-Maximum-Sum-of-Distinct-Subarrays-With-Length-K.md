# 2461. Maximum Sum of Distinct Subarrays With Length K

**Difficulty:** Medium

**Topic:** Array, Sliding Window, HashMap, Frequency Counting

## 🧠 Problem Understanding

Given an integer array `nums` and an integer `k`, find the maximum sum of a contiguous subarray that satisfies:

- The subarray length must be exactly `k`.
- All elements in the subarray must be distinct.
- If no valid subarray exists, return `0`.

## Example 1

**Input:**
```text
nums = [1, 5, 4, 2, 9, 9, 9]
k = 3
```

**Output:**
```text
15
```

**Explanation:**

Valid subarrays of length `3`:

- `[1, 5, 4]` → Sum = 10
- `[5, 4, 2]` → Sum = 11
- `[4, 2, 9]` → Sum = 15

The remaining windows contain duplicate elements.

Maximum valid sum = `15`.

---

## Approach: Fixed-Size Sliding Window + HashMap

### Intuition

We need to find the maximum sum of a subarray of size `k` where all elements are distinct.

Instead of calculating every subarray separately, we use a **Fixed-Size Sliding Window**.

We maintain:

- `left`: Starting index of the window.
- `right`: Ending index of the window.
- `sum`: Sum of the current window.
- `HashMap`: Stores element frequencies to identify duplicates.

A window is valid when:

```java
right - left + 1 == k && map.size() == k
```

### Steps

1. Create a `HashMap` to store element frequencies.
2. Initialize `left = 0`, `sum = 0`, and `maxSum = 0`.
3. Traverse the array using the `right` pointer.
4. Add the current element to `sum`.
5. Update its frequency in the HashMap.
6. If the window size exceeds `k`:
   - Remove the outgoing element from `sum`.
   - Decrease its frequency in the HashMap.
   - Remove the element from the map if its frequency becomes zero.
   - Increment `left`.
7. Check whether the window size is exactly `k`.
8. If `map.size() == k`, all elements are distinct.
9. Update `maxSum`.
10. Return `maxSum`.

### Java Code

```java
import java.util.*;

class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        long sum = 0;
        long maxSum = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            sum += nums[right];

            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            // Maintain window size k
            if (right - left + 1 > k) {

                int removed = nums[left];

                sum -= removed;

                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0) {
                    map.remove(removed);
                }

                left++;
            }

            // Check window size and distinct elements
            if (right - left + 1 == k && map.size() == k) {

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
```

---

## Dry Run

**Input:**
```text
nums = [1, 5, 4, 2, 9, 9, 9]
k = 3
```

| Window | HashMap | Sum | Operation |
|---|---|---:|---|
| `[1, 5, 4]` | `{1, 5, 4}` | 10 | Valid, max = 10 |
| `[5, 4, 2]` | `{5, 4, 2}` | 11 | Valid, max = 11 |
| `[4, 2, 9]` | `{4, 2, 9}` | 15 | Valid, max = 15 |
| `[2, 9, 9]` | `{2, 9}` | 20 | Invalid, duplicate |
| `[9, 9, 9]` | `{9}` | 27 | Invalid, duplicates |

**Final Output:**
```text
15
```

---

## Complexity Analysis

- **Time Complexity:** O(n) – Each element is added and removed from the window at most once. HashMap operations take O(1) average time.
- **Space Complexity:** O(k) – The HashMap stores at most `k` elements.

## Key Concepts

- Array
- Fixed-Size Sliding Window
- HashMap
- Frequency Counting
- Distinct Elements
- Window Sum

## Interview Note

The most important part of this problem is maintaining the window size and checking for distinct elements.

Remember these two conditions:

**1. Fixed window size:**
```java
right - left + 1 == k
```

**2. All elements are distinct:**
```java
map.size() == k
```

**Why does `map.size() == k` work?**

Because the window contains exactly `k` elements. If the HashMap also contains `k` distinct keys, every element must be unique.

**Recommended Approach: Fixed-Size Sliding Window + HashMap.**