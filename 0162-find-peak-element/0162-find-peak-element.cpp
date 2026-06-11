class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int n = nums.size();

        int x = -1;

        int z = 1;
        while (z < n) z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (x + b + 1 < n && nums[x + b] < nums[x + b + 1]) {
                x += b;
            }
        }

        return x + 1;
    }
};