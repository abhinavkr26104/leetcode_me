import java.util.ArrayList;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int temp[] = new int[nums.length + 1];
        int size = 0;

        for (int i : nums) {
            if (size == 0) {
                temp[++size] = i;
                continue;
            }

            int x = temp[size];

            if (i > x)
                temp[++size] = i;
            else {
                int p = lowerBound(temp, i, size);
                temp[p] = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            ans.add(temp[i]);
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();

        return size;
    }

    public static int lowerBound(int[] arr, int x, int size) {
        int low = 1;
        int high = size;
        int ans = size;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}