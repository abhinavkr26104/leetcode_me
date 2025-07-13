class Solution {
    public boolean isPalindrome(int x) {
        // Step 1: Check for negative numbers and numbers ending with 0 (except 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Step 2: Reverse the last half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10; // Remove the last digit
        }

        // Step 3: Compare the two halves
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
