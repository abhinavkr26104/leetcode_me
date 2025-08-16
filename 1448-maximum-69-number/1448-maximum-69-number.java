class Solution {
    public int maximum69Number (int num) {
        // Convert number to a char array
        char[] digits = String.valueOf(num).toCharArray();
        
        // Traverse from left to right and replace the first '6' with '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // only change once
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }
}
