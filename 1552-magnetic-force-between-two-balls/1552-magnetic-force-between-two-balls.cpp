class Solution {
public:
    int maxDistance(vector<int>& p, int m) {
        sort(p.begin(), p.end());

        int l = 1;
        int r = p.back() - p.front();

        int x = l - 1;

        int z = 1;
        while (z <= r - l + 1) z *= 2;

        for (int b = z; b >= 1; b /= 2) {
            while (canPlace(p, m, x + b))
                x += b;
        }

        return x;
    }

    bool canPlace(vector<int>& p, int m, int force) {
        int balls = 1;
        int last = p[0];

        for (int i = 1; i < p.size(); i++) {
            if (p[i] - last >= force) {
                balls++;
                last = p[i];
            }
        }

        return balls >= m;
    }
};