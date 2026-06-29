class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        dfs(num, target, 0, "", 0, 0);

        return ans;
    }

    void dfs(String num, int target, int index,
             String exp, long value, long prev) {

        if (index == num.length()) {

            if (value == target)
                ans.add(exp);

            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0')
                break;

            long cur = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {

                dfs(num, target, i + 1,
                        exp + cur,
                        cur,
                        cur);

            } else {

                dfs(num, target, i + 1,
                        exp + "+" + cur,
                        value + cur,
                        cur);

                dfs(num, target, i + 1,
                        exp + "-" + cur,
                        value - cur,
                        -cur);

                dfs(num, target, i + 1,
                        exp + "*" + cur,
                        value - prev + prev * cur,
                        prev * cur);
            }
        }
    }
}