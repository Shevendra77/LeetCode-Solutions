# Fruit Into Baskets

**Difficulty:** Medium

**Topic:** Array, HashMap, Variable Size Sliding Window, Two Pointers

## 🧠 Problem Understanding

Given an array `fruits`, find the maximum number of fruits that can be collected from a contiguous subarray.

There are two baskets, and each basket can contain only one type of fruit.

In simple words, find the **longest contiguous subarray containing at most 2 distinct elements**.

## Example 1

**Input:**
```text
fruits = [1, 2, 1, 2, 3]
```

**Output:**
```text
4
```

**Explanation:**

The longest valid subarray is:

`[1, 2, 1, 2]`

- Basket 1 → Fruit type 1
- Basket 2 → Fruit type 2

Maximum fruits collected = `4`.

## Example 2

**Input:**
```text
fruits = [0, 1, 2, 2]
```

**Output:**
```text
3
```

**Explanation:**

The longest valid subarray is:

`[1, 2, 2]`

It contains only 2 distinct fruit types (`1` and `2`). Shorter valid subarrays such as `[2, 2]` also exist, but they are not the longest.

Maximum fruits collected = `3`.

## Approach: Variable Size Sliding Window + HashMap

### Intuition

We need to find the longest contiguous subarray containing at most 2 distinct fruit types.

A Variable Size Sliding Window with a HashMap is useful because the window size changes dynamically.

We use three variables:

- `left`: Stores the starting index of the current window.
- `ans`: Stores the maximum valid window length.
- `map`: Stores each fruit type and its frequency inside the current window.

We expand the window by moving the `right` pointer and adding the current fruit to the HashMap.

Whenever the HashMap contains more than 2 distinct fruit types, we shrink the window from the left until only 2 distinct types remain.

At every step, we update the maximum window length.

### Steps

1. Initialize `left = 0`.
2. Initialize `ans = 0`.
3. Create a HashMap to store fruit frequencies.
4. Traverse the array using the `right` pointer.
5. Add the current fruit to the HashMap using `getOrDefault()`.
6. If `map.size() > 2`, shrink the window.
7. Decrease the frequency of the leftmost fruit.
8. If its frequency becomes zero, remove it from the HashMap.
9. Move the `left` pointer forward.
10. Update `ans` using `Math.max(ans, right - left + 1)`.
11. Return `ans`.

### Java Code

```java
import java.util.HashMap;

class Solution {

    public int totalFruit(int[] fruits) {

        int ans = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Expand the window using the right pointer
        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit and update its frequency
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Shrink the window if more than two fruit types exist
            while (map.size() > 2) {

                // Decrease the frequency of the leftmost fruit
                map.put(fruits[left], map.get(fruits[left]) - 1);

                // Remove the fruit when its frequency becomes zero
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                // Move the left pointer forward
                left++;
            }

            // Update the maximum window length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
```

### Compact Alternative

```java
for (int right = 0; right < fruits.length; right++) {

    map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

    while (map.size() > 2) {

        map.put(fruits[left], map.get(fruits[left]) - 1);

        if (map.get(fruits[left]) == 0) {
            map.remove(fruits[left]);
        }

        left++;
    }

    ans = Math.max(ans, right - left + 1);
}
```

Same logic and complexity, just written more tersely.

---

## Dry Run

**Input:**
```text
fruits = [1, 2, 1, 2, 3]
```

**Initial Values:**
```text
left = 0
ans = 0
map = {}
```

**Array Traversal:**

| Right | Fruit | HashMap | Window | Action | Ans |
|---:|---:|---|---|---|---:|
| 0 | 1 | {1=1} | [1] | Expand | 1 |
| 1 | 2 | {1=1, 2=1} | [1,2] | Expand | 2 |
| 2 | 1 | {1=2, 2=1} | [1,2,1] | Expand | 3 |
| 3 | 2 | {1=2, 2=2} | [1,2,1,2] | Expand | 4 |
| 4 | 3 | {1=2, 2=2, 3=1} | [1,2,1,2,3] | Shrink | 4 |

At `right = 4`, the HashMap contains 3 distinct fruit types.

We shrink the window:

- Remove `1` → frequency becomes 1.
- Remove `2` → frequency becomes 1.
- Remove `1` → frequency becomes 0, so remove type `1`.

Now the valid window is:

`[2, 3]`

The HashMap becomes `{2=1, 3=1}`.

**Final Output:**
```text
4
```

## Edge Cases

| Input | Output | Why |
|---|---:|---|
| `[1, 2, 1, 2]` | 4 | Exactly 2 distinct types |
| `[1, 2, 3]` | 2 | Maximum valid window has 2 elements |
| `[1, 1, 1, 1]` | 4 | Only 1 distinct type |
| `[0, 1, 2, 2]` | 3 | Longest valid window is `[1,2,2]` |
| `[5]` | 1 | Single element |
| `[]` | 0 | Empty array |

## Complexity Analysis

- **Time Complexity:** O(n) – Each element is added and removed at most once because both pointers move only forward.
- **Space Complexity:** O(1) – The HashMap stores at most 3 distinct fruit types temporarily before shrinking the window.

## Key Concepts

- Variable Size Sliding Window
- Two Pointers
- HashMap
- Frequency Counting
- At Most K Distinct Elements
- `getOrDefault()`
- `Math.max()`
- `map.size()`
- `map.remove()`

## Interview Note

The most important logic in this problem is:

```java
while (map.size() > 2) {

    map.put(fruits[left], map.get(fruits[left]) - 1);

    if (map.get(fruits[left]) == 0) {
        map.remove(fruits[left]);
    }

    left++;
}

ans = Math.max(ans, right - left + 1);
```

Whenever the number of distinct fruit types becomes greater than 2, we shrink the window from the left until the condition becomes valid.

Then we update the maximum window length.

**Important Formulas:**

```java
// Check number of distinct fruit types
map.size() > 2

// Decrease fruit frequency
map.get(fruits[left]) - 1

// Current window length
right - left + 1
```

**Common Pitfall 1:** Forgetting to remove a fruit from the HashMap when its frequency becomes zero. This causes `map.size()` to give an incorrect number of distinct fruit types.

**Common Pitfall 2:** Writing `map.get(fruits[left] - 1)` instead of `map.get(fruits[left]) - 1`. The subtraction must apply to the frequency, not the fruit value.

**Recommended Approach: Variable Size Sliding Window + HashMap.**