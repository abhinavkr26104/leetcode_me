class Solution {
    public int maxProduct(String[] words) {

        int n = words.length;

        int[] len = new int[n];
        int[] mask = new int[n];

        for (int i = 0; i < n; i++) {

            len[i] = words[i].length();

            for (char ch : words[i].toCharArray()) {
                mask[i] |= (1 << (ch - 'a'));
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, len[i] * len[j]);
                }
            }
        }

        return ans;
    }
}