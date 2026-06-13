class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {

            String cur = s.substring(i, i + 10);

            if (!seen.add(cur))
                repeated.add(cur);
        }

        return new ArrayList<>(repeated);
    }
}