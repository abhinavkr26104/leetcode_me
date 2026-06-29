class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            ans[i]=hammingWeight(i);
        }
        return ans;
    }
    public int hammingWeight(int n) {

        int c = 0;

        for (int i = 31; i >= 0; i--) {

            if ((n & (1 << i)) != 0)
                c++;
        }

        return c;
    }
}