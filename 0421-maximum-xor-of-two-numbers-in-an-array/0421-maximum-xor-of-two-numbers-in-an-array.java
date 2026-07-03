class Solution {
    public int findMaximumXOR(int[] nums) {

        int ans = 0;
        int mask = 0;

        for (int bit = 31; bit >= 0; bit--) {

            mask |= (1 << bit);

            HashSet<Integer> set = new HashSet<>();

            for (int num : nums)
                set.add(num & mask);

            int candidate = ans | (1 << bit);

            for (int prefix : set) {

                if (set.contains(prefix ^ candidate)) {
                    ans = candidate;
                    break;
                }
            }
        }

        return ans;
    }
}