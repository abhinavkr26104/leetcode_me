class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;

        for (int p : piles)
            r = Math.max(r, p);

        int x = l - 1;

        int z = 1;
        while (z <= r - l + 1)
            z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (!canEat(piles, h, x + b))
                x += b;
        }

        return x + 1;
    }

    boolean canEat(int[] piles, int h, int k) {
        long hours = 0;

        for (int p : piles)
            hours += (p + k - 1) / k;

        return hours <= h;
    }
}