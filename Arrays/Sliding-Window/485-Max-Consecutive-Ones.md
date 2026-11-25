# Max Consecutive Ones

**Difficulty:** Easy

**Topic:** Array, Counting, Single Pass

## 🧠 Problem Understanding

Given a binary array `nums`, return the maximum number of consecutive `1`s in the array.

## Example 1

**Input:**
```text
nums = [1, 1, 0, 1, 1, 1]
```

**Output:**
```text
3
```

**Explanation:**

The consecutive groups of `1`s are:

- `[1, 1]` → Count = 2
- `[1, 1, 1]` → Count = 3

Maximum consecutive ones = `3`.

## Example 2

**Input:**
```text
nums = [1, 0, 1, 1, 0, 1]
```

**Output:**
```text
2
```

**Explanation:**

The consecutive groups of `1`s are:

- `[1]` → Count = 1
- `[1, 1]` → Count = 2
- `[1]` → Count = 1

Maximum consecutive ones = `2`.

## Approach: Simple Array Traversal

### Intuition

We only need the length of the current run of `1`s, so no extra data structure is required. Two variables are enough:

- `count`: Counts the current consecutive ones.
- `maxCount`: Stores the maximum consecutive ones found so far.

Whenever we encounter `1`, we increment `count` and update `maxCount`.

Whenever we encounter `0`, we reset `count` to `0` because the consecutive sequence is broken.

### Steps

1. Initialize `count = 0`.
2. Initialize `maxCount = 0`.
3. Traverse the array from index `0` to `nums.length - 1`.
4. If the current element is `1`, increment `count`.
5. Update `maxCount` using `Math.max(maxCount, count)`.
6. If the current element is `0`, reset `count = 0`.
7. Return `maxCount`.

### Java Code

```java
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCount = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {

                // Count consecutive ones
                count++;

                // Update maximum count
                maxCount = Math.max(maxCount, count);

            } else {

                // Reset count when zero is found
                count = 0;
            }
        }

        return maxCount;
    }
}
```

### Compact Alternative

```java
for (int i = 0; i < nums.length; i++) {
    count = (nums[i] == 1) ? count + 1 : 0;
    maxCount = Math.max(maxCount, count);
}
```

Same logic and complexity, just written more tersely.

---

## Dry Run

**Input:**
```text
nums = [1, 1, 0, 1, 1, 1]
```

**Initial Values:**
```text
count = 0
maxCount = 0
```

**Array Traversal:**

| Index | nums[i] | Calculation | Count | Max Count |
|---|---:|---|---:|---:|
| 0 | 1 | count++ | 1 | 1 |
| 1 | 1 | count++ | 2 | 2 |
| 2 | 0 | count = 0 | 0 | 2 |
| 3 | 1 | count++ | 1 | 2 |
| 4 | 1 | count++ | 2 | 2 |
| 5 | 1 | count++ | 3 | 3 |

**Final Output:**
```text
3
```

---

## Edge Cases

| Input | Output | Why |
|---|---:|---|
| `[1, 1, 1]` | 3 | All ones; `maxCount` updates on every `1` |
| `[0, 0, 0]` | 0 | No ones, `maxCount` never changes |
| `[]` | 0 | Loop doesn't run |
| `[1]` | 1 | Single element works |
| `[0, 1, 1]` | 2 | Run of ones at the end is still counted |

## Complexity Analysis

- **Time Complexity:** O(n) – Each array element is processed exactly once.
- **Space Complexity:** O(1) – Only two variables are used.

## Key Concepts

- Array Traversal
- Counting
- Consecutive Elements
- Single Pass
- Math.max()

## Interview Note

The most important logic in this problem is:

```java
if (nums[i] == 1) {
    count++;
    maxCount = Math.max(maxCount, count);
} else {
    count = 0;
}
```

Whenever we encounter `1`, we increment the current count. Whenever we encounter `0`, we reset the count because the consecutive sequence breaks.

**Common pitfall:** Updating `maxCount` only inside the `else` branch (when a `0` is found) misses a run of ones that ends at the last index of the array. Updating it inside the `if` branch avoids this bug.

**Recommended Approach: Simple Array Traversal (Single Pass).**