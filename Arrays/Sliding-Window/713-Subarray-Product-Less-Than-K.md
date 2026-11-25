# 🪟 713. Subarray Product Less Than K

**Difficulty:** Medium

**Pattern:** Variable Size Sliding Window

**Category:** Array | Sliding Window

**LeetCode:** [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/)

---

## 📝 1. Problem Understanding

You are given an integer array `nums` and an integer `k`.

Return the number of contiguous subarrays whose product is strictly less than `k`.

**Example 1:**

```text
Input: nums = [10, 5, 2, 6], k = 100

Output: 8
```

**Explanation:**

The valid subarrays are:

```text
[10]
[5]
[2]
[6]
[10, 5]
[5, 2]
[2, 6]
[5, 2, 6]
```

Total valid subarrays = `8`.

**Example 2:**

```text
Input: nums = [1, 2, 3], k = 0

Output: 0
```

**Example 3:**

```text
Input: nums = [1, 1, 1], k = 2

Output: 6
```

Every subarray has product `1`, and `1 < 2`, so all `3 + 2 + 1 = 6` subarrays are valid.

---

## 🧠 2. Intuition

We need to count all contiguous subarrays whose product is strictly less than `k`.

A brute-force approach checks every possible subarray and calculates its product, which takes O(n²) time (or worse).

Instead, we can use **Variable Size Sliding Window** to solve this efficiently.

**Main Idea:**

- Expand the window using `right`.
- Multiply the incoming element into `product`.
- If `product >= k`, shrink the window using `left`.
- Count all valid subarrays ending at the current `right`.

**Important Formula:**

```java
count += right - left + 1;
```

This formula counts all valid subarrays ending at the current `right` index.

---

## 🔹 3. Approach: Variable Size Sliding Window

**Step 1:** Handle the special condition first.

```java
if (k <= 1) {
    return 0;
}
```

Since all elements are positive integers, no non-empty subarray can have a product strictly less than `k` when `k <= 1`.

**Step 2:** Initialize variables.

```java
int left = 0;
int count = 0;
int product = 1;
```

**Step 3:** Expand the window.

```java
product *= nums[right];
```

Multiply the current element into the window product.

**Step 4:** Shrink the window if the product becomes invalid.

```java
while (product >= k) {
    product /= nums[left];
    left++;
}
```

Remove elements from the left until the product becomes strictly less than `k`.

**Step 5:** Count valid subarrays.

```java
count += right - left + 1;
```

Every subarray ending at `right` and starting between `left` and `right` is valid.

---

