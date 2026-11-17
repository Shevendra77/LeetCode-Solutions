# 5. Difference Array ⭐⭐⭐

### 🧠 When to use

Use when there are:

- many range updates
- add X to [L,R]
- increment/decrement ranges

### Template

```java
diff[l] += value;
diff[r + 1] -= value;

for (int i = 1; i < n; i++) {
    diff[i] += diff[i - 1];
}
```

### 10 Problems

| # | Problem | LeetCode | GFG | Done |
|---|---|---|---|---|
| 1 | Range Addition | [LC 370](https://leetcode.com/problems/range-addition/) | GFG | ⬜ |
| 2 | Corporate Flight Bookings | [LC 1109](https://leetcode.com/problems/corporate-flight-bookings/) | GFG | ⬜ |
| 3 | Car Pooling | [LC 1094](https://leetcode.com/problems/car-pooling/) | GFG | ⬜ |
| 4 | Shifting Letters II | [LC 2381](https://leetcode.com/problems/shifting-letters-ii/) | GFG | ⬜ |
| 5 | Check if Grid Satisfies Conditions | [LC 3142](https://leetcode.com/problems/check-if-grid-satisfies-conditions/) | GFG | ⬜ |
| 6 | Range Increment Operations | — | GFG | ⬜ |
| 7 | Range Update Queries | — | GFG | ⬜ |
| 8 | Maximum Population Year | [LC 1854](https://leetcode.com/problems/maximum-population-year/) | GFG | ⬜ |
| 9 | Booking Concert Tickets | [LC 2286](https://leetcode.com/problems/booking-concert-tickets-in-groups/) | GFG | ⬜ |
| 10 | Meeting Rooms / Range Overlap | — | GFG | ⬜ |

Difference Array is a smaller pattern, so don't spend as much time here as Sliding Window, Binary Search, Trees, Graphs or DP.