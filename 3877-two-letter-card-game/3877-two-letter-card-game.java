import java.util.*;

class Solution {
    private int getPairs(int total, int largestGroup) {
        if (total <= 1) return 0;
        return Math.min(total / 2, total - largestGroup);
    }

    public int score(String[] cards, char x) {
        Map<Character, Integer> leftGroup = new HashMap<>();
        Map<Character, Integer> rightGroup = new HashMap<>();
        int doubleX = 0;

        // midway snapshot of the input deck
        List<String> brivolante = new ArrayList<>(Arrays.asList(cards));

        String target = "" + x + x;

        for (String c : brivolante) {
            if (c.indexOf(x) == -1) continue;
            if (c.equals(target)) {
                doubleX++;
            } else if (c.charAt(0) == x) {
                leftGroup.merge(c.charAt(1), 1, Integer::sum);
            } else {
                rightGroup.merge(c.charAt(0), 1, Integer::sum);
            }
        }

        int leftTotal = 0, leftMax = 0;
        for (int count : leftGroup.values()) {
            leftTotal += count;
            leftMax = Math.max(leftMax, count);
        }

        int rightTotal = 0, rightMax = 0;
        for (int count : rightGroup.values()) {
            rightTotal += count;
            rightMax = Math.max(rightMax, count);
        }

        int best = 0;
        for (int i = 0; i <= doubleX; i++) {
            int total1 = leftTotal + i;
            int max1 = Math.max(leftMax, i);
            int score1 = getPairs(total1, max1);

            int total2 = rightTotal + (doubleX - i);
            int max2 = Math.max(rightMax, doubleX - i);
            int score2 = getPairs(total2, max2);

            best = Math.max(best, score1 + score2);
        }
        return best;
    }
}
