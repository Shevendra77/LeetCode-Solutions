# Sort 0s, 1s and 2s

## Intuition

The array contains only `0`, `1`, and `2`. We can sort it in one traversal using three pointers: `low`, `mid`, and `high`.

- `low` marks the position where the next `0` should go.
- `mid` checks the current element.
- `high` marks the position where the next `2` should go.

## Approach

1. Initialize `low = 0`, `mid = 0`, and `high = arr.length - 1`.
2. Traverse while `mid <= high`.
3. If `arr[mid] == 0`, swap `arr[low]` and `arr[mid]`, then increment `low` and `mid`.
4. If `arr[mid] == 1`, increment `mid`.
5. If `arr[mid] == 2`, swap `arr[mid]` and `arr[high]`, then decrement `high`.
6. Do not increment `mid` after swapping a `2`, because the swapped element still needs to be checked.

## Complexity

- **Time Complexity:** `O(n)` — each element is processed in constant time.
- **Auxiliary Space:** `O(1)` — only a few variables are used.

## Java Code

```java
class Solution {
    public void sort012(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }
}
```