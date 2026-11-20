# 1. Hashing / Frequency Map ⭐⭐⭐⭐⭐

### 🧠 When to use

Think **HashMap / unordered_map / unordered_set** when you see:

- "frequency"
- "duplicate"
- "appears exactly K times"
- "find pair"
- "seen before"
- "count occurrences"
- "anagram"
- "distinct elements"

### Template

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int x : nums) {
    map.put(x, map.getOrDefault(x, 0) + 1);
}
```

### 10 Problems

| # | Problem | LC | GFG | Done |
|---|---|---|---|---|
| 1 | Two Sum | [LC 1](https://leetcode.com/problems/two-sum/) | [GFG](https://www.geeksforgeeks.org/problems/key-pair5616/1) | ✅ |
| 2 | Contains Duplicate | [LC 217](https://leetcode.com/problems/contains-duplicate/) | [GFG](https://www.geeksforgeeks.org/problems/find-duplicates-in-an-array/1) | ✅ |
| 3 | Contains Duplicate II | [LC 219](https://leetcode.com/problems/contains-duplicate-ii/) | — | ✅ |
| 4 | Valid Anagram | [LC 242](https://leetcode.com/problems/valid-anagram/) | [GFG](https://www.geeksforgeeks.org/problems/anagram-1587115620/1) | ⬜ |
| 5 | Majority Element | [LC 169](https://leetcode.com/problems/majority-element/) | [GFG](https://www.geeksforgeeks.org/problems/majority-element-1587115620/1) | ✅ |
| 6 | Majority Element II | [LC 229](https://leetcode.com/problems/majority-element-ii/) | — | ✅ |
| 7 | Group Anagrams | [LC 49](https://leetcode.com/problems/group-anagrams/) | [GFG](https://www.geeksforgeeks.org/problems/print-anagrams-together/1) | ⬜ |
| 8 | Top K Frequent Elements | [LC 347](https://leetcode.com/problems/top-k-frequent-elements/) | [GFG](https://www.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1) | ✅ |
| 9 | Longest Consecutive Sequence | [LC 128](https://leetcode.com/problems/longest-consecutive-sequence/) | [GFG](https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1) | ⬜ |
| 10 | Subarray Sum Equals K | [LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) | [GFG](https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1) | ⬜ |
| 11 | Longest Subarray With Sum K | — | [GFG](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1) | ⬜ |
| 12 | Count Distinct Elements in Every Window | — | [GFG](https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1) | ⬜ |