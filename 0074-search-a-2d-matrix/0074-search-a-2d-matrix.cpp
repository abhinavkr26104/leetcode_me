class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();

        int N = m * n;

        int x = -1;

        int z = 1;
        while (z < N) z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (x + b < N &&
                   matrix[(x + b) / n][(x + b) % n] < target) {
                x += b;
            }
        }

        int idx = x + 1;

        return idx < N &&
               matrix[idx / n][idx % n] == target;
    }
};