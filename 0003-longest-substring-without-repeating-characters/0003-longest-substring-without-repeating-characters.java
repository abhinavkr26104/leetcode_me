class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int n=s.length();
        if(s.isEmpty())
        return 0;
        int max=0;
        Set<Character> set = new HashSet<>();
       while (j < n) {
    if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        max = Math.max(max, j - i + 1);
        j++;
    } else {
        set.remove(s.charAt(i));
        i++;
    }
}
        return max;
    }
}