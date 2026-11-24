# Maximum Sum of Subarray of Size K

**Difficulty:** Easy

**Topic:** Array, Fixed-Size Sliding Window

## 🧠 Problem Understanding

Given an integer array `arr` and an integer `k`, find the maximum sum among all contiguous subarrays of size `k`.

## Example 1

**Input:**
```text
arr = [2, 1, 5, 1, 3, 2]
k = 3
```

**Output:**
```text
9
```

**Explanation:**

Subarrays of size `3`:

- `[2, 1, 5]` → Sum = 8
- `[1, 5, 1]` → Sum = 7
- `[5, 1, 3]` → Sum = 9
- `[1, 3, 2]` → Sum = 6

Maximum sum = `9`.

## Approach: Fixed-Size Sliding Window

### Intuition

We need to find the maximum sum of all contiguous subarrays of size `k`.

Instead of calculating the sum of every window from scratch, we use the **Sliding Window** technique.

We maintain:

- `windowSum`: Sum of the current window.
- `maxSum`: Maximum sum found so far.
- `i`: Calculates the first window.
- `j`: Slides the window forward.

When sliding the window:

1. Add the next element.
2. Remove the element that leaves the window.
3. Update the maximum sum.

### Steps

1. Initialize `windowSum = 0`.
2. Calculate the sum of the first `k` elements.
3. Initialize `maxSum = windowSum`.
4. Traverse the remaining array from index `k`.
5. Add the new element to `windowSum`.
6. Remove the outgoing element using `arr[j - k]`.
7. Update `maxSum`.
8. Return `maxSum`.

### Java Code

```java
class Solution {

    public int maxSubarraySum(int[] arr, int k) {

        int windowSum = 0;

        // Calculate sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int j = k; j < arr.length; j++) {

            // Add the next element
            windowSum += arr[j];

            // Remove the outgoing element
            windowSum -= arr[j - k];

            // Update maximum sum
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
```

---

## Dry Run

**Input:**
```text
arr = [2, 1, 5, 1, 3, 2]
k = 3
```

**First Window:**

```text
[2, 1, 5] = 8
maxSum = 8
```

**Sliding Window:**

| Window | Calculation | Window Sum | Max Sum |
|---|---|---:|---:|
| `[2, 1, 5]` | 2 + 1 + 5 | 8 | 8 |
| `[1, 5, 1]` | 8 + 1 - 2 | 7 | 8 |
| `[5, 1, 3]` | 7 + 3 - 1 | 9 | 9 |
| `[1, 3, 2]` | 9 + 2 - 5 | 6 | 9 |

**Final Output:**
```text
9
```

---

## Complexity Analysis

- **Time Complexity:** O(n) – Each array element is processed once.
- **Space Complexity:** O(1) – Only a few variables are used.

## Key Concepts

- Array
- Fixed-Size Sliding Window
- Contiguous Subarray
- Window Sum
- Maximum Sum

## Interview Note

The most important operation in this problem is:

```java
windowSum += arr[j];       // Add new element
windowSum -= arr[j - k];   // Remove outgoing element
```

Instead of recalculating the entire window sum, we update the previous sum.

**Recommended Approach: Fixed-Size Sliding Window.**