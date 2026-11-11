# 34. Find First and Last Position of Element in Sorted Array

## Intuition

The given array is sorted in non-decreasing order, and we need to find the first and last occurrence of the target element.
Instead of using linear search, we can use Binary Search twice to achieve `O(log N)` time complexity.

* First Binary Search: Find the first occurrence of the target.
* Second Binary Search: Find the last occurrence of the target.

When we find the target, we store its index and continue searching in the required direction.

## Approach: Binary Search (First and Last Occurrence)

We use two separate Binary Search methods:

1. `firstPosition()` searches towards the left side whenever the target is found.
2. `lastPosition()` searches towards the right side whenever the target is found.

This helps us find both boundary indexes efficiently.

## Algorithm

### Step 1: Find First Occurrence

1. Initialize `low = 0`, `high = nums.length - 1`, and `ans = -1`.
2. Calculate the middle index.
3. If `nums[mid] == target`:
   * Store `mid` in `ans`.
   * Move left using `high = mid - 1`.
4. If `nums[mid] > target`, search the left half.
5. Otherwise, search the right half.
6. Return `ans`.

### Step 2: Find Last Occurrence

1. Initialize `low = 0`, `high = nums.length - 1`, and `ans = -1`.
2. Calculate the middle index.
3. If `nums[mid] == target`:
   * Store `mid` in `ans`.
   * Move right using `low = mid + 1`.
4. If `nums[mid] < target`, search the right half.
5. Otherwise, search the left half.
6. Return `ans`.

### Step 3: Return Both Indexes

Return both indexes in an array: `{first, last}`.

## Example

**Input:**

```
nums = [5, 7, 7, 8, 8, 10]
target = 8
```

**Output:**

```
[3, 4]
```

**Explanation:**

* First occurrence of `8` is at index `3`.
* Last occurrence of `8` is at index `4`.

## Complexity Analysis

* **Time Complexity:** `O(log N)` – We perform two Binary Searches. Each takes `O(log N)` time.
* **Auxiliary Space:** `O(1)` – Only a constant number of variables are used.

## Pattern

Binary Search → First and Last Occurrence → Boundary Search

## Java Code

```java
class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int first = firstPosition(nums, target);
        int last = lastPosition(nums, target);

        return new int[]{first, last};
    }

    // Search first occurrence
    public int firstPosition(int nums[], int target)
    {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target)
            {
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Search last occurrence
    public int lastPosition(int nums[], int target)
    {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target)
            {
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return ans;
    }
}
```

## Key Points to Remember

* First occurrence: When target is found, move left.
* Last occurrence: When target is found, move right.
* Always store the found index in `ans`.
* If the target is absent, return `[-1, -1]`.