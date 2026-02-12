class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];

        // Base case
        dp[0][0] = 0;               // not holding
        dp[0][1] = -prices[0];      // holding

        for (int i = 1; i < n; i++) {

            // Not holding
            dp[i][0] = Math.max(
                dp[i - 1][0],
                dp[i - 1][1] + prices[i] - fee
            );

            // Holding
            dp[i][1] = Math.max(
                dp[i - 1][1],
                dp[i - 1][0] - prices[i]
            );
        }

        return dp[n - 1][0];
    }
}
