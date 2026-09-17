//Space Complexity: O(n)
//Time Complexity: O(n)
class Solution {
    public int calculate(String s) {
        int currNum = 0;
        char lastSign = '+';
        s = s.trim();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (lastSign == '+') {
                    st.push(currNum);
                } else if (lastSign == '-') {
                    st.push(-currNum);
                } else if (lastSign == '*') {
                    st.push(st.pop() * currNum);
                } else if (lastSign == '/') {
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                lastSign = c;
            }

        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}