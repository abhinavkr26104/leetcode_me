class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;
        double[] dp = new double[k + 1];
        dp[k] = 1.0;
        double window = Math.min(n - k + 1, maxPts);
        for (int i = k - 1; i >= 0; --i) {
            dp[i] = window / maxPts;
            window += dp[i];
            double out;
            int j = i + maxPts;
            if (j > k) out = (j <= n) ? 1.0 : 0.0;
            else out = dp[j];
            window -= out;
        }
        return dp[0];
    }
}
