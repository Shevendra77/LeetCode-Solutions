# 121. Best Time to Buy and Sell Stock

## Intuition

Since only one transaction is allowed, we need to find the lowest buying price before the current day and calculate the maximum profit by selling on the current day.

## Approach

1. Initialize `minPrice` with the first day's price.
2. Initialize `maxProfit = 0`.
3. Traverse the array from index `1`.
4. If the current price is less than `minPrice`, update `minPrice`.
5. Otherwise, calculate the current profit as `prices[i] - minPrice`.
6. Update `maxProfit` if the current profit is greater.
7. Return `maxProfit`.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 121-Best-Time-to-Buy-and-Sell-Stock.java
```