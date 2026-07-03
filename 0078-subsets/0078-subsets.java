class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        for (int mask = 0; mask < (1 << n); mask++) {

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0)
                    list.add(nums[i]);
            }

            ans.add(list);
        }

        return ans;
    }
}