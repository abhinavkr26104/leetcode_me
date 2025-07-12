import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the indices of the numbers
        Map<Integer, Integer> numMap = new HashMap<>();
        
        // Iterate over the array
        for (int i = 0; i < nums.length; i++) 
        {
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            
            // Add the number to the map
            numMap.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array
        throw new IllegalArgumentException("No two sum solution");
    }
}
