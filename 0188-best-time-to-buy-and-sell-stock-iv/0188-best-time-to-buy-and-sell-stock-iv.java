class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // If k is large → unlimited transactions case
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[][] dp = new int[k + 1][2];

        // Initialize holding states
        for (int t = 0; t <= k; t++) {
            dp[t][1] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int t = k; t >= 1; t--) {

                // Sell
                dp[t][0] = Math.max(dp[t][0], dp[t][1] + price);

                // Buy
                dp[t][1] = Math.max(dp[t][1], dp[t - 1][0] - price);
            }
        }

        return dp[k][0];
    }
}
