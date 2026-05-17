class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        int[] p = new int[n];

        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            p[i] = i;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    p[i] = j;
                }
            }

            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (p[maxIdx] != maxIdx) {
            ans.add(nums[maxIdx]);
            maxIdx = p[maxIdx];
        }
        ans.add(nums[maxIdx]);

        Collections.reverse(ans);
        return ans;
    }
}