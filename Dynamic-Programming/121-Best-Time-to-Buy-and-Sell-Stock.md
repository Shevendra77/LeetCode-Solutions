# LeetCode 121 — Best Time to Buy and Sell Stock

## Intuition

Buy at the lowest price seen so far and sell later at a higher price to maximize profit.

## Approach

**Greedy + One Pass**

## Algorithm

1. Initialize `bestBuy` with the first day's price.
2. Initialize `maxProfit = 0`.
3. Traverse the array from index `1`.
4. Calculate profit using `prices[i] - bestBuy` and update `maxProfit`.
5. Update `bestBuy` if today's price is lower.
6. Return `maxProfit`.

## Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int bestBuy = prices[0];

        // Start from index 1 because buying and selling
        // cannot happen on the same day.
        for (int i = 1; i < n; i++) {

            // Calculate profit if we sell today.
            if (prices[i] > bestBuy) {
                maxProfit = Math.max(
                    maxProfit,
                    prices[i] - bestBuy
                );
            }

            // Update the minimum buying price.
            bestBuy = Math.min(bestBuy, prices[i]);
        }

        return maxProfit;
    }
}
```

## Dry Run

**Input:** `prices = [7, 1, 5, 3, 6, 4]`

| Day | Price | Best Buy | Max Profit |
|---:|---:|---:|---:|
| 0 | 7 | 7 | 0 |
| 1 | 1 | 1 | 0 |
| 2 | 5 | 1 | 4 |
| 3 | 3 | 1 | 4 |
| 4 | 6 | 1 | 5 |
| 5 | 4 | 1 | 5 |

**Output:** `5`

Buy at price `1` and sell at price `6`.

## Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

## Pattern

**Array + Greedy + Track Minimum So Far**