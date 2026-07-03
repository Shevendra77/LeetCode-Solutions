# 238. Product of Array Except Self

## Intuition

Division is not allowed, so we cannot calculate the total product and divide it by the current element.

Instead, for each index, we calculate:
- The product of all elements to its left.
- The product of all elements to its right.

Multiplying these two products gives the answer for that index.

## Approach

1. Create an answer array of size `n`.
2. Store the prefix product in the answer array.
   - `ans[i]` contains the product of all elements before index `i`.
3. Traverse the array from right to left while maintaining a `suffix` product.
4. Multiply `ans[i]` by the current `suffix`.
5. Update the `suffix` by multiplying it with `nums[i]`.
6. Return the answer array.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1) *(excluding the output array)*

## Java Code

```java
// Solution is available in 238-Product-of-Array-Except-Self.java
```