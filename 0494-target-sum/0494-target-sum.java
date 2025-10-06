class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target > sum || target < -sum || (target + sum) % 2 != 0) {
            return 0;
        }

        int ds = (target + sum) / 2;
        return countSubsets(nums, ds);
    }

    public int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                dp[i][sum] = dp[i - 1][sum];
                if (arr[i - 1] <= sum) {
                    dp[i][sum] += dp[i - 1][sum - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
