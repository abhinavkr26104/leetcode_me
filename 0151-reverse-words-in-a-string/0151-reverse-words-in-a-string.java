class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();

        int i = 0;
        int n = s.length();

        while (i < n) {

            while (i < n && s.charAt(i) == ' ')
                i++;

            if (i >= n)
                break;

            StringBuilder word = new StringBuilder();

            while (i < n && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }

            words.add(word.toString());
        }

        StringBuilder ans = new StringBuilder();

        for (int j = words.size() - 1; j >= 0; j--) {
            ans.append(words.get(j));

            if (j > 0)
                ans.append(" ");
        }

        return ans.toString();
    }
}