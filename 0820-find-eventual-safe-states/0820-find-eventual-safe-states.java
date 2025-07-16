import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reversedGraph.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;

            for (int neighbor : reversedGraph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }
}
