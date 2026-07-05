# 852. Peak Index in a Mountain Array

## Intuition

A mountain array first increases and then decreases. The peak element is the point where this change happens.

Using Binary Search, we can determine whether the middle element is on the increasing side or the decreasing side of the mountain and move our search accordingly.

## Approach

1. Initialize two pointers:
   - `left = 0`
   - `right = arr.length - 1`
2. Find the middle index `mid`.
3. If `arr[mid] < arr[mid + 1]`, the peak lies on the right, so move `left = mid + 1`.
4. Otherwise, the peak is at `mid` or on the left, so move `right = mid`.
5. Continue until `left == right`.
6. Return `left`, which is the index of the peak element.

## Complexity

- **Time Complexity:** O(log n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 852-Peak-Index-in-a-Mountain-Array.java
```