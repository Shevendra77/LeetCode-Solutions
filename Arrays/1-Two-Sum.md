# 1. Two Sum

## Intuition

For every element, we need another element such that their sum equals the target.

Instead of checking every pair, we store the numbers we have already visited in a HashMap. For each current number, we calculate its required complement (`target - nums[i]`). If the complement already exists in the HashMap, we have found the answer.

## Approach

### HashMap (One Pass)

1. Create an empty `HashMap`.
2. Traverse the array.
3. Calculate the complement:

   ```
   complement = target - nums[i]
   ```

4. Check if the complement exists in the HashMap.
5. If it exists, return the stored index and the current index.
6. Otherwise, store the current number and its index in the HashMap.
7. Continue until the pair is found.

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

## Java Code

```java
// Solution is available in 0001-Two-Sum.java
```

---

## Approach 1: Brute Force

### Idea

Check every possible pair of numbers. If their sum equals the target, return their indices.

### Algorithm

1. Traverse the array using two loops.
2. For every pair `(i, j)`:
   - Check if `nums[i] + nums[j] == target`.
3. Return the indices when found.

### Complexity

**Time:** `O(n²)`

**Space:** `O(1)`

---

## Approach 2: Two-Pass HashMap (Better ⭐⭐)

### Idea

First, store every number with its index in a HashMap.

Then, traverse the array again and search for the complement in the HashMap.

### Algorithm

1. Create a HashMap.
2. Store all numbers with their indices.
3. Traverse the array again.
4. Calculate the complement.
5. If the complement exists and is not the current index:
   - Return both indices.

### Complexity

**Time:** `O(n)`

**Space:** `O(n)`

---

## Approach 3: One-Pass HashMap (Optimal ⭐⭐⭐)

### Idea

Traverse the array only once.

Before storing the current number, check whether its complement has already been seen.

If yes, return the answer immediately.

### Algorithm

1. Create an empty HashMap.
2. Traverse the array.
3. Compute:

   ```
   complement = target - nums[i]
   ```

4. If the complement exists:
   - Return `[map.get(complement), i]`.
5. Otherwise:
   - Store the current number and its index.
6. Continue until the answer is found.

### Complexity

**Time:** `O(n)`

**Space:** `O(n)`

---

## Formula

```
complement = target - nums[i]
```

If the complement already exists in the HashMap, then:

```
nums[i] + complement = target
```

---

## Best Approach

✔ Brute Force      → `O(n²)`, `O(1)`

✔ Two-Pass HashMap → `O(n)`, `O(n)`

✔ One-Pass HashMap → `O(n)`, `O(n)` ⭐⭐⭐

---

## Topics

- Array
- Hash Table

## Data Structure Used

- HashMap

## Key Takeaways

- Store **number → index** in a HashMap.
- Calculate the complement for each element.
- Check whether the complement already exists.
- One-pass HashMap is the most efficient solution.
- Average HashMap lookup takes **O(1)** time.