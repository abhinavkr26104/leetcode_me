class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, graph, distance);
        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, graph, distance, path, result);
        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet,
                     Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int currDist = distance.get(word);

                for (String neighbor : getNeighbors(word, wordSet)) {
                    graph.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(word);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDist + 1);
                        if (neighbor.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (foundEnd) break;
        }
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> graph,
                     Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(word);
        if (word.equals(beginWord)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            result.add(validPath);
        } else {
            for (String prev : graph.getOrDefault(word, new ArrayList<>())) {
                if (distance.get(word) == distance.get(prev) + 1) {
                    dfs(prev, beginWord, graph, distance, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
}
