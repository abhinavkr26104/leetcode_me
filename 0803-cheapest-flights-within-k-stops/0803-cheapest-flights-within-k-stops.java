import java.util.*;

class p {
    int dest;
    int cost;
    public p(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

class t {
    int stops;
    int node;
    int cost;
    public t(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<p>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            a.get(flight[0]).add(new p(flight[1], flight[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<t> q = new LinkedList<>();
        q.add(new t(0, src, 0));

        while (!q.isEmpty()) {
            t current = q.poll();
            int stops = current.stops;
            int node = current.node;
            int cost = current.cost;

            if (stops > k) continue;

            for (p neighbor : a.get(node)) {
                if (cost + neighbor.cost < dist[neighbor.dest]) {
                    dist[neighbor.dest] = cost + neighbor.cost;
                    q.add(new t(stops + 1, neighbor.dest, cost + neighbor.cost));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
