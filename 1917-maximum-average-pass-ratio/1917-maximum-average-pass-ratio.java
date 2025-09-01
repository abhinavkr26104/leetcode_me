import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );

        for (int[] c : classes) {
            pq.offer(c);
        }

        while (extraStudents-- > 0) {
            int[] cls = pq.poll();
            cls[0]++;
            cls[1]++;
            pq.offer(cls);
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            int[] cls = pq.poll();
            sum += (double) cls[0] / cls[1];
        }

        return sum / classes.length;
    }

    private double gain(int p, int t) {
        return (double)(p + 1) / (t + 1) - (double)p / t;
    }
}
