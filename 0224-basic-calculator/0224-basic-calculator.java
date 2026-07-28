class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');

            } else if (ch == '+') {

                result += sign * number;
                number = 0;
                sign = 1;

            } else if (ch == '-') {

                result += sign * number;
                number = 0;
                sign = -1;

            } else if (ch == '(') {

                st.push(result);
                st.push(sign);

                result = 0;
                sign = 1;

            } else if (ch == ')') {

                result += sign * number;
                number = 0;

                result *= st.pop();   // previous sign
                result += st.pop();   // previous result

            }
        }

        result += sign * number;

        return result;
    }
}