# 443. String Compression

**Difficulty:** Medium
**Language:** Java
**Pattern:** Array + Two Pointers

## Approach

### Two Pointers / Run-Length Encoding

We traverse the array and group consecutive identical characters. For each group, we store the character and its count directly into the same array.

## Algorithm

1. Initialize `index = 0` to store the compressed result.
2. Traverse the array using pointer `i`.
3. Store the current character in `ch` and initialize `count = 0`.
4. Since `ch` is taken from `chars[i]`, the `while` loop will execute at least once. Therefore, `count` will always become at least `1`; it will never remain `0`.
5. Use the `while` loop to count all consecutive occurrences of `ch`.
6. Store `ch` at `chars[index]` and increment `index`.
7. If `count == 1`, store only the character.
8. If `count > 1`, convert the count into a `String` using `String.valueOf(count)`.
9. Convert the count string into a character array and store each digit in `chars`.
10. Decrease `i` by `1` because the `while` loop has already moved `i` one position ahead.
11. Repeat the process until all character groups are processed.
12. Return `index`, which represents the compressed array length.

## Example

### Input

```text
chars = ["a","a","b","b","c","c","c"]
```

### Processing

```text
"a" → count = 2 → store "a2"
"b" → count = 2 → store "b2"
"c" → count = 3 → store "c3"
```

### Compressed Array

```text
["a","2","b","2","c","3"]
```

### Output

```text
6
```

## Java Code

```java
class Solution {
    public int compress(char[] chars) {

        int index = 0;

        for (int i = 0; i < chars.length; i++) {

            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

            if (count == 1) {
                chars[index++] = ch;
            } else {
                chars[index++] = ch;

                String str = String.valueOf(count);

                for (char digit : str.toCharArray()) {
                    chars[index++] = digit;
                }
            }

            i--;
        }

        return index;
    }
}
```

## Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)` auxiliary space

## Key Concepts

* Two Pointers
* Array Traversal
* Run-Length Encoding
* In-place Modification
* Character Counting

## Useful Java Methods

### Convert `int` to `String`

```java
String.valueOf(count);
```

Example:

```text
12 → "12"
```

### Convert `String` to `char[]`

```java
str.toCharArray();
```

Example:

```text
"12" → ['1', '2']
```

## Notes

`count` is initialized to `0`, but it never remains `0` because `ch` is always the current character `chars[i]`. Therefore, the first iteration of the `while` loop increments `count` to `1`.

The `i--` is required because the `while` loop increments `i` one position beyond the current character group.

## LeetCode

[443. String Compression](https://leetcode.com/problems/string-compression/)
