import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];

            List<List<Integer>> pairs = twoSum(nums, i + 1, target);

            for (List<Integer> pair : pairs) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(pair.get(0));
                temp.add(pair.get(1));
                result.add(temp);
            }
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] n, int start, int t) {
        List<List<Integer>> res = new ArrayList<>();

        int i = start;
        int j = n.length - 1;

        while (i < j) {
            int sum = n[i] + n[j];

            if (sum > t) {
                j--;
            } else if (sum < t) {
                i++;
            } else {
                res.add(Arrays.asList(n[i], n[j]));

                i++;
                j--;

                while (i < j && n[i] == n[i - 1]) i++;
                while (i < j && n[j] == n[j + 1]) j--;
            }
        }

        return res;
    }
}