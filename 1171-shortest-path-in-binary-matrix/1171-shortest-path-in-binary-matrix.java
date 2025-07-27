class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

     
        if (grid[0][0] != 0 || grid[n-1][m-1] != 0) return -1;

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, (int)1e9);
        dist[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if (r == n - 1 && c == m - 1) return d;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m 
                    && grid[nr][nc] == 0 && d + 1 < dist[nr][nc]) 
                    {
                         if (nr == n - 1 && nc == m - 1) return d+1;
                    dist[nr][nc] = d + 1;
                    q.add(new int[]{nr, nc, d + 1});
                }
            }
        }

        return -1;
    }
}
