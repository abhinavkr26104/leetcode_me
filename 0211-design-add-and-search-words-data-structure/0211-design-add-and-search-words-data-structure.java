class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.charMap[index] == null) {
                curr.charMap[index] = new TrieNode();
            }
            curr = curr.charMap[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), root, 0);
    }
    
    private boolean search(char[] word, TrieNode node, int index) {
        for (int i = index; i < word.length; i++) {
            char c = word[i];
            if (c == '.') {
                // wild card, continue to next for all possible chars
                for (TrieNode next : node.charMap) {
                    if (next == null) {
                        // no word exists at this node, skip
                        continue;
                    }
                    
                    if (search(word, next, i + 1)) {
                        return true;
                    }
                }
                
                return false;
            }
            
            // c is lower case English letter
            int j = c - 'a';
            if (node.charMap[j] == null) {
                return false;
            }
            
            node = node.charMap[j];
        }
        
        return node.isWord;
    }

    private static class TrieNode {
        TrieNode[] charMap;
        boolean isWord;

        TrieNode() {
            this.charMap = new TrieNode[26];
            this.isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */