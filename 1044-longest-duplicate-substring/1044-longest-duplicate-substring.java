class Solution {

    long mod = 1000000007L;
    long base = 31;

    public String longestDupSubstring(String s) {

        int n = s.length();

        long[] pow = new long[n + 1];
        long[] pref = new long[n + 1];

        // pow[i] = base^i
        pow[0] = 1;

        for (int i = 1; i <= n; i++)
            pow[i] = (pow[i - 1] * base) % mod;

        // prefix hashes
        for (int i = 0; i < n; i++) {
            pref[i + 1] =
                    (pref[i] * base + (s.charAt(i) - 'a' + 1))
                            % mod;
        }

        int bestStart = -1;
        int bestLen = 0;

        int l = 1;
        int r = n - 1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            int start = hasDuplicate(s, mid, pref, pow);

            if (start != -1) {

                // duplicate of length mid exists
                bestStart = start;
                bestLen = mid;

                l = mid + 1;
            } else {

                // duplicate length too large
                r = mid - 1;
            }
        }

        return bestStart == -1
                ? ""
                : s.substring(bestStart,
                              bestStart + bestLen);
    }

    int hasDuplicate(String s,
                     int len,
                     long[] pref,
                     long[] pow) {

        HashMap<Long, List<Integer>> mp =
                new HashMap<>();

        int n = s.length();

        for (int i = 0; i + len <= n; i++) {

            // hash of s[i...i+len-1]
            long hash =
                    (pref[i + len]
                            - (pref[i] * pow[len]) % mod
                            + mod)
                            % mod;

            if (mp.containsKey(hash)) {

                // verify to avoid collision
                for (int st : mp.get(hash)) {

                    if (s.substring(st, st + len)
                            .equals(
                                    s.substring(i,
                                            i + len)))
                        return i;
                }
            }

            mp.computeIfAbsent(hash,
                    k -> new ArrayList<>())
                    .add(i);
        }

        return -1;
    }
}