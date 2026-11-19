# 229. Majority Element II

**Difficulty:** Medium  
**Topics:** Array, HashMap, Boyer-Moore Voting Algorithm

## Problem Statement

Given an integer array `nums` of size `n`, find all elements that appear more than `⌊n / 3⌋` times.

Return the answer in any order.

**Important:** There can be at most two majority elements.

---

## 1. HashMap – One Pass

**Approach:** Frequency Counting using HashMap.

### Java Code

```java
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int n = nums.length;

        for (int num : nums) {

            // Count frequency
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);

            // Check majority condition
            if (freq == (n / 3) + 1) {
                res.add(num);
            }
        }

        return res;
    }
}
```

### Explanation

1. Create a HashMap to store elements and their frequencies.
2. Traverse the array once.
3. Use `getOrDefault()` to get the current frequency.
4. Increase the frequency and update the HashMap.
5. If `freq == (n / 3) + 1`, add the element to the result.

**Why use `==` instead of `>`?**

Using `>` can add the same element multiple times when its frequency increases further. Using `==` adds it only once, when it first becomes a majority element.

### Complexity

- **Time:** O(N) average
- **Space:** O(N)

---

## 2. Extended Boyer-Moore Voting Algorithm – Optimal

**Approach:** Two Candidates and Two Counters.

### Java Code

```java
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 1;

        int count1 = 0;
        int count2 = 0;

        // First pass: Find candidates
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3) {
            res.add(candidate1);
        }

        if (count2 > n / 3) {
            res.add(candidate2);
        }

        return res;
    }
}
```

### Explanation

1. Maintain two candidates and their counters.
2. If the current number matches a candidate, increase its counter.
3. If a counter is zero, select the current number as that candidate.
4. If the number matches neither candidate and both counters are non-zero, decrease both counters.
5. Traverse the array again to count the actual frequencies.
6. Add only candidates whose frequency is greater than `n / 3`.

### Complexity

- **Time:** O(N)
- **Space:** O(1) auxiliary space

---

## 3. Comparison

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| HashMap – One Pass | O(N) average | O(N) |
| Extended Boyer-Moore | O(N) | O(1) |

## 4. Key Interview Points

- More than `n / 3` means there can be at most two majority elements.
- HashMap stores frequency using key-value pairs.
- Boyer-Moore uses two candidates and two counters.
- Boyer-Moore requires a second pass to verify candidates.
- Extended Boyer-Moore is the optimal approach because it uses O(1) auxiliary space.