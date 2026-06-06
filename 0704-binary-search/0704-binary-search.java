class Solution {
    public int search(int[] nums, int target) {
        int x = -1;
        int n = nums.length;

        int z = 1;
        while (z < n) z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (x + b < n && nums[x + b] < target) {
                x += b;
            }
        }

        if (x + 1 < n && nums[x + 1] == target)
            return x + 1;

        return -1;
    }
}