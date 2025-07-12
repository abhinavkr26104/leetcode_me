class Solution {
    public int reverse(int x) {
        long reversed = 0; // Use long to handle overflow

        while (x != 0) {
            int digit = x % 10; // Get the last digit
            reversed = reversed * 10 + digit; // Build the reversed number
            x /= 10; // Remove the last digit from x

            // Check for overflow
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0; // Return 0 if overflow occurs
            }
        }

        return (int) reversed; // Cast back to int before returning
    }
}
