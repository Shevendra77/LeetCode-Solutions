# 704. Binary Search

## Intuition

The array is already sorted in ascending order. Instead of checking every element one by one, we check the middle element.

If the middle element equals the target, we return its index. If the target is greater, we search the right half; otherwise, we search the left half.

## Approach

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Run a loop while `left <= right`.
3. Calculate the middle index using `mid = left + (right - left) / 2`.
4. If `nums[mid] == target`, return `mid`.
5. If `nums[mid] < target`, update `left = mid + 1`.
6. Otherwise, update `right = mid - 1`.
7. If the target is not found, return `-1`.

## Complexity

- **Time Complexity:** O(log n)
- **Space Complexity:** O(1)

## Java Code

```java
class Solution {
    public int search(int[] nums, int target) {

        int st = 0;
        int end = nums.length - 1;

        while(st <= end)
        {
            // use this because interger value is verfow in worst case add int_max vakue to int_max 
            int mid = st + (end - st) / 2;

            if(nums[mid] == target)
            {
                return mid;
            }
            if(target > nums[mid])
            {
                st = mid + 1;
            }
            else
            {
                end = mid  - 1;
            }
        }
        return -1;
    }
}
```