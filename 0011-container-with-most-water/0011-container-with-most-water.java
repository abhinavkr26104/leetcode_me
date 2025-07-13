class Solution {
    public int maxArea(int[] height) {
         int maxArea = 0; // Initialize max area
        int left = 0;    // Left pointer
        int right = height.length - 1; // Right pointer
        
        while (left < right) {
            // Calculate the current area
            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea = currentHeight * width;
            
            // Update the maximum area if current area is greater
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea; // Return the maximum area found
    }  
    }
