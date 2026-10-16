# 26. Remove Duplicates from Sorted Array

## Intuition

The array is sorted, so duplicate elements appear next to each other.

Using the **Two Pointers Algorithm**, we maintain a pointer `j` to track the position of the last unique element and a pointer `i` to traverse the array.

When `nums[i]` is different from `nums[j]`, we increment `j` and place the new unique element at `nums[j]`.

## Approach

1. Initialize `j = 0` to track the position of the last unique element.
2. Traverse the array using `i` from index `0` to `nums.length - 1`.
3. If `nums[j] != nums[i]`:
   - Increment `j` using `++j`.
   - Copy `nums[i]` to `nums[j]`.
4. Continue until the entire array has been traversed.
5. Return `j + 1` because the array index starts from `0`, while the number of unique elements starts counting from `1`.

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Java Code

```java
// Solution is available in 26-Remove-Duplicates-from-Sorted-Array.java
```