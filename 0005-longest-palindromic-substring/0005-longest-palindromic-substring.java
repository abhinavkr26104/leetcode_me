class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // Preprocess the string to add boundaries for even-length palindromes
        StringBuilder t = new StringBuilder();
        t.append('#');
        for (char c : s.toCharArray()) {
            t.append(c).append('#');
        }

        String modifiedString = t.toString();
        int n = modifiedString.length();
        int[] p = new int[n]; // Array to store the radius of the palindrome at each center
        int center = 0, right = 0;
        int maxLen = 0, start = 0;

        for (int i = 0; i < n; i++) {
            // Mirror index around the center
            int mirror = 2 * center - i;

            // Initialize p[i] with the minimum of its mirror or the remaining boundary
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Attempt to expand around the current center
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n
                    && modifiedString.charAt(i - p[i] - 1) == modifiedString.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            // Update the center and right boundary if the palindrome expands past the right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Update the maximum length and starting index of the original string
            if (p[i] > maxLen) {
                maxLen = p[i];
                start = (i - maxLen) / 2; // Convert back to original string indices
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, start + maxLen);
    }
}
