# Count Occurrences in a Sorted Array

## Problem Statement

Given a sorted array `nums[]` and an integer `target`, find the total number of times the target appears in the array.

**Example:**

```text
Input:
nums = [1, 1, 2, 2, 2, 2, 3]
target = 2

Output:
4
```

**Explanation:**

The target `2` appears 4 times in the array.

---

## Approach: Binary Search (First and Last Occurrence)

### Intuition

Instead of traversing the entire array and counting each occurrence, we can use **Binary Search** because the array is sorted.

We find:

1. First occurrence of the target.
2. Last occurrence of the target.

Then calculate the total count using:

```text
Count = Last Position - First Position + 1
```

### Algorithm

1. Find the first occurrence of the target using Binary Search.
2. Find the last occurrence of the target using Binary Search.
3. If the first occurrence is `-1`, return `0` because the target does not exist.
4. Otherwise, calculate:

   `count = last - first + 1`

5. Return the count.

---

## Example Dry Run

**Input:**

```text
nums = [1, 1, 2, 2, 2, 2, 3]
target = 2
```

**Array Indexing:**

| Index | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|---|
| Value | 1 | 1 | 2 | 2 | 2 | 2 | 3 |

**Step 1: Find First Occurrence**

```text
First occurrence = 2
```

**Step 2: Find Last Occurrence**

```text
Last occurrence = 5
```

**Step 3: Calculate Count**

```text
Count = last - first + 1

      = 5 - 2 + 1

      = 4
```

**Output:**

```text
4
```

---

## Java Code

```java
class Solution 
{
    int countFreq(int[] nums, int target) 
    {
        int first = firstPosition(nums, target);
        int last = lastPosition(nums, target);
        
        if(first == -1)
        {
            return 0;
        }
        return last - first + 1;
    }
    
    // Search first occurrence
    public int firstPosition(int nums[] , int target)
    {
        int low = 0 , high = nums.length - 1;
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
    public int lastPosition(int nums[] , int target)
    {
        int low = 0 , high = nums.length - 1;
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

---

## Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time Complexity | O(log N) | Two Binary Searches, each takes O(log N). |
| Auxiliary Space | O(1) | Only a few variables are used. |

---

## Pattern Used

**Binary Search – First and Last Occurrence (Boundary Search)**

This pattern is useful for:

- Finding the first occurrence of an element.
- Finding the last occurrence of an element.
- Counting occurrences in a sorted array.
- Finding the lower and upper boundaries of a target.

## Important Interview Point

Why do we use `last - first + 1`?

Because array indexing starts from `0`, so we add `1` to get the actual number of positions.

For example, indices `2, 3, 4, 5` represent **4 elements**, not 3.