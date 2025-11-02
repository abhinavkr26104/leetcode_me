class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int[][] diff1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] diff2 = generate(Arrays.copyOfRange(nums, n / 2, n));

        int min = Integer.MAX_VALUE;
        for (int len = 0; len <= n / 2; len++) {
            int[] left = diff1[len];
            int[] right = diff2[n/2 - len];

            int l = 0;
            int r = diff2[n/2 - len].length - 1;

            while (l < left.length && r >= 0) {
                // arrays are already sorted so we move one pointer at a time to make the diff
                // closer to 0
                int diff = left[l] + right[r];
                min = Math.min(min, Math.abs(diff));
                if (diff < 0)
                    l++;
                else if (diff > 0)
                    r--;
                else
                    return 0;
            }
        }

        return min;
    }

    private static int[][] generate(int[] nums) {
        int n = nums.length;
        int m = 1 << n;

        int total = 0;
        for (int num : nums)
            total += num;

        for (int i = 0; i < n; i++)
            nums[i] <<= 1;

        int[] sums = new int[m];
        sums[0] -= total;

        for (int i = 0, maxTo = 1; i < n; i++, maxTo <<= 1) {
            int num = nums[i];
            for (int from = 0, to = maxTo; from < maxTo; from++, to++)
                sums[to] = sums[from] + num;
        }

        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];

        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial];
            binomial = binomial * (n - i) / (i + 1);
        }

        for (int key = 0; key < m; key++) {
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sums[key];
        }

        for (int[] arr : ans)
            Arrays.sort(arr);

        return ans;
        
    }
}



// import java.util.*;

// class Solution {
//     public int minimumDifference(int[] nums) {
//         int n = nums.length;
//         int totalSum = Arrays.stream(nums).sum();
//         int half = n / 2;

//         // Split array into two halves
//         int[] left = Arrays.copyOfRange(nums, 0, half);
//         int[] right = Arrays.copyOfRange(nums, half, n);

//         // Map: subset size -> list of subset sums
//         List<List<Integer>> leftSums = new ArrayList<>();
//         List<List<Integer>> rightSums = new ArrayList<>();

//         for (int i = 0; i <= half; i++) {
//             leftSums.add(new ArrayList<>());
//         }
//         for (int i = 0; i <= n - half; i++) {
//             rightSums.add(new ArrayList<>());
//         }

//         // Generate all subset sums for left and right halves
//         generateSums(left, 0, 0, 0, leftSums);
//         generateSums(right, 0, 0, 0, rightSums);

//         // Sort each list to apply binary search
//         for (List<Integer> list : rightSums) Collections.sort(list);

//         int ans = Integer.MAX_VALUE;

//         // Try combining subsets of left and right halves
//         for (int k = 0; k <= half; k++) {
//             for (int sumLeft : leftSums.get(k)) {
//                 List<Integer> rightList = rightSums.get(half - k);
//                 int idx = Collections.binarySearch(rightList, totalSum / 2 - sumLeft);
//                 if (idx < 0) idx = -idx - 1;

//                 // Check closest sums
//                 if (idx < rightList.size()) {
//                     int sumRight = rightList.get(idx);
//                     int current = Math.abs(totalSum - 2 * (sumLeft + sumRight));
//                     ans = Math.min(ans, current);
//                 }
//                 if (idx > 0) {
//                     int sumRight = rightList.get(idx - 1);
//                     int current = Math.abs(totalSum - 2 * (sumLeft + sumRight));
//                     ans = Math.min(ans, current);
//                 }
//             }
//         }

//         return ans;
//     }

//     private void generateSums(int[] nums, int index, int count, int sum, List<List<Integer>> sums) {
//         if (index == nums.length) {
//             sums.get(count).add(sum);
//             return;
//         }
//         // Include current number
//         generateSums(nums, index + 1, count + 1, sum + nums[index], sums);
//         // Exclude current number
//         generateSums(nums, index + 1, count, sum, sums);
//     }
// }