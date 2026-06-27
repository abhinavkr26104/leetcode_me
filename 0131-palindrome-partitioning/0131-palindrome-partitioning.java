class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {

        dfs(0, s);

        return ans;
    }

    void dfs(int start, String s) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                list.add(s.substring(start, end + 1));

                dfs(end + 1, s);

                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}