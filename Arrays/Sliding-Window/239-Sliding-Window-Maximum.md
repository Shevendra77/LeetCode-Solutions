# 239. Sliding Window Maximum

## Intuition

A brute-force approach finds the maximum element for every window, which takes **O(n × k)** time.

To optimize this, we use a **Monotonic Queue (Deque)**.

The deque stores **indices** of useful elements in **decreasing order of their values**. The front of the deque always contains the index of the maximum element for the current window.

As the window slides:

- Remove indices that are outside the current window.
- Remove smaller elements from the back since they can never become the maximum.
- Add the current index.
- Once the first window is formed, record the maximum.

---

## Approach

1. Create a deque to store indices.
2. Traverse the array.
3. Remove indices that are outside the current window.
4. Remove all smaller elements from the back of the deque.
5. Add the current index to the deque.
6. Once the window size becomes `k`, store the maximum element (`nums[deque.peekFirst()]`).
7. Return the result array.

---

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(k)

---

## Java Code

```java
// Solution is available in 239-Sliding-Window-Maximum.java
```