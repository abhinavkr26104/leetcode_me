class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] freq = new int[128];

        for (char c : t.toCharArray())
            freq[c]++;

        int l = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int r = 0; r < s.length(); r++) {

            if (freq[s.charAt(r)] > 0)
                count--;

            freq[s.charAt(r)]--;

            while (count == 0) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                freq[s.charAt(l)]++;

                if (freq[s.charAt(l)] > 0)
                    count++;

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}