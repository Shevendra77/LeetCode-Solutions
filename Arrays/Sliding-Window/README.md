# 3. Sliding Window ⭐⭐⭐⭐⭐

This is especially important because you're currently studying this pattern.

### 🧠 When to use

Look for:

- contiguous substring
- contiguous subarray
- longest
- minimum
- exactly K
- at most K
- fixed size K
- maximum/minimum inside window

### Fixed window

```java
int left = 0;
long long sum = 0;

for (int right = 0; right < n; right++) {

    sum += nums[right];

    if (right - left + 1 > k) {
        sum -= nums[left];
        left++;
    }

    if (right - left + 1 == k) {
        // process
    }
}
```

### 10 Problems

| # | Problem | LeetCode | GFG | Done |
|---|---|---|---|---|
| 1 | Maximum Average Subarray I | [LC 643](https://leetcode.com/problems/maximum-average-subarray-i/) | [GFG](https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/) | ⬜ |
| 2 | Maximum Number of Vowels in a Substring | [LC 1456](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) | GFG | ⬜ |
| 3 | Find All Anagrams | [LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | GFG | ⬜ |
| 4 | Permutation in String | [LC 567](https://leetcode.com/problems/permutation-in-string/) | GFG | ⬜ |
| 5 | Longest Substring Without Repeating Characters | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | GFG | ⬜ |
| 6 | Longest Repeating Character Replacement | [LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) | GFG | ⬜ |
| 7 | Max Consecutive Ones | [LC 485](https://leetcode.com/problems/max-consecutive-ones/) | Simple Counting | ✅ |
| 8 | Max Consecutive Ones III | [LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) | GFG | ✅  |
| 9 | Fruit Into Baskets | [LC 904](https://leetcode.com/problems/fruit-into-baskets/) | GFG | ⬜ |
| 10 | Minimum Size Subarray Sum | [LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/) | GFG | ⬜ |
| 11 | Sliding Window Maximum | [LC 239](https://leetcode.com/problems/sliding-window-maximum/) | [GFG](https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/) | ⬜ |
| 12 | Maximum Sum Subarray of Size K | [GFG](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1) | ✅ | ⬜ |

### 🔥 Master recognition

```
CONTIGUOUS
   +
SUBARRAY / SUBSTRING
   +
LONGEST / MINIMUM / COUNT
   ↓
SLIDING WINDOW
```