class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canShip(weights, mid, days))
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    boolean canShip(int[] weights, int cap, int days) {
        int d = 1;
        int curWeight = 0;

        for (int w : weights) {
            if (curWeight + w > cap) {
                d++;
                curWeight = 0;
            }

            curWeight += w;
        }

        return d <= days;
    }
}