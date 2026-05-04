// O(n) time, O(n) space

import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length()-1) {
                
                if (lastSign == '+') {
                    st.push(currNum);
                }
                else if (lastSign == '-') {
                    st.push(-currNum);
                }
                else if (lastSign == '*') {
                    st.push(st.pop() * currNum);
                }
                else if (lastSign == '/') {
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                lastSign = c;
            }
        }
        
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}