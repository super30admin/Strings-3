class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int res = 0;
        char lastSign = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {
                if(lastSign == '+') {
                    st.push(num);
                } else if(lastSign == '-') {
                    st.push(-num);
                } else if(lastSign == '*') {
                    st.push(st.pop() * num);
                } else {
                    st.push(st.pop() / num);
                }
                lastSign = c;
                num = 0;
            }
        }
        while(!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}