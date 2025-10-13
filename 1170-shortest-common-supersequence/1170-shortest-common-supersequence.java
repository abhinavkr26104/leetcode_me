class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Step 1: Fill LCS DP Table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Build SCS by backtracking from dp[n][m]
        int i = n, j = m;
        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                scs.append(s1.charAt(i - 1)); // include matching char once
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(s1.charAt(i - 1)); // include from s1
                i--;
            } else {
                scs.append(s2.charAt(j - 1)); // include from s2
                j--;
            }
        }

        // If any characters left in s1 or s2, include them
        while (i > 0) {
            scs.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(s2.charAt(j - 1));
            j--;
        }

        // Reverse because we built it backwards
        return scs.reverse().toString();
    }
}
