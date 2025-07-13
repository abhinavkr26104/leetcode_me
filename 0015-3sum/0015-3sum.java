class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) 
        {
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue; // Skip duplicate nums[i]
            }
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; // Skip duplicate nums[left]
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--; // Skip duplicate nums[right]
                    }
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return triplets;
    }
    }
