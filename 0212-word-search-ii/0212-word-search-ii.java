class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {

            TrieNode cur = root;

            for (char ch : word.toCharArray()) {

                int idx = ch - 'a';

                if (cur.child[idx] == null)
                    cur.child[idx] = new TrieNode();

                cur = cur.child[idx];
            }

            cur.word = word;
        }

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root);

        return ans;
    }

    void dfs(char[][] board, int r, int c, TrieNode node) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;

        char ch = board[r][c];

        if (ch == '#')
            return;

        node = node.child[ch - 'a'];

        if (node == null)
            return;

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        board[r][c] = ch;
    }
}