class Solution {
    public char findTheDifference(String s, String t) {

        char xor = 0;

        for (char ch : s.toCharArray())
            xor ^= ch;

        for (char ch : t.toCharArray())
            xor ^= ch;

        return xor;
    }
}