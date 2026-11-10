# 35. Search Insert Position

**Platform:** LeetCode  
**Approach:** Binary Search  
**Pattern:** Standard Binary Search

## 1. Intuition

We are given a sorted array of distinct integers and a target value.

We need to:
- Return the index if the target is found.
- Otherwise, return the index where the target should be inserted to maintain sorted order.

**Key observation:**

Binary Search helps us find the target efficiently.

If the target is not present, the `low` pointer automatically reaches the correct insertion position.

## 2. Java Code

```java
class Solution {
    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}
```

## 3. Algorithm

1. Initialize `low = 0` and `high = nums.length - 1`.
2. Run the loop while `low <= high`.
3. Calculate the middle index:
   `mid = low + (high - low) / 2`
4. Compare `nums[mid]` with `target`:
   - If equal, return `mid`.
   - If `nums[mid] > target`, search the left half using `high = mid - 1`.
   - If `nums[mid] < target`, search the right half using `low = mid + 1`.
5. If the target is not found, return `low`.

## 4. Dry Run

**Example 1:**

```java
nums = [1, 3, 5, 6]
target = 5
```

| Iteration | low | mid | high | nums[mid] | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 1 | 3 | 3 | low = mid + 1 |
| 2 | 2 | 2 | 3 | 5 | Target found |

**Output:** `2`

### Example 2: Target is not present

```java
nums = [1, 3, 5, 6]
target = 2
```

| Iteration | low | mid | high | nums[mid] | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 1 | 3 | 3 | high = mid - 1 |
| 2 | 0 | 0 | 0 | 1 | low = mid + 1 |

Now:

```text
low = 1
high = 0
```

The loop stops because `low > high`.

Return `low = 1`.

**Output:** `1`

The target `2` should be inserted at index `1`:

```text
[1, 2, 3, 5, 6]
```

## 5. Why return `low`?

This is the most important concept in this problem.

When Binary Search finishes without finding the target:

- Every element before `low` is smaller than the target.
- Every element from `low` onward is greater than the target.

Therefore, `low` represents the correct insertion position.

**Remember:**

- Target found → return `mid`.
- Target not found → return `low`.

## 6. Why `while (low <= high)`?

We use `<=` because we must check the final remaining element when `low == high`.

Once `low > high`, the search range is empty, so the loop stops.

## 7. Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time | O(log N) | Search space is divided in half each iteration. |
| Auxiliary Space | O(1) | Only a few variables are used. |

## 8. Important Interview Points

- Array is sorted in ascending order.
- LeetCode 35 specifies distinct elements.
- Uses Standard Binary Search.
- `low` gives the insertion index when the target is absent.
- Works for insertion at the beginning, middle, or end.

**Final Pattern:** Binary Search – Search for a Target / Find Insertion Position.