class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int INF = 100000000;
        int[][] dist = new int[n][n];

        // Step 1: Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt; // undirected
        }

        // Step 2: Floyd-Warshall to compute all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 3: Count reachable cities within threshold
        int minReachable = n;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachable++;
                }
            }

            // If tie, prefer higher index city
            if (reachable <= minReachable) {
                minReachable = reachable;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
