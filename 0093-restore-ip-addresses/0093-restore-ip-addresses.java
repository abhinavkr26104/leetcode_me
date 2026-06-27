class Solution {

    List<String> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        dfs(0, s);

        return ans;
    }

    void dfs(int start, String s) {

        if (list.size() == 4) {

            if (start == s.length())
                ans.add(String.join(".", list));

            return;
        }

        for (int end = start; end < s.length() && end < start + 3; end++) {

            String part = s.substring(start, end + 1);

            if (isValid(part)) {

                list.add(part);

                dfs(end + 1, s);

                list.remove(list.size() - 1);
            }
        }
    }

    boolean isValid(String part) {

        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(part);

        return num >= 0 && num <= 255;
    }
}