# Rotate Array by D Positions (Left / Counter-Clockwise)

## Intuition

We need to rotate the array `d` positions to the left. The first `d` elements move to the end, and all remaining elements shift `d` positions to the left.

Split the array into two blocks:

```
arr = [ A | B ]
A = first d elements
B = remaining n - d elements
```

We want `A B` to become `B A`. Reversing a sequence reverses the order of the blocks and also reverses each block inside it:

```
(A B)' = B' A'
```

So if we reverse each block first and then reverse the whole array, we get:

```
(A' B')' = B A
```

**Example:**

```
Input:  arr = [1, 2, 3, 4, 5], d = 2
Output: arr = [3, 4, 5, 1, 2]
```

## Approach

1. Reverse the first `d` elements.
2. Reverse the remaining `n - d` elements.
3. Reverse the whole array.

## Algorithm

1. Find the array length `n`.
2. If the array has zero or one element, return.
3. Set `d = d % n` to handle `d >= n`.
4. If `d == 0`, return.
5. Reverse the range `0` to `d - 1`.
6. Reverse the range `d` to `n - 1`.
7. Reverse the range `0` to `n - 1`.

## Java Code

```java
class Solution {
    public void rotateArr(int[] arr, int d) {
        int n = arr.length;

        if (n <= 1) {
            return;
        }

        d = d % n;

        if (d == 0) {
            return;
        }

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
```

## Dry Run

**Input:** `arr = [1, 2, 3, 4, 5]`, `d = 2`

- `d = 2 % 5 = 2`
- Reverse first 2 elements (indices 0 to 1) → `[2, 1, 3, 4, 5]`
- Reverse remaining elements (indices 2 to 4) → `[2, 1, 5, 4, 3]`
- Reverse the whole array → `[3, 4, 5, 1, 2]`

**Output:** `[3, 4, 5, 1, 2]`

## Complexity Analysis

- **Time Complexity:** `O(n)` — each element is swapped a constant number of times.
- **Auxiliary Space:** `O(1)` — we use only one temporary variable.

## Key Point

Check `n <= 1` before computing `d % n`; otherwise, an empty array causes a division by zero.

For a **right (clockwise)** rotation, use the same three reversals in a different order: reverse the whole array, then the first `d` elements, then the remaining elements.