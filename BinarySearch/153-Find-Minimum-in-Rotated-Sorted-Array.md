# 153. Find Minimum in Rotated Sorted Array

**Platform:** LeetCode  
**Approach:** Modified Binary Search  
**Pattern:** Binary Search on Rotated Sorted Array

## 1. Intuition

We are given a sorted array that has been rotated.

Our task is to find the minimum element.

Instead of checking every element using linear search, we use Binary Search to reduce the search range.

**Key observation:**

- If `nums[mid] < nums[right]`, the range from `mid` to `right` is sorted. The minimum can be at `mid` or somewhere to its left.
- Otherwise, the minimum must be to the right of `mid`.

We continue narrowing the range until `left` and `right` point to the same index.

## 2. Java Code

```java
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
```

## 3. Algorithm

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Run the loop while `left < right`.
3. Calculate the middle index:
   `mid = left + (right - left) / 2`
4. Compare `nums[mid]` with `nums[right]`.
5. If `nums[mid] < nums[right]`:
   - The minimum is at `mid` or to its left.
   - Update `right = mid`.
6. Otherwise:
   - The minimum is strictly to the right of `mid`.
   - Update `left = mid + 1`.
7. When both pointers meet, return `nums[left]`.

## 4. Dry Run

**Input:**

```java
nums = [3, 4, 5, 1, 2]
```

| Iteration | left | mid | right | nums[mid] | nums[right] | Update |
|---|---:|---:|---:|---:|---:|---|
| 1 | 0 | 2 | 4 | 5 | 2 | left = mid + 1 = 3 |
| 2 | 3 | 3 | 4 | 1 | 2 | right = mid = 3 |

Now:

```text
left = 3
right = 3

nums[3] = 1
```

**Output: `1`**

## 5. Why `while (left < right)`?

We are not searching for a target element.

We are narrowing the search range until both pointers meet at the minimum element.

When `left == right`, only one possible answer remains.

Therefore, we use:

```java
while (left < right)
```

## 6. Why `right = mid` instead of `mid - 1`?

When `nums[mid] < nums[right]`, the minimum could be `nums[mid]` itself.

Therefore, we must keep `mid` in the search range:

```java
right = mid;
```

If we used `right = mid - 1`, we might accidentally discard the answer.

## 7. Why compare with `nums[right]`?

The comparison helps identify which portion contains the minimum.

- `nums[mid] < nums[right]`: Minimum is at `mid` or to its left.
- `nums[mid] >= nums[right]`: Minimum is strictly to the right of `mid`.

This also handles an array that is not rotated, such as `[1, 2, 3, 4, 5]`.

## 8. Complexity Analysis

| Complexity | Value | Explanation |
|---|---|---|
| Time | O(log N) | Search range is divided in half each iteration. |
| Auxiliary Space | O(1) | Only a few variables are used. |

## 9. Important Interview Points

- This problem uses Modified Binary Search.
- All elements are unique in LeetCode 153.
- `<` is sufficient; `<=` is also valid because duplicates are not allowed.
- `left < right` is used because we stop when both pointers meet.
- `right = mid` keeps the middle element because it can be the minimum.
- `left = mid + 1` excludes the middle because it cannot be the minimum in that case.

**Final Pattern:** Modified Binary Search – Find Minimum in Rotated Sorted Array.