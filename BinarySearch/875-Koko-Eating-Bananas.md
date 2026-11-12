# 875. Koko Eating Bananas

## 1. Intuition

We are given an array `piles[]`, where each element represents the number of bananas in a pile.

Koko can eat `k` bananas per hour from one pile. If a pile has fewer than `k` bananas, she eats the entire pile in that hour.

We need to find the **minimum eating speed `k`** such that Koko finishes all piles within `h` hours.

### Example

```text
Input:
piles = [3, 6, 7, 11]
h = 8

Output:
4
```

At speed `k = 4`:

| Pile | Bananas | Hours Required |
|---|---:|---:|
| 1 | 3 | 1 |
| 2 | 6 | 2 |
| 3 | 7 | 2 |
| 4 | 11 | 3 |
| **Total** | | **8 hours** |

Therefore, the minimum eating speed is `4`.

## 2. Approach: Binary Search on Answer

We are not searching for an element in an array. Instead, we are searching for the minimum valid eating speed.

### Search Space

- Minimum speed (`low`) = `1`
- Maximum speed (`high`) = Maximum pile size

For example:

```text
piles = [3, 6, 7, 11]

low = 1
high = 11
```

### Monotonic Property

- If eating speed is small, Koko takes more hours.
- If eating speed is large, Koko takes fewer hours.
- If a particular speed is valid, every higher speed is also valid.

Therefore, we use Binary Search to find the first valid speed.

## 3. Algorithm

1. Initialize `low = 1`.
2. Find the maximum pile size and store it in `high`.
3. Initialize `ans = high`.
4. Run Binary Search while `low <= high`.
5. Calculate the middle speed:

   `mid = low + (high - low) / 2`

6. Calculate the total hours required for all piles.
7. For each pile, calculate the required hours:

   `hours = (pile - 1) / mid + 1`

8. If total hours `<= h`:
   - Current speed is valid.
   - Store `ans = mid`.
   - Search for a smaller speed: `high = mid - 1`.
9. Otherwise:
   - Current speed is too slow.
   - Search for a higher speed: `low = mid + 1`.
10. Return `ans`.

## 4. Dry Run

Input:

```text
piles = [3, 6, 7, 11]
h = 8

low = 1
high = 11
```

| Step | low | high | mid | Total Hours | Action |
|---|---:|---:|---:|---:|---|
| 1 | 1 | 11 | 6 | 6 | Valid → Search Left |
| 2 | 1 | 5 | 3 | 10 | Invalid → Search Right |
| 3 | 4 | 5 | 4 | 8 | Valid → Search Left |
| 4 | 4 | 3 | - | - | Stop |

Final Answer: `4`

## 5. How to Calculate Hours?

We use:

```java
hours = (pile - 1) / k + 1;
```

This is an integer-based way to calculate the ceiling division:

\[
\text{Hours} = \left\lceil \frac{\text{pile}}{k} \right\rceil
\]

Example:

```text
pile = 7
k = 4

hours = (7 - 1) / 4 + 1
      = 6 / 4 + 1
      = 1 + 1
      = 2
```

We can also use:

```java
hours = (pile + k - 1) / k;
```

But the first formula avoids potential integer overflow in the addition.

## 6. Java Code

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            // Calculate total hours
            for (int pile : piles) {
                hours += (pile - 1) / mid + 1;
            }

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
```

## 7. Complexity Analysis

Let:

- `N` = Number of piles.
- `M` = Maximum number of bananas in a pile.

**Time Complexity:**

- Finding the maximum pile: `O(N)`
- Binary Search: `O(log M)`
- Calculating total hours per iteration: `O(N)`

Overall:

\[
O(N) + O(N \times \log M)
\]

\[
\boxed{O(N \times \log M)}
\]

**Auxiliary Space:** `O(1)` — Only constant extra variables are used.

## 8. Pattern

**Binary Search → Binary Search on Answer → Minimum Valid Value → First True**

## 9. Important Interview Points

**Q1. Why do we use Binary Search?**

Because the search space is monotonic. Increasing the eating speed never increases the total hours required.

**Q2. Why is `low = 1`?**

Because Koko must eat at least one banana per hour.

**Q3. Why is `high = max(piles)`?**

Because eating at the speed of the largest pile allows Koko to finish every pile in one hour per pile. Under the problem constraints, `h >= piles.length`, so this is always a valid upper bound.

**Q4. Why do we use `high = mid - 1` when `hours <= h`?**

Because the current speed is valid, but we want the minimum valid speed. So we search for a smaller speed.

**Q5. Why do we use `long hours`?**

To avoid integer overflow while adding the hours required for all piles.

## 10. Similar Problems

1. LeetCode 69 – Sqrt(x)
2. LeetCode 1011 – Capacity To Ship Packages Within D Days
3. LeetCode 1482 – Minimum Number of Days to Make m Bouquets
4. LeetCode 1283 – Find the Smallest Divisor Given a Threshold
5. LeetCode 410 – Split Array Largest Sum