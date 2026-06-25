class Solution {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return ans;

        dfs(0, digits);

        return ans;
    }

    void dfs(int index, String digits) {

        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            sb.append(ch);

            dfs(index + 1, digits);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}