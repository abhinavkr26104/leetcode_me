class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(i, j, 0, board, word))
                    return true;
            }
        }

        return false;
    }

    boolean dfs(int r, int c, int index,
                char[][] board, String word) {

        if (index == word.length())
            return true;

        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            board[r][c] != word.charAt(index))
            return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found =
                dfs(r + 1, c, index + 1, board, word) ||
                dfs(r - 1, c, index + 1, board, word) ||
                dfs(r, c + 1, index + 1, board, word) ||
                dfs(r, c - 1, index + 1, board, word);

        board[r][c] = temp;

        return found;
    }
}