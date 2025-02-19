/*
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Leetcode: Yes
 */
class Solution {
    public int calculate(String s) {
        //base
        if(s == null || s.length() == 0) {
            return 0;
        }

        //logic
        int num = 0;
        char lastSign = '+';
        int calc = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if (lastSign == '+') {
                    st.push(num);
                } else if (lastSign == '-') {
                    st.push(-num);
                } else if (lastSign == '*') {
                    st.push(st.pop() * num);
                } else if (lastSign == '/') {
                    st.push(st.pop() / num);
                }
                num = 0;
                lastSign = c; 
            }
        }

        while(!st.isEmpty()) {
            calc = calc + st.pop();
        }

        return calc;
    }
}