class Solution {
    public boolean isMatch(String s, String p) {
      int sLen = s.length();
        int pLen = p.length();
        
        // Create a DP table with (sLen + 1) x (pLen + 1)
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        
        // Base case: empty string and empty pattern match
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* which can match an empty string
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (pChar == sChar || pChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    // Match zero occurrence or one/more occurrence of the preceding element
                    dp[i][j] = dp[i][j - 2] || (matchChar(sChar, p.charAt(j - 2)) && dp[i - 1][j]);
                }
            }
        }
        
        return dp[sLen][pLen];
    }
     private boolean matchChar(char sChar, char pChar) {
        return pChar == sChar || pChar == '.';
    }
    
    }

