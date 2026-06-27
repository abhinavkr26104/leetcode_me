class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(1, k, n);

        return ans;
    }

    void dfs(int start, int k, int target) {

        if (list.size() == k) {

            if (sum == target)
                ans.add(new ArrayList<>(list));

            return;
        }

        if (sum > target)
            return;

        for (int i = start; i <= 9; i++) {

            list.add(i);
            sum += i;

            dfs(i + 1, k, target);

            sum -= i;
            list.remove(list.size() - 1);
        }
    }
}