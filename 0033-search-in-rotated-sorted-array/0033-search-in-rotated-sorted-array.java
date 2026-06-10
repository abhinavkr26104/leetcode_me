class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int z = 1;
        while (z < n) z *= 2;

        int pivot = 0;

        if (nums[0] > nums[n - 1]) {
            int x = -1;

            for (int b = z; b >= 1; b /= 2) {
                while (x + b < n && nums[x + b] >= nums[0]) {
                    x += b;
                }
            }

            pivot = x + 1;
        }

        int ans = bs(nums, target, pivot, n - 1);

        if (ans == -1)
            ans = bs(nums, target, 0, pivot - 1);

        return ans;
    }

    int bs(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }
}