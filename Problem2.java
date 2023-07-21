class Solution {
    public int calculate(String s) {
        if (s == null)
            return 0;
        char lastSign = '+';
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    st.push(curr);
                } else if (lastSign == '-') {
                    st.push(-curr);
                } else if (lastSign == '*') {
                    // curr = curr * st.pop();
                    st.push(curr * st.pop());
                } else if (lastSign == '/') {
                    // curr = curr / st.pop();
                    st.push(st.pop() / curr);
                }
                lastSign = c;
                curr = 0;
            }

        }
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}