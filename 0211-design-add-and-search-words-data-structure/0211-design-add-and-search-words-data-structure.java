class WordDictionary {

    int[][] trie = new int[250001][26];
    boolean[] end = new boolean[250001];
    int nodes = 0;

    public WordDictionary() {
    }

    public void addWord(String word) {
        int node = 0;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            if (trie[node][c] == 0)
                trie[node][c] = ++nodes;

            node = trie[node][c];
        }

        end[node] = true;
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, 0);
    }

    boolean dfs(char[] word, int idx, int node) {
        for (int i = idx; i < word.length; i++) {

            if (word[i] == '.') {

                for (int c = 0; c < 26; c++) {
                    int nxt = trie[node][c];

                    if (nxt != 0 && dfs(word, i + 1, nxt))
                        return true;
                }

                return false;
            }

            int nxt = trie[node][word[i] - 'a'];

            if (nxt == 0)
                return false;

            node = nxt;
        }

        return end[node];
    }
}