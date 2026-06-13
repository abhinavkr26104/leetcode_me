class Trie {

    Set<String> set = new HashSet<>();

    public Trie() {
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s : set) {
            if (s.startsWith(prefix))
                return true;
        }
        return false;
    }
}