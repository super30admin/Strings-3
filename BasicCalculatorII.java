// Time Complexity : O(N)
// Space Complexity : O(N), stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class BasicCalculatorII {
    class Solution {
        public int calculate(String s) {
            Stack<Integer> st = new Stack<>();
            int currNum = 0;
            char lastSign = '+';
            for(int i = 0; i< s.length(); i++) {
                char c = s.charAt(i);

                if(Character.isDigit(c)) {
                    currNum = currNum * 10 + c - '0';
                }

                if((!Character.isDigit(c)  && c!= ' ') || i  == s.length() -1) {
                    if(lastSign ==  '+') {
                        st.push(currNum);
                    } else if(lastSign ==  '-') {
                        st.push(-1*currNum);
                    } else if(lastSign ==  '*') {
                        st.push(st.pop()*currNum);
                    } else if(lastSign ==  '/') {
                        st.push(st.pop() / currNum);
                    }
                    currNum = 0;
                    lastSign = c;
                }
            }
            int result = 0;
            while(!st.isEmpty()) {
                result += st.pop();
            }
            return result;
        }
    }
}
