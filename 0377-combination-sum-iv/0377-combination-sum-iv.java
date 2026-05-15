class Solution {
    public int combinationSum4(int[] nums, int target) {
int[] count=new int[target+1];
       count[0] = 1;
for (int x = 1; x <= target; x++) {
for (int c : nums) {
if (x-c >= 0) {
count[x] += count[x-c];
}
}
} 
return count[target];
    }
}