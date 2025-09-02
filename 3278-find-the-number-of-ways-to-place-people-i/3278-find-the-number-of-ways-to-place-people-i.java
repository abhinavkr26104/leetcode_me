import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int ax = points[i][0], ay = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int bx = points[j][0], by = points[j][1];

                // A is upper-left of B (allow same x or same y)
                if (ax <= bx && ay >= by) {
                    boolean empty = true;

                    // No other point in/on the axis-aligned rectangle (or line) AB
                    int minX = Math.min(ax, bx), maxX = Math.max(ax, bx);
                    int minY = Math.min(ay, by), maxY = Math.max(ay, by);

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0], y = points[k][1];
                        if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
                            empty = false; // inside or on the border invalidates
                            break;
                        }
                    }

                    if (empty) ans++;
                }
            }
        }
        return ans;
    }
}
