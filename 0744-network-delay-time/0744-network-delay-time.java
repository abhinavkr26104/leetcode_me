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
    public int networkDelayTime(int[][] flights, int n, int k) {
        ArrayList<ArrayList<p>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            a.get(flight[0] - 1).add(new p(flight[1] - 1, flight[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        Queue<t> q = new LinkedList<>();
        q.add(new t(0, k - 1, 0));

        while (!q.isEmpty()) {
            t curr = q.poll();
            for (p neighbor : a.get(curr.node)) {
                if (curr.cost + neighbor.cost < dist[neighbor.dest]) {
                    dist[neighbor.dest] = curr.cost + neighbor.cost;
                    q.add(new t(curr.stops + 1, neighbor.dest, dist[neighbor.dest]));
                }
            }
        }

        int max = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1;
            max = Math.max(max, d);
        }
        return max;
    }
}
