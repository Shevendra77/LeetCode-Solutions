# 560. Subarray Sum Equals K

## Intuition

A brute-force approach checks every possible subarray, resulting in **O(n²)** time.

To optimize this, we use a **Prefix Sum + HashMap**.

Let `prefixSum` be the sum of elements from the beginning of the array to the current index.

If:

`currentPrefixSum - previousPrefixSum = k`

then:

`previousPrefixSum = currentPrefixSum - k`

If `(currentPrefixSum - k)` has appeared before, then a subarray with sum `k` exists. A HashMap stores the frequency of each prefix sum, allowing us to count such subarrays in **O(1)** time.

## Approach

1. Create a `HashMap` to store the frequency of prefix sums.
2. Initialize the map with `(0, 1)` because a subarray can start from index `0`.
3. Maintain a running `prefixSum`.
4. Traverse the array:
   - Add the current element to `prefixSum`.
   - If `(prefixSum - k)` exists in the map, add its frequency to the answer.
   - Store/update the current `prefixSum` in the map.
5. Return the total count.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

## Java Code

```java
// Solution is available in 560-Subarray-Sum-Equals-K.java
```