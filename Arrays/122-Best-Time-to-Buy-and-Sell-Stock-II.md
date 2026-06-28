# 122. Best Time to Buy and Sell Stock II

## Intuition

Since multiple transactions are allowed, we can earn profit whenever the stock price increases. Instead of waiting for the maximum selling price, add every positive price difference.

## Approach

1. Initialize `maxProfit = 0`.
2. Traverse the array from index `1`.
3. If `prices[i] > prices[i - 1]`, add the difference to `maxProfit`.
4. Continue until the end of the array.
5. Return `maxProfit`.

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

## Java Code

```java
// Solution is available in 122-Best-Time-to-Buy-and-Sell-Stock-II.java
```