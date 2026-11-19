# 169. Majority Element

**Difficulty:** Easy

**Topic:** Hashing, Boyer-Moore Voting Algorithm

## 🧠 Problem Understanding

Given an array `nums`, find the element that appears more than `n / 2` times.

A majority element appears strictly more than half the size of the array.

**Example:**

```java
nums = [2, 2, 1, 1, 1, 2, 2]
Output = 2
```

Array size = 7

Majority condition: Frequency > 7 / 2 = 3

Element `2` appears 4 times, so the answer is `2`.

---

## Approach 1: HashMap – Frequency Counting

### 🔍 Intuition

Use a HashMap to store each element and its frequency.

- Key = Array element
- Value = Frequency of that element

Whenever an element appears, increase its frequency by 1. If its frequency becomes greater than `n / 2`, return it.

### 💻 Java Code

```java
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int num : nums) {

            // Count frequency
            int freq = map.getOrDefault(num, 0) + 1;

            map.put(num, freq);

            // Check majority element
            if (freq > n / 2) {
                return num;
            }
        }

        return -1;
    }
}
```

### 📊 Algorithm

1. Create a HashMap.
2. Traverse the array.
3. Count the frequency of each element using `getOrDefault()`.
4. Update the frequency in the HashMap.
5. Check whether the frequency is greater than `n / 2`.
6. If true, return the element.
7. Otherwise, return `-1`.

### ⏱️ Complexity

- **Time:** O(N) average
- **Space:** O(N)

---

## Approach 2: Boyer-Moore Voting Algorithm

### 🔍 Intuition

The main idea is **cancellation**.

Since the majority element appears more than `n / 2` times, it occurs more often than all other elements combined.

We maintain two variables:

- `candidate` = Possible majority element.
- `count` = Current vote count.

**Rules:**

1. If `count == 0`, select the current element as the candidate.
2. If the current element equals the candidate, increase `count`.
3. Otherwise, decrease `count`.

At the end, the candidate is the majority element because the problem guarantees that one exists.

### 💻 Java Code

```java
class Solution {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            // Select a new candidate
            if (count == 0) {
                candidate = num;
            }

            // Increase or decrease votes
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
```

### 📊 Dry Run

**Input:**

```java
nums = [2, 2, 1, 1, 1, 2, 2]
```

| num | Candidate | Count | Action |
|---:|---:|---:|---|
| 2 | 2 | 1 | Select candidate, increase |
| 2 | 2 | 2 | Same candidate, increase |
| 1 | 2 | 1 | Different element, decrease |
| 1 | 2 | 0 | Different element, decrease |
| 1 | 1 | 1 | New candidate, increase |
| 2 | 1 | 0 | Different element, decrease |
| 2 | 2 | 1 | New candidate, increase |

**Final candidate = 2**

**Output: `2`**

### ⏱️ Complexity

- **Time:** O(N) – One traversal of the array.
- **Space:** O(1) – Only two variables are used.

---

## ⚖️ Comparison

| Feature | HashMap | Boyer-Moore |
|---|---|---|
| Technique | Frequency counting | Voting / Cancellation |
| Time | O(N) average | O(N) |
| Space | O(N) | O(1) |
| Extra data structure | HashMap | None |
| Traversal | One | One |
| Optimal space | No | Yes |

## ⭐ Important Interview Points

- HashMap stores the frequency of every distinct element.
- `getOrDefault(num, 0) + 1` increases the frequency.
- Boyer-Moore uses the cancellation concept.
- The majority element is guaranteed to exist in this problem, so we do not need a final verification pass.

**Pattern:** Hashing → Frequency Counting | Array → Boyer-Moore Voting Algorithm