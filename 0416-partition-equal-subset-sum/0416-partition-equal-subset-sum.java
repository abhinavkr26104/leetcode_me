import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If total sum is odd, can't partition equally
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        // dp[i][j] = can we make sum j using first i elements
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 is always possible (empty subset)
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}
