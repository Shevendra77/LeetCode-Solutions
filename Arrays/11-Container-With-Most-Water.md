# 11. Container With Most Water

## Intuition

The amount of water a container can hold depends on two factors:

- The distance between the two lines (width).
- The height of the shorter line.

The area is calculated as:

`Area = Width × min(height[left], height[right])`

We start with the widest possible container and use two pointers. After calculating the current area, we move the pointer with the smaller height because moving the taller line cannot increase the area.

## Approach

1. Initialize two pointers:
   - `left = 0`
   - `right = height.length - 1`
2. Calculate the width as `right - left`.
3. Find the smaller height using `Math.min()`.
4. Calculate the current area.
5. Update the maximum area if the current area is larger.
6. Move the pointer with the smaller height:
   - If `height[left] < height[right]`, increment `left`.
   - Otherwise, decrement `right`.
7. Repeat until `left < right`.
8. Return the maximum area.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 11-Container-With-Most-Water.java
```