class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        int[] queens = new int[n]; // queens[row] = column
        placeQueen(0, n, queens);
        return count;
    }

    private void placeQueen(int row, int n, int[] queens) {

        // All rows filled → one valid solution
        if (row == n) {
            count++;
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;
                placeQueen(row + 1, n, queens);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] queens) {

        // Check against previous rows
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];

            // Same column
            if (prevCol == col) return false;

            // Same diagonal
            if (Math.abs(prevCol - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }

        return true;
    }
}
