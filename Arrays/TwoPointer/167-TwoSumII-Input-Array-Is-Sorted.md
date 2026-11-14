# 167. Two Sum II - Input Array Is Sorted

**Difficulty:** Medium
**Topics:** Array, Two Pointers
**Approach:** Two Pointers

## Intuition

The array is sorted in non-decreasing order, so we can search for the pair from both ends at once.

Start with `left = 0` (smallest element) and `right = numbers.length - 1` (largest element), then look at their sum:

- **sum == target:** found the pair. Return the 1-based indices.
- **sum > target:** the sum is too large, so move `right` one step left to get a smaller sum.
- **sum < target:** the sum is too small, so move `left` one step right to get a larger sum.

### Why moving a pointer is safe

If `numbers[left] + numbers[right] > target`, then `numbers[right]` cannot pair with `numbers[left]`, nor with any element after it, because those are all at least as large as `numbers[left]`. So `numbers[right]` can never be part of the answer and is safely discarded. The same reasoning applies to `numbers[left]` when the sum is too small.

## Algorithm

1. Set `left = 0` and `right = numbers.length - 1`.
2. While `left < right`:
   1. Compute `sum = numbers[left] + numbers[right]`.
   2. If `sum == target`, return `{left + 1, right + 1}`.
   3. If `sum > target`, do `right--`.
   4. Otherwise, do `left++`.
3. Return an empty array. This is never reached, since the problem guarantees exactly one solution.

## Complexity Analysis

- **Time: O(n).** The pointers move toward each other and each iteration moves one of them, so there are at most `n - 1` iterations.
- **Space: O(1).** Only `left`, `right` and `sum` are used.

## Java Code

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {}; // unreachable: a solution is guaranteed
    }
}
```

## Example

**Input:**

```
numbers = [2, 7, 11, 15]
target = 9
```

**Output:**

```
[1, 2]
```

**Trace:**

| left | right | sum | Action |
|------|-------|-----|--------|
| 0 | 3 | 2 + 15 = 17 | Too large, `right--` |
| 0 | 2 | 2 + 11 = 13 | Too large, `right--` |
| 0 | 1 | 2 + 7 = 9 | Match, return `[1, 2]` |

The answer uses 1-based indexing, so indices `0` and `1` become `[1, 2]`.

## Key Point

Sorting is what makes this work: it tells us which pointer to move after every comparison, so we never need extra memory or a nested loop.