# 6. Kadane's Algorithm ⭐⭐⭐⭐

### 🧠 When to use

Strong clue:

- maximum subarray sum
- minimum subarray sum
- maximum contiguous sum

### Template

```cpp
long long curr = nums[0];
long long ans = nums[0];

for (int i = 1; i < n; i++) {

    curr = max((long long)nums[i],
               curr + nums[i]);

    ans = max(ans, curr);
}
```

### 10 Problems

| # | Problem | LeetCode | GFG | Done |
|---|---|---|---|---|
| 1 | Maximum Subarray | [LC 53](https://leetcode.com/problems/maximum-subarray/) | [GFG](https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1) | ⬜ |
| 2 | Maximum Subarray Sum | — | [GFG](https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1) | ⬜ |
| 3 | Maximum Product Subarray | [LC 152](https://leetcode.com/problems/maximum-product-subarray/) | GFG | ⬜ |
| 4 | Best Time to Buy and Sell Stock | [LC 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | GFG | ⬜ |
| 5 | Maximum Sum Circular Subarray | [LC 918](https://leetcode.com/problems/maximum-sum-circular-subarray/) | GFG | ⬜ |
| 6 | Maximum Absolute Sum of Any Subarray | [LC 1749](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/) | GFG | ⬜ |
| 7 | Maximum Subarray Sum With One Deletion | [LC 1186](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/) | GFG | ⬜ |
| 8 | Maximum Alternating Subsequence Sum | [LC 1911](https://leetcode.com/problems/maximum-alternating-subsequence-sum/) | GFG | ⬜ |
| 9 | Maximum Subarray Sum After One Operation | — | GFG | ⬜ |
| 10 | Maximum Sum Rectangle | [LC 85](https://leetcode.com/problems/maximal-rectangle/) | GFG | ⬜ |