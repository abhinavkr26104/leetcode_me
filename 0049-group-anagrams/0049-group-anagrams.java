class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);

            mp.putIfAbsent(key, new ArrayList<>());
            mp.get(key).add(s);
        }

        return new ArrayList<>(mp.values());
    }
}