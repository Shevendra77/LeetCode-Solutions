# 128. Longest Consecutive Sequence

**Difficulty:** Medium
**Topics:** Array, Sorting, HashSet

---

## 🧠 Problem Understanding

Given an unsorted array `nums`, return the length of the longest sequence of consecutive elements.

Consecutive elements are numbers that follow one another, such as `1, 2, 3, 4`.

The elements do not need to be next to each other in the original array.

**Example:**

```
nums = [100, 4, 200, 1, 3, 2]
Output = 4
```

The longest consecutive sequence is `[1, 2, 3, 4]`. Its length is `4`.

> **Important:** The problem requires an optimal solution with **O(N)** time complexity.

---

## Approach 1: Sorting – Consecutive Checking

### 🔍 Intuition

First, sort the array so that consecutive numbers appear next to each other.

Then:

- Ignore duplicate elements.
- If the current element is one greater than the previous element, increase `count`.
- Otherwise, reset `count` to 1.
- Update `longest` whenever a longer sequence is found.

### 💻 Java Code

```java
import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {

        // Handle empty array
        if (nums.length == 0) {
            return 0;
        }

        // Sort the array
        Arrays.sort(nums);

        int count = 1;
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {

            // Ignore duplicate elements
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Check consecutive elements
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            // Update longest sequence
            longest = Math.max(count, longest);
        }

        return longest;
    }
}
```

### 📊 Algorithm

1. Check whether the array is empty. If it is, return `0`.
2. Sort the array using `Arrays.sort()`.
3. Initialize `count = 1` and `longest = 1`.
4. Traverse the array from index `1`.
5. If the current element is equal to the previous element, skip it.
6. If the current element is one greater than the previous element, increase `count`.
7. Otherwise, reset `count = 1`.
8. Update `longest` using `Math.max()`.
9. Return `longest`.

### 📊 Dry Run

**Input:** `nums = [100, 4, 200, 1, 3, 2]`

**After sorting:** `[1, 2, 3, 4, 100, 200]`

**Initial values:** `count = 1; longest = 1;`

| i | nums[i - 1] | nums[i] | Condition        | count | longest |
|---|-------------|---------|------------------|-------|---------|
| 1 | 1           | 2       | Consecutive      | 2     | 2       |
| 2 | 2           | 3       | Consecutive      | 3     | 3       |
| 3 | 3           | 4       | Consecutive      | 4     | 4       |
| 4 | 4           | 100     | Not consecutive  | 1     | 4       |
| 5 | 100         | 200     | Not consecutive  | 1     | 4       |

**Final `longest` = 4**

**Output:** `4`

### ⏱️ Complexity

- **Time:** O(N log N) – Sorting takes O(N log N), and traversal takes O(N).
- **Space:** Depends on the sorting implementation; Java's primitive array sort uses implementation-dependent auxiliary space.

> **Note:** This approach is correct, but it does not satisfy the problem's required O(N) time complexity.

---

## Approach 2: HashSet – Optimal Solution

### 🔍 Intuition

Use a `HashSet` to store all unique elements.

The important idea is to **start counting only from the first element of a consecutive sequence**.

Rules:

1. Add all array elements to a `HashSet`.
2. For each element, check whether `num - 1` exists.
3. If `num - 1` does not exist, the current number is the starting point.
4. Count consecutive numbers using `num + 1`.
5. Update the maximum sequence length.

For example, in `[1, 2, 3, 4]`:

- `1` is the starting point because `0` does not exist.
- `2` is skipped because `1` exists.
- `3` is skipped because `2` exists.
- `4` is skipped because `3` exists.

This prevents counting the same sequence repeatedly.

### 💻 Java Code

```java
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        // Store unique elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        // Check each element
        for (int num : set) {

            // Find starting point
            if (!set.contains(num - 1)) {

                int count = 1;

                // Count consecutive elements
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }

                // Update maximum length
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
```

### 📊 Algorithm

1. Create a `HashSet`.
2. Insert all elements of the array into the `HashSet`.
3. Initialize `max = 0`.
4. Traverse the `HashSet`.
5. Check whether `num - 1` exists.
6. If it does not exist, initialize `count = 1`.
7. Use a `while` loop to check whether `num + 1` exists.
8. Increase `count` and `num` while consecutive elements are found.
9. Update `max` using `Math.max()`.
10. Return `max`.

### 📊 Dry Run

**Input:** `nums = [100, 4, 200, 1, 3, 2]`

**HashSet:** `[100, 4, 200, 1, 3, 2]`

**Initial value:** `max = 0;`

| num | Is `num - 1` present? | Action                          | max |
|-----|-----------------------|---------------------------------|-----|
| 100 | No                    | Count `[100]`, count = 1        | 1   |
| 4   | Yes                   | Skip                            | 1   |
| 200 | No                    | Count `[200]`, count = 1        | 1   |
| 1   | No                    | Count `[1, 2, 3, 4]`, count = 4 | 4   |
| 3   | Yes                   | Skip                            | 4   |
| 2   | Yes                   | Skip                            | 4   |

> **Note:** `HashSet` does not guarantee iteration order. This table follows the input order only to explain the logic.

**Final `max` = 4**

**Output:** `4`

### ⭐ Important Condition

```java
if (!set.contains(num - 1))
```

This condition checks whether the current number is the starting point of a sequence.

If the previous number exists, the current number is not the starting point, so we skip it.

### ⏱️ Complexity

- **Time:** O(N) average – `HashSet` insertion and lookup take O(1) average time. Each sequence is counted only from its starting element.
- **Space:** O(N) – `HashSet` stores the unique elements.

---

## ⚖️ Comparison

| Feature             | Sorting                              | HashSet                  |
|---------------------|--------------------------------------|--------------------------|
| Technique           | Sorting and adjacent comparison      | Starting-point checking  |
| Time                | O(N log N)                           | O(N) average             |
| Space               | Depends on sorting implementation    | O(N)                     |
| Meets required time? | No                                  | Yes                      |
| Main condition      | `nums[i] == nums[i - 1] + 1`         | `!set.contains(num - 1)` |
| Extra data structure | Sorted array                        | `HashSet`                |

---

## ⭐ Important Interview Points

- Sorting places consecutive elements next to each other.
- Duplicate elements must not increase the sequence length.
- `count` tracks the current consecutive sequence.
- `longest` stores the maximum sequence length.
- `HashSet` stores unique elements and provides average O(1) lookup.
- `!set.contains(num - 1)` identifies the starting point of a sequence.
- The `HashSet` approach satisfies the required O(N) average time complexity.

**Pattern:** Array → Sorting | Hashing → HashSet | Consecutive Sequence → Starting Point Technique