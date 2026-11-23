# 881. Boats to Save People

**Difficulty:** Medium

**Topic:** Array, Greedy, Two Pointers, Sorting

## 🧠 Problem Understanding

You are given an integer array `people`, where `people[i]` represents the weight of the ith person.

Each boat can carry at most two people at the same time, and the total weight of those people must not exceed `limit`.

Return the minimum number of boats required to carry every person.

## Example 1

**Input:**
```text
people = [1,2]
limit = 3
```

**Output:**
```text
1
```

**Explanation:**

Both people can travel in one boat because their combined weight is 1 + 2 = 3.

## Example 2

**Input:**
```text
people = [3,2,2,1]
limit = 3
```

**Output:**
```text
3
```

**Explanation:**

- Boat 1: (1,2)
- Boat 2: (2)
- Boat 3: (3)

Minimum boats required = 3.

---

## Approach: Greedy + Two Pointers

### Intuition

We need to minimize the number of boats.

The heaviest person should always get a boat. We try to pair this person with the lightest person.

- `left`: Points to the lightest person.
- `right`: Points to the heaviest person.

If their combined weight is less than or equal to `limit`, both can share one boat.

Otherwise, the heaviest person travels alone.

### Why Greedy Works

- If the heaviest person cannot share a boat with the lightest person, they cannot share with anyone, so they must travel alone.
- If they can share with the lightest person, that pairing uses up the least capacity, leaving the other people with the best chances to pair among themselves.

### Steps

1. Sort the `people` array in ascending order.
2. Initialize `left = 0` to point to the lightest person.
3. Initialize `right = people.length - 1` to point to the heaviest person.
4. Initialize `boats = 0`.
5. Run a loop while `left <= right`.
6. Check whether `people[left] + people[right] <= limit`.
   - If true, increment `left` because both people can share one boat.
   - Otherwise, do not increment `left` because the lightest person is still waiting.
7. Always decrement `right` because the heaviest person gets a boat.
8. Increment `boats` in every iteration.
9. Return the total number of boats.

### Java Code

```java
import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

            if (people[left] + people[right] <= limit) {

                // Both people can share one boat
                left++;
            }

            // Heaviest person always gets a boat
            right--;

            boats++;
        }

        return boats;
    }
}
```

---

## Dry Run

**Input:**
```text
people = [3,2,2,1]
limit = 3
```

**After Sorting:**
```text
people = [1,2,2,3]
```

**Initial Values:**
```text
left = 0
right = 3
boats = 0
```

| Step | left (weight) | right (weight) | Condition | Operation | Pointers After | Boats |
|---|---|---|---|---|---|---:|
| 1 | 0 (1) | 3 (3) | 1 + 3 > 3 | 3 travels alone | left=0, right=2 | 1 |
| 2 | 0 (1) | 2 (2) | 1 + 2 <= 3 | Both travel together | left=1, right=1 | 2 |
| 3 | 1 (2) | 1 (2) | `left == right` | Same person, travels alone | left=1, right=0 | 3 |

The loop ends because `left > right`.

**Final Output:**
```text
3
```

---

## Complexity Analysis

- **Time Complexity:** O(n log n) – Sorting the array takes O(n log n), and the two-pointer traversal takes O(n).
- **Space Complexity:** O(1) auxiliary space, excluding the sorting implementation's internal space (O(log n) for Java's dual-pivot quicksort on primitives).

## Key Concepts

- Greedy Algorithm
- Two Pointers
- Array Sorting
- Pairing Elements
- Minimum Number of Boats

## Interview Note

The Greedy approach always assigns a boat to the heaviest remaining person.

We try to pair that person with the lightest remaining person whenever their combined weight does not exceed the given limit.

The `right` pointer always moves left, since the heaviest person always boards. The `left` pointer moves right only when the lightest person can share that boat.

**Recommended Approach: Greedy + Sorting + Two Pointers.**