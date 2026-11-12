# Floor in Sorted Array

## 1. Intuition

We are given a sorted array (which may contain duplicates) and a target `x`.

We need to find the **0-based index of the greatest element less than or equal to `x`**.

If no such element exists, return `-1`.

Example:

```text
arr = [1, 2, 8, 10, 11, 12, 19]
x = 9

Output = 2
```

Explanation: `8` is the greatest element less than or equal to `9`, and its index is `2`.

## 2. Approach: Binary Search (Upper Bound - 1)

Since the array is sorted, we use Binary Search to find the last element less than or equal to `x`.

We maintain three variables:

- `low = 0`: Starting index.
- `high = arr.length - 1`: Ending index.
- `ans = -1`: Stores the index of the possible floor.

## 3. Algorithm

1. Initialize `low = 0`, `high = arr.length - 1`, and `ans = -1`.
2. Run a loop while `low <= high`.
3. Calculate the middle index:
   `mid = low + (high - low) / 2`
4. If `arr[mid] > x`:
   - Search in the left half.
   - Update `high = mid - 1`.
5. Otherwise, if `arr[mid] <= x`:
   - Store the current index: `ans = mid`.
   - Search in the right half for a larger valid element.
   - Update `low = mid + 1`.
6. Return `ans`.

## 4. Dry Run

Input:

```text
arr = [1, 2, 8, 10, 11, 12, 19]
x = 9
```

| Step | low | high | mid | arr[mid] | Action |
|---|---:|---:|---:|---:|---|
| 1 | 0 | 6 | 3 | 10 | Search left |
| 2 | 0 | 2 | 1 | 2 | ans = 1, search right |
| 3 | 2 | 2 | 2 | 8 | ans = 2, search right |
| 4 | 3 | 2 | - | - | Stop |

Final Answer: `2`

## 5. Java Code

```java
class Solution {
    static int findFloor(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                high = mid - 1;
            }
            else if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }
}
```

## 6. Complexity Analysis

- **Time Complexity:** `O(log N)` — Binary Search eliminates half of the search space in every iteration.
- **Auxiliary Space:** `O(1)` — Only a constant number of variables are used.

## 7. Pattern

**Binary Search → Upper Bound - 1 → Last Element Less Than or Equal to Target**

## 8. Important Interview Point

Why do we update `low = mid + 1` when `arr[mid] <= x`?

Because the current element is a possible answer, but there may be a larger valid element on its right.

So, we store the current index and continue searching right to find the greatest valid element.