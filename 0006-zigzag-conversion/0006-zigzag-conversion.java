class Solution {
    public String convert(String s, int numRows) {
        // Handle edge cases
        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }

        // Create an array to hold strings for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string and place characters in the correct row
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Change direction if we are at the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder zigzag = new StringBuilder();
        for (StringBuilder row : rows) {
            zigzag.append(row);
        }

        return zigzag.toString();
    }
}