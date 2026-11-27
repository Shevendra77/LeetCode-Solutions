# 4. Prefix Sum ⭐⭐⭐⭐⭐

### 🧠 When to use

Look for:

- range sum
- subarray sum
- sum between L and R
- many range queries
- subarray with target sum

### Basic template

```cpp
vector<int> pref(n + 1, 0);

for (int i = 0; i < n; i++) {
    pref[i + 1] = pref[i] + nums[i];
}

// sum [l ... r]
int sum = pref[r + 1] - pref[l];
```

### 10 Problems

| # | Problem | LeetCode | GFG | Done |
|---|---|---|---|---|
| 1 | Running Sum of 1d Array | [LC 1480](https://leetcode.com/problems/running-sum-of-1d-array/) | GFG | ⬜ |
| 2 | Range Sum Query | [LC 303](https://leetcode.com/problems/range-sum-query-immutable/) | GFG | ⬜ |
| 3 | Find Pivot Index | [LC 724](https://leetcode.com/problems/find-pivot-index/) | GFG | ⬜ |
| 4 | Left and Right Sum Differences | [LC 2574](https://leetcode.com/problems/left-and-right-sum-differences/) | GFG | ⬜ |
| 5 | Product of Array Except Self | [LC 238](https://leetcode.com/problems/product-of-array-except-self/) | GFG | ⬜ |
| 6 | Subarray Sum Equals K | [LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | [GFG](https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1) | ✅ |
| 7 | Continuous Subarray Sum | [LC 523](https://leetcode.com/problems/continuous-subarray-sum/) | GFG | ⬜ |
| 8 | Subarray Sums Divisible by K | [LC 974](https://leetcode.com/problems/subarray-sums-divisible-by-k/) | GFG | ⬜ |
| 9 | Contiguous Array | [LC 525](https://leetcode.com/problems/contiguous-array/) | GFG | ⬜ |
| 10 | Corporate Flight Bookings | [LC 1109](https://leetcode.com/problems/corporate-flight-bookings/) | GFG | ⬜ |

### 🔥 Important distinction

```
Range query
    ↓
Prefix Sum

"Number of subarrays with sum K"
    ↓
Prefix Sum + HashMap
```