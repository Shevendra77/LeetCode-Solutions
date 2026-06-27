# 217. Contains Duplicate

## Intuition

Use a HashSet to store visited elements. If an element is already present in the HashSet, it means a duplicate exists.

## Approach

1. Create a HashSet.
2. Traverse the array.
3. If the current element exists in the HashSet, return true.
4. Otherwise, add it to the HashSet.
5. If no duplicates are found, return false.

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(n)

## Java Code

```java
// Solution is available in 217-Contains-Duplicate.java
```
