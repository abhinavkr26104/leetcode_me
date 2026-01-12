class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        return 0.0;  
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.printf("%.5f\n", sol.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));      // 2.00000
        System.out.printf("%.5f\n", sol.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));  // 2.50000
        System.out.printf("%.5f\n", sol.findMedianSortedArrays(new int[]{0}, new int[]{0}));      // 0.00000
        System.out.printf("%.5f\n", sol.findMedianSortedArrays(new int[]{9,9}, new int[]{9}));    // 9.00000
    }
}