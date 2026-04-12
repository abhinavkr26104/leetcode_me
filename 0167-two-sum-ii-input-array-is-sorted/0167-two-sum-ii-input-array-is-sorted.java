class Solution {
    public int[] twoSum(int[] n, int t) {
        int i=1;
        int j=n.length;
        while(i<j)
        {
            int sum=n[i-1]+n[j-1];
            if(sum>t)
            j--;
            else if(sum<t)
            i++;
            else if(sum==t)
            return new int[]{i,j};
        }
        return new int[]{-1,-1};
    }
}