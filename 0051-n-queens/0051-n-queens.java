class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');
        dfs(0, board);

        return ans;
    }

    void dfs(int row, char[][] board) {

        if (row == board.length) {

            List<String> temp = new ArrayList<>();

            for (char[] r : board)
                temp.add(new String(r));

            ans.add(temp);

            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                dfs(row + 1, board);

                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col) {

        // Same column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Upper Left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Upper Right Diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}