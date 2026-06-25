class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        dfs(0, nums);

        return ans;
    }

    void dfs(int start, int[] nums) {

        ans.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1])
                continue;

            list.add(nums[i]);

            dfs(i + 1, nums);

            list.remove(list.size() - 1);
        }
    }
}