# 1011. Capacity To Ship Packages Within D Days

**LeetCode:** [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)

**Difficulty:** Medium

## Intuition

We need to find the minimum ship capacity required to deliver all packages within the given number of days.

The packages must be shipped in the same order as they appear in the array.

Instead of checking every possible capacity one by one, we can use **Binary Search on Answer**.

- The minimum possible capacity is the maximum weight of a single package, because every package must fit on the ship.
- The maximum possible capacity is the sum of all package weights, which ships everything in one day.

We use binary search within this range to find the minimum valid capacity.

## Approach: Binary Search on Answer

We apply Binary Search on the possible ship capacity.

### Search Space

- `low = Maximum package weight`
- `high = Sum of all package weights`

### Helper Method: `canShip()`

The `canShip()` method checks whether all packages can be shipped within the given number of days using the provided capacity.

- Initialize `d = 1` because shipping starts from day 1.
- Initialize `curr = 0` to track the current day's total package weight.
- Traverse all packages in their original order.
- If `curr + w > cap`:
  - Start a new day.
  - Increment `d`.
  - Set `curr = w`.
- Otherwise, add the package weight to the current day's load.
- Finally, return `d <= days`.

### Binary Search

- Calculate the middle capacity: `cap = low + (high - low) / 2`.
- If `canShip()` returns `true`:
  - The capacity is valid.
  - Store it in `ans`.
  - Search for a smaller capacity using `high = cap - 1`.
- Otherwise:
  - The capacity is insufficient.
  - Increase the capacity using `low = cap + 1`.

Return `ans`.

## Algorithm

1. Initialize `low = 0` and `high = 0`.
2. Traverse the weights array:
   - Update `low` with the maximum package weight.
   - Add every package weight to `high`.
3. Initialize `ans = high` (the sum is always feasible, so `ans` is always a valid fallback).
4. Run Binary Search while `low <= high`.
5. Calculate the middle capacity.
6. Call `canShip(weights, days, cap)` to check whether the packages can be shipped within the given days.
7. If valid, store the capacity and search the left half.
8. If invalid, search the right half.
9. Return the minimum valid capacity.

## Java Code

```java
class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // low = heaviest single package, high = sum of all packages
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        int ans = high;

        while (low <= high) {
            int cap = low + (high - low) / 2;

            if (canShip(weights, days, cap)) {
                ans = cap;
                high = cap - 1;   // try a smaller capacity
            } else {
                low = cap + 1;    // need a bigger capacity
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int cap) {

        int d = 1;
        int curr = 0;

        for (int w : weights) {
            if (curr + w > cap) {
                d++;
                curr = w;
            } else {
                curr += w;
            }
        }

        return d <= days;
    }
}
```

## Dry Run

**Input:**

```text
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5
```

Initial values:

```text
low = 10
high = 55
```

| Iteration | Capacity (`cap`) | Required days | Decision |
|---|---:|---:|---|
| 1 | 32 | 2 | Valid → Search left |
| 2 | 20 | 4 | Valid → Search left |
| 3 | 14 | 6 | Invalid → Search right |
| 4 | 17 | 4 | Valid → Search left |
| 5 | 15 | 5 | Valid → Search left |

After the final iteration:

```text
low = 15
high = 14
```

The loop terminates.

**Output:**

```text
15
```

Therefore, the minimum ship capacity is `15`.

## Edge Cases

| Case | Answer |
|---|---|
| `days = 1` | `sum(weights)` |
| `days >= weights.length` | `max(weights)` |
| Single package | That package's weight |

## Complexity Analysis

Let `N` be the number of packages and `S` be the sum of all package weights.

- **Time Complexity:** `O(N × log S)`
  - Finding the search space takes `O(N)`.
  - Binary Search takes `O(log(S − max))` iterations, bounded by `O(log S)`.
  - Each call to `canShip()` takes `O(N)`.

- **Space Complexity:** `O(1)`
  - Only a few variables are used.
  - No additional data structure is required.

## Important Pattern

**Binary Search on Answer**

This pattern is useful when:

- We need to find a minimum or maximum feasible value.
- We can define a condition to check whether a candidate answer is valid.
- The condition is monotonic.

### Reusable Template

```java
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (isFeasible(mid)) { ans = mid; high = mid - 1; }
    else                 { low = mid + 1; }
}
```

### Similar LeetCode Problems

1. [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
2. [1482. Minimum Number of Days to Make m Bouquets](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)
3. [1283. Find the Smallest Divisor Given a Threshold](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)
4. [410. Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)

## Interview Tip

**Why do we use Binary Search?**

Because as the ship capacity increases, the number of required shipping days never increases. Once a capacity becomes valid, every larger capacity is also valid.

This monotonic property allows us to apply Binary Search to find the minimum valid capacity.