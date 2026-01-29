class Solution {
    public String minWindow(String s, String t) {
        int[] f = new int[128];
        for (char c : t.toCharArray()) f[c]++;

        int l = 0, cnt = t.length(), best = Integer.MAX_VALUE, start = 0;

        for (int r = 0; r < s.length(); r++) {
            if (f[s.charAt(r)]-- > 0) cnt--;

            while (cnt == 0) {
                if (r - l + 1 < best) {
                    best = r - l + 1;
                    start = l;
                }
                if (++f[s.charAt(l++)] > 0) cnt++;
            }
        }
        return best == Integer.MAX_VALUE ? "" : s.substring(start, start + best);
    }
}
