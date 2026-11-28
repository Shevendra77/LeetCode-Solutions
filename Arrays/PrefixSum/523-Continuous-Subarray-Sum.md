# 523. Continuous Subarray Sum

**LeetCode:** [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)  
**Difficulty:** Medium  
**Pattern:** Prefix Sum + Remainder HashMap (related: LC 560, LC 974)

**Constraints worth remembering:** `1 <= k`, `0 <= nums[i]`, and the total sum fits in a 32-bit `int`, so there is no overflow and no negative remainder to worry about.

### 🧠 Intuition

We need to check whether there exists a contiguous subarray:

- Having a length of at least 2.
- Whose sum is a multiple of `k`.

For this, we use **Prefix Sum + HashMap + Modulo**.

Instead of calculating every subarray sum, we calculate the running prefix sum and its remainder.

**Mathematical Formula:**

```text
(prefixSum - previousPrefixSum) % k = 0
```

Therefore:

```text
prefixSum % k = previousPrefixSum % k
```

If two prefix sums have the same remainder, their difference is divisible by `k`.

- If the remainder already exists in the map, check the subarray length.
- Otherwise, store the remainder and its index.

### 🔍 Approach: Prefix Sum + HashMap (Remainder)

1. Create a HashMap to store the remainder as key and its first index as value.
2. Initialize `map.put(0, -1)` to handle subarrays starting from index 0.
3. Calculate the running prefix sum.
4. Calculate the remainder using `prefixSum % k`.
5. Check whether the remainder already exists in the HashMap.
6. If it exists, check whether the subarray length is at least 2.
7. If it does not exist, store the remainder and its current index.
8. Return `false` if no valid subarray is found.

### 💻 Java Code

```java
import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // Store remainder as key and first index as value
        HashMap<Integer, Integer> map = new HashMap<>();

        // Handle subarrays starting from index 0
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate current prefix sum
            prefixSum += nums[i];

            // Calculate remainder
            int rem = prefixSum % k;

            // Check whether remainder already exists
            if (map.containsKey(rem)) {

                // Check whether subarray length is at least 2
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            }
            else {

                // Store only the first occurrence of remainder
                map.put(rem, i);
            }
        }

        return false;
    }
}
```

### 📊 Dry Run

**Input:**

```java
nums = [23, 2, 4, 6, 7]
k = 6
```

Initial values:

```text
map = {0=-1}
prefixSum = 0
```

| i | nums[i] | prefixSum | rem = prefixSum % 6 | Action |
|---:|---:|---:|---:|---|
| 0 | 23 | 23 | 5 | Store 5 → 0 |
| 1 | 2 | 25 | 1 | Store 1 → 1 |
| 2 | 4 | 29 | 5 | Remainder found! |

At index 2:

```text
Current index = 2
Previous index = 0

Subarray length = 2 - 0 = 2
```

Valid subarray:

```text
[2, 4]

Sum = 6

6 % 6 = 0
```

**Output:**

```java
true
```

### 🚧 Edge Cases

**1. Length check rejects a single element**

```text
nums = [6], k = 6

i = 0 → prefixSum = 6, rem = 0
map has 0 → -1, but 0 - (-1) = 1 < 2 → not valid

Output: false
```

The remainder exists, but the subarray has only one element. We do **not** overwrite the stored index, because the first occurrence is always the best one.

**2. Zeros**

```text
nums = [0, 0], k = 5

i = 0 → prefixSum = 0, rem = 0 → length 1, not valid
i = 1 → prefixSum = 0, rem = 0 → 1 - (-1) = 2 → valid

Output: true
```

`0` is a multiple of every `k`, so two consecutive zeros always form a valid subarray.

### ⏱️ Complexity Analysis

- **Time Complexity:** `O(N)` – We traverse the array once. HashMap operations take O(1) average time.
- **Space Complexity:** `O(min(N, k))` – The map holds at most `k` distinct remainders (`0` to `k - 1`) and at most `N + 1` entries. Saying `O(N)` is also acceptable.

### ⭐ Important Points

**1. Why do we use `map.put(0, -1)`?**

- It handles subarrays starting from index 0.
- It represents an empty prefix sum.
- It helps calculate the correct subarray length.

**2. Why do we store only the first occurrence?**

```java
else {
    map.put(rem, i);
}
```

This is the `else` branch of the `containsKey` check, so the index is written only when the remainder is seen for the first time. We keep the earliest index to get the maximum possible subarray length.

**3. Why do we use modulo?**

```java
int rem = prefixSum % k;
```

If two prefix sums have the same remainder, their difference is divisible by `k`.

**4. Why do we check `i - map.get(rem) >= 2`?**

Because the problem requires a contiguous subarray containing at least two elements.

**5. Why does `k > 0` and non-negative input matter?**

With negative numbers, Java's `%` can return a negative remainder, so equal remainders could look different. You would then normalize with `((prefixSum % k) + k) % k`. The LC 523 constraints rule this out, so the simple `prefixSum % k` is enough.

**6. Difference between LC 560 and LC 523:**

| LC 560 | LC 523 |
|---|---|
| Subarray Sum Equals K | Continuous Subarray Sum |
| Prefix Sum + HashMap | Prefix Sum + HashMap + Modulo |
| Stores prefix sum frequency | Stores remainder's first index |
| Counts valid subarrays | Checks whether a valid subarray exists |
| `prefixSum - k` | `prefixSum % k` |

**7. Follow-up: LC 974 (Subarray Sums Divisible by K)**

Same remainder idea, but it **counts** subarrays, so the map stores remainder **frequency** (like LC 560), and negative numbers are allowed, so remainder normalization is required.

### 🎯 Interview Questions

**Q1. What does the HashMap store?**

Remainder as the key and its first occurrence index as the value.

**Q2. Why don't we update the index if the remainder already exists?**

To preserve the earliest index and maximize the subarray length.

**Q3. What is the purpose of `map.put(0, -1)`?**

To handle subarrays starting from index 0.

**Q4. What happens if the same remainder occurs again?**

We calculate the distance between the current index and its first occurrence. If it is at least 2, we return `true`.

**Q5. Why is Sliding Window not the preferred approach?**

Sliding window needs a monotonic condition: adding an element grows the sum and removing one shrinks it, so we always know which way to move. "Sum is divisible by `k`" is not monotonic. A sum can be a multiple of `k`, stop being one after the next element, and become one again later, so there is no rule for when to shrink or expand the window. Prefix remainders avoid this problem.

### ⭐ Key Takeaway

```text
Prefix Sum + HashMap + Modulo

1. Initialize map.put(0, -1).
2. Calculate running prefix sum.
3. Calculate remainder = prefixSum % k.
4. Check whether remainder exists.
5. If found, check subarray length >= 2.
6. Otherwise, store the first occurrence.
7. Return true or false.
```

**Golden Rule:** If two prefix sums have the same remainder when divided by `k`, their difference is divisible by `k`.

**Pattern:** Prefix Sum + Remainder HashMap (related: LC 560, LC 974)

**Note:** This implementation assumes `k > 0` and non-negative array elements, as in the standard LeetCode 523 constraints.