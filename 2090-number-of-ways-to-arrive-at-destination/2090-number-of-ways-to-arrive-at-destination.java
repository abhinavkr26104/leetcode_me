import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], wt = road[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        int[] dist = new int[n];
        int[] ways = new int[n];
        int mod = (int)1e9 + 7;

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        pq.add(new int[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dis = cur[0];
            int node = cur[1];

            // ✅ Key fix: don't process outdated entries
            if (dis > dist[node]) continue;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edW = it[1];

                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new int[]{dist[adjNode], adjNode});
                    ways[adjNode] = ways[node];
                } else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
