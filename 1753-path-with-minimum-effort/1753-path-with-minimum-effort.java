class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0}); // row, col, effort so far

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], effort = curr[2];

            if (r == n - 1 && c == m - 1) return effort;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int maxEffort = Math.max(effort, diff);
                    if (maxEffort < dist[nr][nc]) {
                        dist[nr][nc] = maxEffort;
                        pq.add(new int[]{nr, nc, maxEffort});
                    }
                }
            }
        }

        return -1;
    }
}
