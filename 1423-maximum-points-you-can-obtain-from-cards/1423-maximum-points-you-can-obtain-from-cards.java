class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int sum = 0;

        // Take k cards from the left
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int ans = sum;

        int left = k - 1;
        int right = n - 1;

        // Replace left cards with right cards
        while (left >= 0) {

            sum -= cardPoints[left];
            sum += cardPoints[right];

            ans = Math.max(ans, sum);

            left--;
            right--;
        }

        return ans;
    }
}