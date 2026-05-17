class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[] dp = new int[n];

        int maxIdx = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (bc(words[j],words[i]) && dp[i] < dp[j] + 1)
                {
                    dp[i] = dp[j] + 1;
                }
            }

            if (dp[i] > maxIdx) {
                maxIdx = dp[i];
            }
        }
        return maxIdx;
    }
    public boolean bc(String s1,String s2)
    {
        int i=0;
        int j=0,n1=s1.length(),n2=s2.length();

        if(n1+1 != n2)
        return false;

        int c=0;

        while(i<n1)
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else{
                c++;
                j++;
                }
                if(c>1)
        return false;

        }
        
        return true;
    }
}