## 💻 4. Java Solution

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // Handle special condition
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int count = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {

            // 1. Expand the window
            product *= nums[right];

            // 2. Shrink the window if product >= k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // 3. Count valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
```

---

## 🔍 5. Dry Run

**Input:**

```java
nums = [10, 5, 2, 6]
k = 100
```

**Initial Values:**

```text
left = 0
count = 0
product = 1
```

### Iteration 1: right = 0

```text
nums[right] = 10

product = 1 * 10 = 10

product < k
No shrinking required.

count += right - left + 1
count = 0 + 0 - 0 + 1
count = 1
```

Valid subarrays:

```text
[10]
```

### Iteration 2: right = 1

```text
nums[right] = 5

product = 10 * 5 = 50

product < k
No shrinking required.

count += right - left + 1
count = 1 + 1 - 0 + 1
count = 3
```

Valid subarrays:

```text
[10, 5]
[5]
```

### Iteration 3: right = 2

```text
nums[right] = 2

product = 50 * 2 = 100

product >= k
```

Shrink the window:

```text
product = 100 / nums[left]
product = 100 / 10 = 10

left = 1
```

Now:

```text
product = 10 < 100

count += right - left + 1
count = 3 + 2 - 1 + 1
count = 5
```

Valid subarrays:

```text
[5, 2]
[2]
```

### Iteration 4: right = 3

```text
nums[right] = 6

product = 10 * 6 = 60

product < k
No shrinking required.

count += right - left + 1
count = 5 + 3 - 1 + 1
count = 8
```

Valid subarrays:

```text
[5, 2, 6]
[2, 6]
[6]
```

### Final Dry Run Table

| right | nums[right] | Product after shrinking | left | Added Count | Total Count |
|---|---:|---:|---:|---:|---:|
| 0 | 10 | 10 | 0 | 1 | 1 |
| 1 | 5 | 50 | 0 | 2 | 3 |
| 2 | 2 | 10 | 1 | 2 | 5 |
| 3 | 6 | 60 | 1 | 3 | 8 |

**Output:**

```text
8
```

---

## ⭐ 6. Understanding the Important Formula

```java
count += right - left + 1;
```

Take the state at the end of Iteration 4 from the dry run:

```java
nums = [10, 5, 2, 6]

left = 1
right = 3
```

Current window:

```text
[5, 2, 6]
 ^     ^
left   right
```

Valid subarrays ending at `right`:

```text
[6]
[2, 6]
[5, 2, 6]
```

Calculate:

```java
right - left + 1

= 3 - 1 + 1

= 3
```

Therefore, we add `3` to the total count.

**Why does this work?**

Because the current window is valid and all elements are positive. Every suffix of the current window is also valid, since removing elements from the left can only make the product smaller (or equal). The valid subarrays ending at `right` are exactly these suffixes, so each subarray is counted once, at its right end.

---

## ⚠️ 7. Important Edge Cases

### Edge Case 1: k <= 1

```java
if (k <= 1) {
    return 0;
}
```

**Test Case:**

```text
nums = [1, 2, 3]
k = 1

Output = 0
```

Every element is a positive integer, so the smallest possible non-empty subarray product is `1`.

But the condition requires:

```text
product < k
```

Since `1 < 1` is false, no valid subarray exists.

This check also handles `k = 0` and negative `k`. Without it, the `while (product >= k)` loop would keep shrinking past an empty window and `left` would run out of bounds.

### Edge Case 2: A single element is already >= k

```text
nums = [100]
k = 100
```

- `product = 100`, so `product >= k`.
- The `while` loop divides by `nums[0]`, so `product = 1` and `left = 1`.
- The window is now **empty** (`left = right + 1`).
- `count += 0 - 1 + 1 = 0`.

So the window is allowed to become empty, and the formula correctly adds `0`.

### Overflow Note

Given the LeetCode constraints (`nums[i] <= 1000`, `k <= 10^6`), `product` is below `k` before each multiplication, so it never exceeds about `10^6 * 1000 = 10^9`. That fits in a 32-bit `int` (max about `2.1 * 10^9`).

---

## ⏱️ 8. Complexity Analysis

**Time Complexity: O(n)**

- The `right` pointer visits every element once.
- The `left` pointer also moves forward at most `n` times.
- Each element enters and leaves the window at most once.

**Auxiliary Space Complexity: O(1)**

Only a few variables are used. No additional data structure is required.

---

## 🎯 9. Key Concepts

- Variable Size Sliding Window
- Two Pointers
- Product Maintenance
- Counting Valid Subarrays
- Window Expansion and Shrinking

**Important Conditions:**

| Condition | Meaning |
|---|---|
| `product *= nums[right]` | Expand the window |
| `product >= k` | Current window is invalid |
| `product /= nums[left]` | Remove the left element |
| `left++` | Shrink the window |
| `count += right - left + 1` | Count valid subarrays |

---

## 🚫 10. Common Mistakes

- **Only checking subarrays that start at index 0.** Every starting index must be considered. For `nums = [10, 5, 2, 6]`, `k = 100`, checking only prefixes gives `2` instead of `8`.
- **Using `break` when a product reaches `k`.** A large product at one position doesn't make later subarrays invalid. `[5, 2, 6]` is valid even though `[10, 5, 2]` is not.
- **Forgetting the `k <= 1` check.** `left` can run past the end of the array.
- **Using `if` instead of `while` for shrinking.** A single large element can force several elements off the left.

---

## 🎤 11. Interview Questions

**Q1. Which pattern is used in this problem?**

Variable Size Sliding Window.

**Q2. Why do we use `while` instead of `if`?**

Because adding one large element can push the product far above `k`, and we may need to remove several elements from the left before the product becomes strictly less than `k`.

**Q3. Why do we use `right - left + 1`?**

It counts all valid subarrays ending at the current right index.

**Q4. Why do we check `k <= 1`?**

Because all array elements are positive integers, every non-empty subarray has a product of at least `1`. So when `k <= 1`, the condition `product < k` can never be true. This also covers `k = 0` and negative `k`.

**Q5. Why does Sliding Window work here?**

Because all elements are positive. When the window expands, its product cannot decrease; when it shrinks, its product cannot increase.

**Q6. Can this approach work with negative numbers or zeros?**

Not directly. The product's behavior would no longer be monotonic, so this sliding-window technique would not be valid.

**Q7. Is there another approach?**

Yes. Take the logarithm of each element so products become sums (`log(a*b) = log(a) + log(b)`). Build a prefix-sum array and binary search for the farthest valid start for each end. That is O(n log n), and floating-point precision makes it riskier than the sliding window, so the sliding window is preferred.

---

## ✅ 12. Final Revision

| Property | Answer |
|---|---|
| Problem | Subarray Product Less Than K |
| LeetCode | 713 |
| Difficulty | Medium |
| Pattern | Variable Size Sliding Window |
| Data Structure | Array |
| Time Complexity | O(n) |
| Auxiliary Space | O(1) |
| Special Condition | `k <= 1` returns `0` |

**Final Goal:** Understand how to count all valid subarrays using `count += right - left + 1` instead of checking every possible subarray separately.