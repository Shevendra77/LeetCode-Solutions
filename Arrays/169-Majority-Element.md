# LeetCode 169 — Majority Element

## Problem

Return the element that appears more than `n / 2` times. The majority element is guaranteed to exist.

**Example:**

- Input: `nums = [2,2,1,1,1,2,2]`
- Output: `2`

---

## Approach 1: Brute Force

**Intuition:** Count the occurrences of every element and return the one whose frequency exceeds `n / 2`.

**Algorithm:**

1. Traverse each element.
2. Count its occurrences using a nested loop.
3. If `count > n / 2`, return the element.

**Complexity:**

- Time: `O(n²)`
- Auxiliary Space: `O(1)`

---

## Approach 2: Sorting

**Intuition:** After sorting, the majority element must occupy the middle index.

**Algorithm:**

1. Sort the array.
2. Return `nums[n / 2]`.

**Complexity:**

- Time: `O(n log n)`
- Auxiliary Space: Depends on the sorting implementation.

---

## Approach 3: HashMap

**Intuition:** Store each element's frequency in a HashMap.

**Algorithm:**

1. Create a HashMap.
2. Increase the frequency of each element.
3. Return the element when its frequency exceeds `n / 2`.

**Complexity:**

- Time: `O(n)` average
- Auxiliary Space: `O(n)`

---

## Approach 4: Boyer–Moore Voting Algorithm

**Intuition:** Different elements cancel each other out. Since the majority element appears more than half the time, it remains the final candidate.

**Algorithm:**

1. Initialize `candidate` and `count`.
2. If `count == 0`, select the current element as the candidate.
3. If the current element equals the candidate, increment `count`.
4. Otherwise, decrement `count`.
5. Return the candidate.

**Complexity:**

- Time: `O(n)`
- Auxiliary Space: `O(1)`

---

## Pattern

Array + Counting + Candidate Elimination

## Best Approach

Boyer–Moore Voting Algorithm is optimal for this problem because it uses `O(n)` time and `O(1)` auxiliary space.