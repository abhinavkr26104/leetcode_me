class Solution {
    public int strStr(String text, String pat) {

        int n = text.length();
        int m = pat.length();

        if (m == 0)
            return 0;

        // Calculate LPS of pattern
        int[] lps = new int[m];

        for (int i = 1; i < m; i++) {

            int j = lps[i - 1];

            while (j > 0 && pat.charAt(i) != pat.charAt(j))
                j = lps[j - 1];

            if (pat.charAt(i) == pat.charAt(j))
                j++;

            lps[i] = j;
        }

        int j = 0;

        for (int i = 0; i < n; i++) {

            while (j > 0 && text.charAt(i) != pat.charAt(j))
                j = lps[j - 1];

            if (text.charAt(i) == pat.charAt(j))
                j++;

            if (j == m)
                return i - m + 1;
        }

        return -1;
    }
}