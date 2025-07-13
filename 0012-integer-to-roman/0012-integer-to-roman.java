class Solution {
      public String intToRoman(int num) {
        // Define the Roman numerals and their corresponding integer values
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder result = new StringBuilder();
        
        // Iterate over the values and symbols
        for (int i = 0; i < romanValues.length; i++) {
            // While num is greater than or equal to the current Roman value
            while (num >= romanValues[i]) {
                result.append(romanSymbols[i]); // Append the Roman symbol
                num -= romanValues[i]; // Subtract the value from num
            }
        }
        
        return result.toString(); // Convert StringBuilder to String and return
    }
}