class Solution {
    public int reverseBits(int n) {

        int left = 31;
        int right = 0;

        while (left > right) {

            int leftBit = (n >> left) & 1;
            int rightBit = (n >> right) & 1;

            if (leftBit != rightBit) {

                n ^= (1 << left);
                n ^= (1 << right);
            }

            left--;
            right++;
        }

        return n;
    }
}