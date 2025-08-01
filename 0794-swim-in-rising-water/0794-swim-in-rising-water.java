import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findPar(int node) {
        if (parent.get(node) != node) {
            parent.set(node, findPar(parent.get(node)));
        }
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);
        if (pu == pv) return;
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        List<int[]> cells = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{grid[i][j], i, j});

        Collections.sort(cells, Comparator.comparingInt(a -> a[0]));

        DisjointSet dsu = new DisjointSet(n * n);
        boolean[][] visited = new boolean[n][n];

        for (int[] cell : cells) {
            int val = cell[0], x = cell[1], y = cell[2];
            visited[x][y] = true;
            int id = x * n + y;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny]) {
                    int nid = nx * n + ny;
                    dsu.unionByRank(id, nid);
                }
            }

            if (dsu.findPar(0) == dsu.findPar(n * n - 1))
                return val;
        }

        return -1;
    }
}

