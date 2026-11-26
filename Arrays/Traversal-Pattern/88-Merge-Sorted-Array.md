# 88. Merge Sorted Array

## Intuition

Both arrays are already sorted. Since `nums1` has enough extra space at the end, we can merge the arrays from the back.

We compare the largest remaining elements of both arrays and place the larger one at the end of `nums1`. This avoids overwriting the existing elements in `nums1`.

## Approach

1. Initialize three pointers:
   - `i = m - 1` (last valid element in `nums1`)
   - `j = n - 1` (last element in `nums2`)
   - `k = m + n - 1` (last position in `nums1`)
2. Compare `nums1[i]` and `nums2[j]`.
3. Place the larger element at `nums1[k]`.
4. Move the corresponding pointer (`i` or `j`) and decrement `k`.
5. Repeat until one array is exhausted.
6. If elements remain in `nums2`, copy them into `nums1`.
7. `nums1` now contains the merged sorted array.

## Complexity

- **Time Complexity:** O(m + n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 88-Merge-Sorted-Array.java
```