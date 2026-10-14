# 33. Search in Rotated Sorted Array

## Approach: Modified Binary Search

The array is sorted in ascending order but may be rotated. At least one half of the array is always sorted.

We use Binary Search to identify the sorted half and check whether the target lies within that half. If it does, search that half; otherwise, search the other half.

## Algorithm

1. Initialize `low = 0` and `high = nums.length - 1`.
2. Run a loop while `low <= high`.
3. Calculate the middle index: `mid = low + (high - low) / 2`.
4. If `nums[mid] == target`, return `mid`.
5. If the left half is sorted (`nums[low] <= nums[mid]`):
   - If the target lies between `nums[low]` and `nums[mid]`, update `high = mid - 1`.
   - Otherwise, update `low = mid + 1`.
6. Otherwise, the right half is sorted:
   - If the target lies between `nums[mid]` and `nums[high]`, update `low = mid + 1`.
   - Otherwise, update `high = mid - 1`.
7. If the target is not found, return `-1`.

## Java Code

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
```

## Example

**Input:**
```text
nums = [4,5,6,7,0,1,2]
target = 0
```

**Output:**
```text
4
```

**Explanation:**

The target `0` is present at index `4`.

## Complexity Analysis

- **Time Complexity:** `O(log n)` — the search space is reduced by half in each iteration.
- **Space Complexity:** `O(1)` — only a constant number of variables are used.