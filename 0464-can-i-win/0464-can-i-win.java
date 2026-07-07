class Solution {

    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0)
            return true;

        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;

        if (sum < desiredTotal)
            return false;

        return dfs(0, desiredTotal, maxChoosableInteger);
    }

    boolean dfs(int mask, int target, int n) {

        if (memo.containsKey(mask))
            return memo.get(mask);

        for (int i = 1; i <= n; i++) {

            if ((mask & (1 << i)) != 0)
                continue;

            if (i >= target ||
                !dfs(mask | (1 << i), target - i, n)) {

                memo.put(mask, true);
                return true;
            }
        }

        memo.put(mask, false);

        return false;
    }
}