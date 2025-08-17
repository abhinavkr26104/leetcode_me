class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double w = 1.0, ans = 0.0;
        for (int i = 1; i <= n; i++) {
            dp[i] = w / maxPts;
            if (i < k) w += dp[i];
            if (i - maxPts >= 0 && i - maxPts < k) w -= dp[i - maxPts];
        }
        for (int i = k; i <= n; i++) ans += dp[i];
        return ans;
    }
}
