class WordDictionary {

    int[][] trie = new int[250001][26];
boolean[] end = new boolean[250001];
    int nodes = 0;

    public WordDictionary() {
    }

    public void addWord(String word) {
        int node = 0;

        for (char ch : word.toCharArray()) {
            int c = ch - 'a';

            if (trie[node][c] == 0)
                trie[node][c] = ++nodes;

            node = trie[node][c];
        }

        end[node] = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, 0);
    }

    boolean dfs(String word, int idx, int node) {
        if (idx == word.length())
            return end[node];

        char ch = word.charAt(idx);

        if (ch != '.') {
            int nxt = trie[node][ch - 'a'];

            if (nxt == 0)
                return false;

            return dfs(word, idx + 1, nxt);
        }

        for (int c = 0; c < 26; c++) {
            int nxt = trie[node][c];

            if (nxt != 0 && dfs(word, idx + 1, nxt))
                return true;
        }

        return false;
    }
}