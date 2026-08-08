class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {

        if (goal < 0)
            return 0;

        int l = 0;
        int odd = 0;
        int count = 0;

        for (int r = 0; r < nums.length; r++) {

            if (nums[r] % 2 != 0)
                odd++;

            while (odd > goal) {

                if (nums[l] % 2 != 0)
                    odd--;

                l++;
            }

            count += r - l + 1;
        }

        return count;
    }
}