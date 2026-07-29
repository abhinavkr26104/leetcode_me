class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!st.isEmpty() &&
                   st.peek() > 0 &&
                   asteroid < 0) {

                if (st.peek() < -asteroid) {
                    st.pop();                 // stack asteroid explodes
                }
                else if (st.peek() == -asteroid) {
                    st.pop();                 // both explode
                    destroyed = true;
                    break;
                }
                else {
                    destroyed = true;         // current asteroid explodes
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}