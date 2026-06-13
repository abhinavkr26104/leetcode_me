class Trie {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    Node root = new Node();

    public void insert(String word) {
        Node cur = root;

        for (char ch : word.toCharArray()) {
            int c = ch - 'a';

            if (cur.child[c] == null)
                cur.child[c] = new Node();

            cur = cur.child[c];
        }

        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = root;

        for (char ch : word.toCharArray()) {
            int c = ch - 'a';

            if (cur.child[c] == null)
                return false;

            cur = cur.child[c];
        }

        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;

        for (char ch : prefix.toCharArray()) {
            int c = ch - 'a';

            if (cur.child[c] == null)
                return false;

            cur = cur.child[c];
        }

        return true;
    }
}