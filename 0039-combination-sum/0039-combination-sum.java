class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0, candidates, target);

        return ans;
    }

    void dfs(int start, int[] candidates, int target) {

        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target)
            return;

        for (int i = start; i < candidates.length; i++) {

            list.add(candidates[i]);
            sum += candidates[i];

            // reuse allowed
            dfs(i, candidates, target);

            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}