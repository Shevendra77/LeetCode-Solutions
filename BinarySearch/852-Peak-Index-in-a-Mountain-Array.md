# 852. Peak Index in a Mountain Array

**LeetCode:** [852. Peak Index in a Mountain Array](https://leetcode.com/problems/peak-index-in-a-mountain-array/)
**Topic:** Binary Search
**Difficulty:** Medium

---

## Intuition

A mountain array first increases and then decreases. Our goal is to find the index of the peak element (the largest element).

Instead of checking every element using linear search, we can use **Binary Search**. We compare the middle element with its neighbours:

- If `arr[mid - 1] < arr[mid]` and `arr[mid] > arr[mid + 1]`, we found the peak.
- If `arr[mid - 1] < arr[mid]`, we are on the increasing side. So, search in the right half.
- Otherwise, we are on the decreasing side. So, search in the left half.

---

## Approach

Initialize `st = 1` and `end = arr.length - 2`.

- Repeat while `st <= end`:
  - Calculate `mid = st + (end - st) / 2`.
  - If `arr[mid] > arr[mid - 1]` and `arr[mid] > arr[mid + 1]`, return `mid` because the peak is found.
  - If `arr[mid] > arr[mid - 1]`, the middle is on the increasing side. Update `st = mid + 1`.
  - Otherwise, the middle is on the decreasing side. Update `end = mid - 1`.
- If no peak is found, return `-1`.

---

## Java Code

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int st = 1;
        int end = arr.length - 2;

        while (st <= end) {

            int mid = st + (end - st) / 2;

            // Check whether mid is the peak element
            if (arr[mid - 1] < arr[mid] &&
                arr[mid] > arr[mid + 1]) {

                return mid;
            }

            // Mid lies on the increasing side
            if (arr[mid - 1] < arr[mid]) {
                st = mid + 1;
            }

            // Mid lies on the decreasing side
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
```

---

## Complexity Analysis

**Time Complexity:** `O(log n)`

- We eliminate approximately half of the search space in every iteration.
- Therefore, binary search takes logarithmic time.

**Space Complexity:** `O(1)`

- We use only a few variables (`st`, `end`, and `mid`).
- No extra data structures are used.

---

## Example

**Input:**

```
arr = [0, 2, 5, 3, 1]
```

**Output:**

```
2
```

**Explanation:**

- `arr[2] = 5`
- `5 > 2` (left neighbour)
- `5 > 3` (right neighbour)

Therefore, index `2` is the peak index.

---

## Important Interview Points

- Mountain arrays are first increasing and then decreasing.
- The peak element is greater than both its neighbours.
- Binary Search reduces the search space by half.
- We start from index `1` and end at `arr.length - 2` to safely access neighbouring elements.
- We use `st + (end - st) / 2` to avoid integer overflow.