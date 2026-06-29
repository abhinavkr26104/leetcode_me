class Solution {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {

        dfs(0, 0, n);

        return ans;
    }

    void dfs(int open, int close, int n) {

        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {

            sb.append('(');

            dfs(open + 1, close, n);

            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {

            sb.append(')');

            dfs(open, close + 1, n);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}