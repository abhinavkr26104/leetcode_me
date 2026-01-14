class Solution {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Find an empty cell
                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recurse
                            if (backtrack(board)) {
                                return true;
                            }

                            // Undo (backtrack)
                            board[row][col] = '.';
                        }
                    }

                    // No valid number → trigger backtracking
                    return false;
                }
            }
        }

        // No empty cells left → solved
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == num) return false;

            // Check column
            if (board[i][col] == num) return false;

            // Check 3×3 sub-box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }

        return true;
    }
}
