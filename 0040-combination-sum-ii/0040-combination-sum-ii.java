class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

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

            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            list.add(candidates[i]);
            sum += candidates[i];

            // Cannot reuse same element
            dfs(i + 1, candidates, target);

            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}