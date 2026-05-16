class Solution {
    public int change(int target,int[] nums) {
int[] count=new int[target+1];
       count[0] = 1;
       for (int c : nums) {
for (int x = 1; x <= target; x++) {

if (x-c >= 0) {
count[x] += count[x-c];
}
}
} 
return count[target];
    }
}