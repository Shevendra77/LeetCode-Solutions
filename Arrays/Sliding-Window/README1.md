# 3. Sliding Window ⭐⭐⭐⭐⭐

**Difficulty:** Easy → Hard
**Category:** Arrays | Strings | Two Pointers
**Importance:** Very High
**Primary Goal:** Optimize problems involving contiguous subarrays and substrings.

Sliding Window is an optimization technique that maintains a range (window) over an array or string and moves it efficiently instead of recalculating results for every possible range.

---

## 🧠 1. When to Use Sliding Window

Look for these keywords in the problem statement:

- Contiguous subarray
- Contiguous substring
- Longest / Shortest
- Maximum / Minimum
- Exactly K elements
- At Most K elements
- Fixed window size K
- Number of valid subarrays or substrings
- Window-based frequency counting

**Recognition Rule:**

If a problem involves a contiguous range and asks you to find its length, sum, frequency, maximum, minimum, or count, consider Sliding Window.

> Note: Not every contiguous subarray problem requires Sliding Window. Problems involving negative numbers and arbitrary target sums may require Prefix Sum + HashMap instead.

---

## 📌 2. Types of Sliding Window

| Type            | Description                             | Common Use             |
| --------------- | --------------------------------------- | ---------------------- |
| Fixed Size      | Window size remains constant            | Maximum sum of size K  |
| Variable Size   | Window expands and shrinks dynamically  | Longest valid subarray |
| Frequency-Based | Maintains character/element frequencies | Anagrams, permutations |
| Monotonic Deque | Maintains maximum/minimum efficiently   | Sliding Window Maximum |

---

## 🔹 3. Fixed Size Sliding Window

**When to use:**

- Window size K is given.
- Find maximum/minimum sum of K consecutive elements.
- Find average of every window of size K.
- Count elements satisfying a condition inside each window.

### Java Template

```java
int left = 0;
long sum = 0;

for (int right = 0; right < n; right++) {

    // 1. Add the incoming element
    sum += nums[right];

    // 2. Maintain window size K
    if (right - left + 1 > k) {
        sum -= nums[left];
        left++;
    }

    // 3. Process the valid window
    if (right - left + 1 == k) {

        // Update answer
    }
}
```

**Window Size Formula:**

```java
right - left + 1
```

**Time Complexity:** O(n)
**Auxiliary Space:** O(1), excluding any additional data structures used.

---

## 🔹 4. Variable Size Sliding Window

**When to use:**

- Find the longest valid subarray or substring.
- Find the smallest window satisfying a condition.
- Find the longest range with at most K distinct elements.
- Find a subarray satisfying a constraint.

### Java Template

```java
int left = 0;
int ans = 0;

for (int right = 0; right < n; right++) {

    // 1. Expand the window
    // Add nums[right] to window state

    // 2. Shrink while the window is invalid
    while (/* window is invalid */) {

        // Remove nums[left] from window state
        left++;
    }

    // 3. Update answer using valid window
    ans = Math.max(ans, right - left + 1);
}
```

**Important:**

- `right++` expands the window.
- `left++` shrinks the window.
- `while` maintains the window condition.
- Update the answer after restoring validity.

This template is suitable for monotonic window conditions. For example, sum-based shrinking generally requires non-negative elements.

---

## 🔹 5. Exactly K and At Most K

These are important advanced Sliding Window concepts.

**At Most K:**

The window can contain K or fewer distinct elements.

**Exactly K:**

A useful counting technique is:

```java
exactlyK = atMostK(k) - atMostK(k - 1);
```

This works for counting problems where the at-most-K counting function is valid.

---

## 🔹 6. Sliding Window + Monotonic Deque

**When to use:**

- Find maximum element in every window of size K.
- Find minimum element in every window of size K.
- Maintain maximum/minimum efficiently while moving the window.

Example: LeetCode 239 — Sliding Window Maximum.

A Deque maintains candidate indices in monotonic order.

**Time Complexity:** O(n)

---

## 🎯 7. LeetCode Practice Problems (10)

### Fixed Size Sliding Window

| # | Problem                                 | LeetCode                                                                                          | Done |
| - | --------------------------------------- | ------------------------------------------------------------------------------------------------- | ---- |
| 1 | Maximum Average Subarray I              | [LC 643](https://leetcode.com/problems/maximum-average-subarray-i/)                               | ⬜    |
| 2 | Maximum Number of Vowels in a Substring | [LC 1456](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) | ⬜    |

### Frequency-Based Sliding Window

| # | Problem                       | LeetCode                                                               | Done |
| - | ----------------------------- | ---------------------------------------------------------------------- | ---- |
| 3 | Find All Anagrams in a String | [LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | ⬜    |
| 4 | Permutation in String         | [LC 567](https://leetcode.com/problems/permutation-in-string/)         | ⬜    |

### Variable Size Sliding Window

| # | Problem                                        | LeetCode                                                                              | Done |
| - | ---------------------------------------------- | ------------------------------------------------------------------------------------- | ---- |
| 5 | Longest Substring Without Repeating Characters | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | ⬜    |
| 6 | Longest Repeating Character Replacement        | [LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/)      | ⬜    |
| 7 | Max Consecutive Ones III                       | [LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/)                    | ⬜    |
| 8 | Fruit Into Baskets                             | [LC 904](https://leetcode.com/problems/fruit-into-baskets/)                           | ⬜    |
| 9 | Minimum Size Subarray Sum                      | [LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/)                    | ⬜    |

### Advanced: Monotonic Deque

| #  | Problem                | LeetCode                                                        | Done |
| -- | ---------------------- | --------------------------------------------------------------- | ---- |
| 10 | Sliding Window Maximum | [LC 239](https://leetcode.com/problems/sliding-window-maximum/) | ⬜    |

---

## 🔥 8. Master Pattern Recognition

```text
CONTIGUOUS SUBARRAY / SUBSTRING
              |
              v
       Identify the window
              |
       +------+------+
       |             |
       v             v
   Fixed Size    Variable Size
       |             |
       v             v
   Window K     Expand + Shrink
       |             |
       v             v
   Add / Remove  Maintain Condition
       |             |
       +------+------+
              |
              v
       Update Answer
```

### Quick Revision Table

| Requirement                    | Pattern                  |
| ------------------------------ | ------------------------ |
| Exactly K consecutive elements | Fixed Window             |
| Longest valid subarray         | Variable Window          |
| Smallest valid subarray        | Variable Window          |
| At most K distinct elements    | Variable + HashMap       |
| Exactly K distinct elements    | At Most K - At Most K-1  |
| Anagrams / Permutations        | Frequency + Fixed Window |
| Maximum in every window        | Monotonic Deque          |

---

## ✅ 9. Learning Checklist

- [ ] Understand the Sliding Window concept.
- [ ] Master Fixed Size Sliding Window.
- [ ] Master Variable Size Sliding Window.
- [ ] Understand HashMap + Sliding Window.
- [ ] Understand Exactly K vs At Most K.
- [ ] Learn Monotonic Deque.
- [ ] Solve all 10 LeetCode problems.
- [ ] Write solutions without looking at notes.
- [ ] Explain time and space complexity.

**Final Goal:** Identify the correct Sliding Window pattern from the problem statement and implement an optimized O(n) solution whenever the problem structure permits it.