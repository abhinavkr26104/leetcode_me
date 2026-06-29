class Solution {

    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    boolean dfs(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isValid(board, row, col, ch)) {

                            board[row][col] = ch;

                            if (dfs(board))
                                return true;

                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            // Row
            if (board[row][i] == ch)
                return false;

            // Column
            if (board[i][col] == ch)
                return false;

            // 3×3 Box
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == ch)
                return false;
        }

        return true;
    }
}