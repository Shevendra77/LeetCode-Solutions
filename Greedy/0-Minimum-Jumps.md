# Minimum Jumps

## Intuition

Each element in the array represents the maximum number of steps we can jump forward from that position.

Using the **Greedy Algorithm**, we track the farthest reachable index and the boundary of the current jump. Whenever we reach the current boundary, we increase the jump count and extend the boundary.

If we cannot move forward or reach the last index, return `-1`.

## Approach

1. Initialize `n = arr.length`.
2. If `n == 1`, return `0` because we are already at the destination.
3. If `arr[0] == 0`, return `-1` because we cannot move forward.
4. Initialize three variables:
   - `max = 0`
   - `choice = 0`
   - `jumps = 0`
5. Traverse the array from index `0` to `n - 2`:
   - Update the farthest reachable index using `max = Math.max(max, i + arr[i])`.
   - If `i == choice`, we have reached the current jump boundary.
   - If `max <= i`, return `-1` because we cannot move forward.
   - Update `choice = max` and increment `jumps`.
   - If `choice >= n - 1`, return `jumps`.
6. If the last index cannot be reached, return `-1`.

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

## Java Code

```java
// Solution is available in Minimum-Jumps.java
```