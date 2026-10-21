# Maximum Consecutive Bits

## Problem Statement

Given an array `arr[]` consisting of only `0`s and `1`s, return the maximum number of consecutive equal elements (either `0`s or `1`s).

## Example

**Input:**

```
arr = [0, 1, 0, 1, 1, 1, 1]
```

**Output:**

```
4
```

**Explanation:** The maximum consecutive `1`s are `1, 1, 1, 1`, so the answer is `4`.

## Approach Name

Linear Traversal (Single Pass) using Consecutive Counting

## Intuition

Traverse the array and compare each element with the previous element.

- If both elements are equal, increment `count`.
- If they are different, reset `count` to `1`.
- Maintain `maxCount` to store the maximum consecutive count found so far.

## Algorithm

1. Initialize `count = 1` and `maxCount = 1`.
2. Traverse the array from index `1` to `n - 1`.
3. If `arr[i] == arr[i - 1]`, increment `count`.
4. Otherwise, reset `count = 1`.
5. Update `maxCount = Math.max(count, maxCount)`.
6. Return `maxCount`.

## Java Code

```java
class Solution {
    public int maxConsecBits(int[] arr) {
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
```

## Complexity Analysis

- **Time Complexity:** `O(n)` — the array is traversed once.
- **Auxiliary Space:** `O(1)` — only two variables are used.

## Key Point

`count` tracks the current consecutive sequence, while `maxCount` stores the longest sequence found so far.