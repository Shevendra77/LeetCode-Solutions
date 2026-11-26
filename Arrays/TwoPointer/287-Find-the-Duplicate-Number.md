# 287. Find the Duplicate Number

## Intuition

The array contains `n + 1` numbers, but every value is in the range `[1, n]`. Since there are more numbers than possible values, at least one number must be repeated.

Instead of modifying the array or using extra space, we can treat the array as a **linked list**:

- Index → Current node
- Value → Next node

A duplicate number creates a **cycle** in this linked list.

Using **Floyd's Cycle Detection Algorithm (Tortoise and Hare)**, we can find the starting point of the cycle, which is the duplicate number.

---

## Approach

1. Initialize two pointers:
   - `slow = nums[0]`
   - `fast = nums[0]`
2. Move:
   - `slow` one step at a time.
   - `fast` two steps at a time.
3. Continue until both pointers meet.
4. Reset `slow` to `nums[0]`.
5. Move both pointers one step at a time.
6. The point where they meet again is the duplicate number.
7. Return that number.

---

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Java Code

```java
// Solution is available in 287-Find-the-Duplicate-Number.java
```