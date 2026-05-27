class Solution {
    public int maxSubArray(int[] arr) {
        int best =Integer.MIN_VALUE;
        int sum =0;

        for(int i=0;i<arr.length;i++)
        {
            sum=Math.max(arr[i],sum+arr[i]);
            best=Math.max(best,sum);

        }
        return best;
    }
}