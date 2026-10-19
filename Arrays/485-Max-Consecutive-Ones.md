# 485. Max Consecutive Ones

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/max-consecutive-ones/

## Problem

Binary array `nums` diya hai. Sabse lambi consecutive `1`'s ki length return karo.

```
Input:  nums = [1,1,0,1,1,1]
Output: 3

Input:  nums = [1,0,1,1,0,1]
Output: 2
```

## Approach

**Single Pass with Running Counter (Linear Scan)**, isse Kadane-style streak counting bhi bol sakte ho.

```
count    = abhi chal rahi streak
maxCount = ab tak ki sabse lambi streak
```

- `1` mila: streak badhi, `count++` aur `maxCount` update karo
- `0` mila: streak toot gayi, `count = 0` (maxCount safe rehta hai)

## Algorithm

1. `count = 0`, `maxCount = 0` se start karo.
2. Array ko left se right ek baar scan karo.
3. Har element par:
   - Agar `nums[i] == 1`: `count++` aur `maxCount = max(maxCount, count)`
   - Agar `nums[i] == 0`: `count = 0`
4. Loop ke baad `maxCount` return karo.

## Pseudocode

```
count = 0
maxCount = 0
for each num in nums:
    if num == 1:
        count = count + 1
        maxCount = max(maxCount, count)
    else:
        count = 0
return maxCount
```

## Code (Java)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
```

## Dry Run

`nums = [1, 1, 0, 1, 1, 1]`

| i | nums[i] | Action  | count | maxCount |
|---|---------|---------|-------|----------|
| 0 | 1       | count++ | 1     | 1        |
| 1 | 1       | count++ | 2     | 2        |
| 2 | 0       | reset   | 0     | 2        |
| 3 | 1       | count++ | 1     | 2        |
| 4 | 1       | count++ | 2     | 2        |
| 5 | 1       | count++ | 3     | 3        |

**Output:** `3`

## Complexity

| | Value | Reason |
|---|---|---|
| Time  | O(n) | array ek baar scan hota hai |
| Space | O(1) | sirf do variables |

## Dhyan rakho

`maxCount` ko **har 1 par update** karte hain, isliye agar longest streak array ke end me ho tab bhi sahi answer milta hai. Agar sirf `0` par update karte, to last streak miss ho jati.

## Short me

> Ek hi pass me current streak aur maximum streak track karo. 1 par badhao, 0 par reset karo.