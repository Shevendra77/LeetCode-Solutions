# Rotate Array by `d` Positions (Reversal Algorithm)

## Idea: Treat the Array as Two Blocks

Left-rotating by `d` means the first `d` elements move to the back. Split the array into two blocks:

```
arr = [ A | B ]
        A = first d elements
        B = remaining n - d elements
```

We want to turn `A B` into `B A`.

## Key Fact

Reversing a combined sequence reverses the order of the blocks **and** reverses each block inside (`'` means "reversed"):

```
(A B)' = B' A'
```

So if we reverse each block on its own and then reverse the whole thing:

```
(A' B')' = (B')' (A')' = B A
```

## Left Rotation by `d`

Steps:

1. `reverse(arr, 0, d - 1)` turns A into A'
2. `reverse(arr, d, n - 1)` turns B into B'
3. `reverse(arr, 0, n - 1)` reverses everything, giving `B A`

### Java Code

```java
class Solution {
    public void rotateArr(int arr[], int d) {
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

    private void reverse(int arr[], int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
```

### Dry Run: `[1, 2, 3, 4, 5]`, `d = 2`

A = `[1, 2]`, B = `[3, 4, 5]`

| Step  | Operation                | Array             |
|-------|--------------------------|-------------------|
| start |                          | `[1, 2, 3, 4, 5]` |
| 1     | reverse A (indices 0..1) | `[2, 1, 3, 4, 5]` |
| 2     | reverse B (indices 2..4) | `[2, 1, 5, 4, 3]` |
| 3     | reverse whole array      | `[3, 4, 5, 1, 2]` |

Output: `[3, 4, 5, 1, 2]`

## Right (Clockwise) Rotation by `d`

Change the order of the same three reversals:

1. `reverse(arr, 0, n - 1)` reverse the whole array
2. `reverse(arr, 0, d - 1)` reverse the first `d`
3. `reverse(arr, d, n - 1)` reverse the rest

```java
reverse(arr, 0, n - 1);
reverse(arr, 0, d - 1);
reverse(arr, d, n - 1);
```

### Why It Works

```
(A B)' = B' A'
```

After reversing the whole array, the first block of length `d` holds the **last `d` elements** in reversed order. Reversing it and the remaining part separately puts both back in their original internal order, with the last `d` elements in front.

### Dry Run: `[1, 2, 3, 4, 5]`, `d = 2`

| Step  | Operation           | Array             |
|-------|---------------------|-------------------|
| start |                     | `[1, 2, 3, 4, 5]` |
| 1     | reverse whole array | `[5, 4, 3, 2, 1]` |
| 2     | reverse first 2     | `[4, 5, 3, 2, 1]` |
| 3     | reverse the rest    | `[4, 5, 1, 2, 3]` |

Output: `[4, 5, 1, 2, 3]`

## Summary

- **Left rotate by d:** reverse first `d`, reverse the rest, reverse all.
- **Right rotate by d:** reverse all, reverse first `d`, reverse the rest.

## Complexity

- **Time:** `O(n)`, each element is swapped a constant number of times.
- **Auxiliary Space:** `O(1)`, only a temporary variable is used.

## Important Points

- Do the `n <= 1` check **before** `d % n`, otherwise an empty array causes a division by zero.
- Use `d = d % n` to handle `d >= n`.
- For `d = 1` or `d = 2`, storing the elements in variables and shifting also works, but it does not scale to a general `d`. Use reversal instead.