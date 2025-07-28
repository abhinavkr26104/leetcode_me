import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); 
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;
        
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int) top[1];
            
            if (d > dist[u]) continue;
            
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                long newDist = d + w;
                
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}