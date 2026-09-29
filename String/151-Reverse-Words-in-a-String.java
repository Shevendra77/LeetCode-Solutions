class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip extra spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // Find the beginning of the current word
            int j = i;

            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Append the current word
            ans.append(s.substring(j + 1, i + 1));

            // Skip spaces before the next word
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            // Add a single space between words
            if (j >= 0) {
                ans.append(' ');
            }

            // Move to the next word
            i = j;
        }

        return ans.toString();
    }
}