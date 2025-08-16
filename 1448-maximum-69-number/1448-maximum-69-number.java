class Solution {
    public int maximum69Number(int num) {
        int n = 0;
        int c6 = 0;
        for (char c : String.valueOf(Math.abs(num)).toCharArray()) {
            if (c == '6' && c6 == 0) {
                n = n * 10 + 9;
                c6 = 1;
            } else {
                n = n * 10 + (c - '0');
            }
        }
        return n;
    }
}
