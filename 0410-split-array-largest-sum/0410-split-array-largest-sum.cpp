class Solution {
public:
    bool f(vector<int>& nums, int k, int limit) {
        int parts = 1;
        long long cur = 0;

        for (int x : nums) {
            if (cur + x > limit) {
                parts++;
                cur = x;
            } else {
                cur += x;
            }
        }

        return parts <= k;
    }

    int splitArray(vector<int>& nums, int k) {
        int l = *max_element(nums.begin(), nums.end());

        long long r = 0;
        for (int x : nums) r += x;

        long long x = l - 1;

        long long z = 1;
        while (z <= r - l + 1) z *= 2;

        for (long long b = z; b >= 1; b /= 2) {
            while (!f(nums, k, x + b))
                x += b;
        }

        return (int)(x + 1);
    }
};