class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % k != 0)
            return false;

        int target = sum / k;

        Arrays.sort(nums);

        reverse(nums);

        int[] bucket = new int[k];

        return dfs(0, nums, bucket, target);
    }

    boolean dfs(int index, int[] nums, int[] bucket, int target) {

        if (index == nums.length)
            return true;

        for (int i = 0; i < bucket.length; i++) {

            if (bucket[i] + nums[index] > target)
                continue;

            bucket[i] += nums[index];

            if (dfs(index + 1, nums, bucket, target))
                return true;

            bucket[i] -= nums[index];

            // Pruning
            if (bucket[i] == 0)
                break;
        }

        return false;
    }

    void reverse(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }
    }
}