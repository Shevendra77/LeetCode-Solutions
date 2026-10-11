# Missing Number

## Intuition

The array contains numbers from `1` to `n`, but one number is missing.

We can calculate the expected sum of numbers from `1` to `n` using the formula `n * (n + 1) / 2`. Then subtract the actual sum of array elements from the expected sum to find the missing number.

We use `long` instead of `int` to avoid integer overflow when calculating the sum of large numbers.

## Approach

1. Calculate `n = arr.length + 1`.
2. Calculate the expected sum using `n * (n + 1) / 2`.
3. Initialize `actualSum = 0`.
4. Traverse the array and add each element to `actualSum`.
5. Calculate the missing number using `expectedSum - actualSum`.
6. Return the missing number.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in Missing-Number.java
```