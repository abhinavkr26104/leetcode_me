class Solution {
    public boolean uniformArray(int[] nums1) {
        int o=0;
        int e=1;
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==1)
            {
                o=1;
                e=0;
            }

        }


        if(o==1 || e==1)
        return true;

        return false;
    }
}