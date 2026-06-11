class Solution {
      public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;

        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        int x = l - 1;

        int z = 1;
        while (z <= r - l + 1)
            z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (!canShip(weights, x + b, days))
                x += b;
        }

        return x + 1;
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