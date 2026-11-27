# 560. Subarray Sum Equals K

**LeetCode:** [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)  
**Difficulty:** Medium  
**Pattern:** Prefix Sum + HashMap

## 1. Problem Understanding

Given an integer array `nums` and an integer `k`, return the total number of non-empty contiguous subarrays whose sum equals `k`.

**Example:**

```java
Input: nums = [1, 1, 1], k = 2
Output: 2
```

Valid subarrays:
- `[1, 1]` → Sum = 2
- `[1, 1]` → Sum = 2

## 2. Intuition

We use **Prefix Sum + HashMap** to solve this problem efficiently.

Instead of calculating the sum of every possible subarray, we maintain a running prefix sum.

**Mathematical formula:**

```text
Current Prefix Sum - Previous Prefix Sum = k

Previous Prefix Sum = Current Prefix Sum - k
```

Therefore, for every current prefix sum, we search for `prefixSum - k` in the HashMap.

## 3. Java Solution

```java
class Solution {
    public int subarraySum(int[] nums, int k) {

        // Stores prefixSum as key and its frequency as value
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix sum occurs once
        // Handles subarrays starting from index 0
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate current prefix sum
            prefixSum = prefixSum + nums[i];

            // Find the required previous prefix sum
            int target = prefixSum - k;

            // If target exists, add its frequency to count
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            // Store or update the frequency of current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
```

## 4. Dry Run

**Input:**

```java
nums = [1, 1, 1]
k = 2
```

Initial values:

```text
map = {0=1}
prefixSum = 0
count = 0
```

| i | nums[i] | prefixSum | target = prefixSum - k | Frequency | count |
|---|---:|---:|---:|---:|---:|
| 0 | 1 | 1 | -1 | 0 | 0 |
| 1 | 1 | 2 | 0 | 1 | 1 |
| 2 | 1 | 3 | 1 | 1 | 2 |

**Final Answer:**

```text
count = 2
```

## 5. Important Concepts

### Why do we use `map.put(0, 1)`?

```java
map.put(0, 1);
```

- It represents an empty prefix sum.
- It helps count subarrays starting from index 0.
- Without it, some valid subarrays will be missed.

### Why do we store frequency instead of just checking existence?

```java
count += map.get(target);
```

Because the same prefix sum can occur multiple times.

For example:

```java
map = {0=1, 1=2, 3=1}
target = 1
count = 1;
```

Here:

```java
count += map.get(1);

// count = 1 + 2 = 3
```

**Remember:** We add the frequency of the target prefix sum, not just 1.

### Why update the HashMap after checking the target?

```java
// First search for the required previous prefix sum
count += map.getOrDefault(target, 0);

// Then store the current prefix sum
map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
```

This ensures we only use previous prefix sums and do not count empty subarrays.

## 6. Complexity Analysis

| Complexity | Value | Reason |
|---|---|---|
| Time | O(n) | Traverse the array once |
| Space | O(n) | HashMap stores prefix sums |

## 7. Interview Questions

**Q1. Why is Sliding Window not suitable for this problem?**

Because the array can contain negative numbers, and the window sum is not guaranteed to increase or decrease consistently.

**Q2. What does the HashMap store?**

Prefix sum as the key and its frequency as the value.

**Q3. Why do we use `getOrDefault()`?**

To get the existing frequency or return 0 if the prefix sum is not present.

**Q4. What is the purpose of `map.put(0, 1)`?**

To handle subarrays that start from index 0.

**Q5. What happens if the target frequency is 3 and count is already 1?**

```java
count += 3;
// count = 4
```

## 8. Key Takeaway

```text
Prefix Sum + HashMap

1. Calculate current prefix sum.
2. Find target = prefixSum - k.
3. Add target frequency to count.
4. Update current prefix sum frequency.
5. Return count.
```

**Golden Rule:** `count += map.get(target)` adds the frequency because multiple previous prefix sums can form multiple valid subarrays.