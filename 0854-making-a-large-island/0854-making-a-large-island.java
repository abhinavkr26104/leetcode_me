class Solution {
    class DisjointSet {
        int[] parent, size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findPar(int node) {
            if (parent[node] != node) {
                parent[node] = findPar(parent[node]);
            }
            return parent[node];
        }

        void unionBySize(int u, int v) {
            int pu = findPar(u);
            int pv = findPar(v);
            if (pu == pv) return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }

        int getSize(int node) {
            return size[findPar(node)];
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // Step 1: Union all 1s
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int node = row * n + col;
                    for (int[] d : dirs) {
                        int r = row + d[0], c = col + d[1];
                        if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1) {
                            int adj = r * n + c;
                            ds.unionBySize(node, adj);
                        }
                    }
                }
            }
        }

        // Step 2: Try flipping each 0 to 1 and calculate the combined island size
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    Set<Integer> uniqueParents = new HashSet<>();
                    for (int[] d : dirs) {
                        int r = row + d[0], c = col + d[1];
                        if (r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 1) {
                            uniqueParents.add(ds.findPar(r * n + c));
                        }
                    }
                    int totalSize = 1; // the flipped 0
                    for (int p : uniqueParents) {
                        totalSize += ds.size[p];
                    }
                    max = Math.max(max, totalSize);
                }
            }
        }

        // Edge case: all 1s, no 0 to flip
        for (int i = 0; i < n * n; i++) {
            max = Math.max(max, ds.size[ds.findPar(i)]);
        }

        return max;
    }
}
