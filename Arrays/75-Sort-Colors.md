# 75. Sort Colors

## Intuition

The array contains only three distinct values: `0`, `1`, and `2`.

Instead of sorting the array, we can divide it into three regions using the **Dutch National Flag Algorithm**:

- Left side → `0`s
- Middle → `1`s
- Right side → `2`s

Using three pointers, we can sort the array in a single traversal without using any extra space.

## Approach

1. Initialize three pointers:
   - `low = 0`
   - `mid = 0`
   - `high = nums.length - 1`
2. Traverse while `mid <= high`:
   - If `nums[mid] == 0`:
     - Swap `nums[low]` and `nums[mid]`.
     - Increment both `low` and `mid`.
   - If `nums[mid] == 1`:
     - Increment `mid`.
   - If `nums[mid] == 2`:
     - Swap `nums[mid]` and `nums[high]`.
     - Decrement `high`.
     - Do **not** increment `mid` because the swapped element must be checked.
3. Continue until `mid > high`.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 75-Sort-Colors.java
```