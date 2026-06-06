class Solution {
    public int searchInsert(int[] nums, int target) {
         int x = -1;
        int n = nums.length;

        int z = 1;
        while (z < n) z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (x + b < n && nums[x + b] < target) {
                x += b;
            }
        }

       
            return x + 1;

    }
    }
