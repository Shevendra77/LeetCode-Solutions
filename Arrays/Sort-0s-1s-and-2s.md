# Sort 0s, 1s and 2s — Counting Approach

## Intuition

The array contains only `0`, `1`, and `2`. First, we count how many times each number appears. Then, we overwrite the array with all the `0`s, followed by all the `1`s, and finally all the `2`s.

## Approach

1. Initialize three variables: `c0 = 0`, `c1 = 0`, and `c2 = 0`.
2. Traverse the array using an enhanced `for` loop.
3. If `val == 0`, increment `c0`.
4. If `val == 1`, increment `c1`.
5. Otherwise, increment `c2`.
6. Initialize `index = 0`.
7. Fill the array with `0` exactly `c0` times.
8. Fill the array with `1` exactly `c1` times.
9. Fill the array with `2` exactly `c2` times.
10. The array is now sorted.

## Complexity

- **Time Complexity:** O(n), because we traverse the array to count the elements and then rewrite it.
- **Space Complexity:** O(1), because we use only a constant number of variables.

## Java Code

```java
class Solution {
    public void sort012(int[] arr) {

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int val : arr) {
            if (val == 0) {
                c0++;
            }
            else if (val == 1) {
                c1++;
            }
            else {
                c2++;
            }
        }

        int index = 0;

        for (int i = 0; i < c0; i++) {
            arr[index++] = 0;
        }

        for (int i = 0; i < c1; i++) {
            arr[index++] = 1;
        }

        for (int i = 0; i < c2; i++) {
            arr[index++] = 2;
        }
    }
}
```

## Example

**Input:** `arr = [0, 2, 1, 2, 0, 1, 0]`

**Counts:**
- `c0 = 3`
- `c1 = 2`
- `c2 = 2`

**Output:** `[0, 0, 0, 1, 1, 2, 2]`