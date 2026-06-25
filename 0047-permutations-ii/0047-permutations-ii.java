class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        used = new boolean[nums.length];

        dfs(nums);

        return ans;
    }

    void dfs(int[] nums) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            list.add(nums[i]);

            dfs(nums);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}