# 344. Reverse String

## Intuition

Use two pointers, `left` and `right`, to reverse the character array in place. Swap the characters at both pointers and move them toward the center until they meet.

## Approach

1. Initialize `left = 0` and `right = s.length - 1`.
2. Run a loop while `left < right`.
3. Swap `s[left]` and `s[right]` using a temporary variable.
4. Increment `left` and decrement `right`.
5. Stop when both pointers meet or cross.

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

## Java Code

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
         
        while(left < right)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        
    }
}
```