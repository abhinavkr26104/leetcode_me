class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});

        for (int[] r : restrictions)
            list.add(r);

        Collections.sort(list, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < list.size(); i++) {
            int[] cur = list.get(i);
            int[] prev = list.get(i - 1);

            cur[1] = Math.min(cur[1],
                    prev[1] + (cur[0] - prev[0]));
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            int[] cur = list.get(i);
            int[] next = list.get(i + 1);

            cur[1] = Math.min(cur[1],
                    next[1] + (next[0] - cur[0]));
        }

        int ans = 0;

        for (int i = 1; i < list.size(); i++) {

            int[] a = list.get(i - 1);
            int[] b = list.get(i);

            int dist = b[0] - a[0];
            int h1 = a[1];
            int h2 = b[1];

            ans = Math.max(ans,
                    (h1 + h2 + dist) / 2);
        }

        int[] last = list.get(list.size() - 1);

        ans = Math.max(ans,
                last[1] + (n - last[0]));

        return ans;
    }
}