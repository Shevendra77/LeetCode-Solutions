# Move All Zeroes to End

## Intuition

Move all zeros to the end of the array while maintaining the relative order of non-zero elements.

We use two pointers:
- `i` traverses the array.
- `j` tracks the position where the next non-zero element should be placed.

Whenever `arr[i] != 0`, swap `arr[i]` with `arr[j]` using a temporary variable `temp`, then increment `j`.

## Example

**Input:**
```text
arr = [1, 2, 0, 4, 3, 0, 5, 0]
```

**Output:**
```text
[1, 2, 4, 3, 5, 0, 0, 0]
```

## Approach

1. Initialize `j = 0`.
2. Traverse the array using `i` from `0` to `n - 1`.
3. If `arr[i]` is non-zero:
   - Store `arr[i]` in `temp`.
   - Assign `arr[j] = arr[i]`.
   - Assign `arr[i] = temp`.
   - Increment `j`.
4. Return the modified array.

## Java Code

```java
class Solution {
    void pushZerosToEnd(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }
}
```

## Dry Run

Input: `[1, 2, 0, 4, 3, 0, 5, 0]`

| `i` | `arr[i]` | Action | Array |
|---:|---:|---|---|
| 0 | 1 | Swap indices 0 and 0 | `[1, 2, 0, 4, 3, 0, 5, 0]` |
| 1 | 2 | Swap indices 1 and 1 | `[1, 2, 0, 4, 3, 0, 5, 0]` |
| 3 | 4 | Swap indices 3 and 2 | `[1, 2, 4, 0, 3, 0, 5, 0]` |
| 4 | 3 | Swap indices 4 and 3 | `[1, 2, 4, 3, 0, 0, 5, 0]` |
| 6 | 5 | Swap indices 6 and 4 | `[1, 2, 4, 3, 5, 0, 0, 0]` |

**Final Output:** `[1, 2, 4, 3, 5, 0, 0, 0]`

## Complexity Analysis

- **Time Complexity:** `O(n)` — one traversal of the array.
- **Auxiliary Space:** `O(1)` — only a temporary variable and a pointer are used.

## Key Point

The `temp` variable helps swap elements without losing their values. Since non-zero elements are processed from left to right, their relative order remains unchanged.