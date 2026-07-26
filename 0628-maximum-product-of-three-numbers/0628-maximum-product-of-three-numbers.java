class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        n--;
    
        int res=nums[n]*nums[n-1]*nums[n-2];
        int res1=nums[0]*nums[1]*nums[n];
        
        return Math.max(res,res1);
    }
}