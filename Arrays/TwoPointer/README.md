# 2. Two Pointers ⭐⭐⭐⭐⭐

### 🧠 When to use

Usually:

- sorted array
- pair/triplet
- left/right ends
- remove duplicates
- compare from both sides

### Template

```java
int left = 0;
int right = n - 1;

while (left < right) {

    if (condition)
        left++;
    else
        right--;
}
```

### 10 Problems

| # | Problem | LeetCode | GFG | Done |
|---|---|---|---|---|
| 1 | Valid Palindrome | [LC 125](https://leetcode.com/problems/valid-palindrome/) | [GFG](https://www.geeksforgeeks.org/problems/palindrome-string0817/1) | ⬜ |
| 2 | Two Sum II | [LC 167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | GFG | ⬜ |
| 3 | Remove Duplicates from Sorted Array | [LC 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | GFG | ⬜ |
| 4 | Move Zeroes | [LC 283](https://leetcode.com/problems/move-zeroes/) | [GFG](https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1) | ⬜ |
| 5 | Container With Most Water | [LC 11](https://leetcode.com/problems/container-with-most-water/) | GFG | ⬜ |
| 6 | 3Sum | [LC 15](https://leetcode.com/problems/3sum/) | GFG | ⬜ |
| 7 | 4Sum | [LC 18](https://leetcode.com/problems/4sum/) | GFG | ⬜ |
| 8 | Trapping Rain Water | [LC 42](https://leetcode.com/problems/trapping-rain-water/) | [GFG](https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1) | ⬜ |
| 9 | Boats to Save People | [LC 881](https://leetcode.com/problems/boats-to-save-people/) | GFG | ⬜ |
| 10 | Sort Colors | [LC 75](https://leetcode.com/problems/sort-colors/) | GFG | ⬜ |

### 🔥 Recognition

```
Sorted?
Pair?
Left + Right?
        ↓
Two Pointers
```