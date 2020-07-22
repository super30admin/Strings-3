// Time Complexity : O(n) where n is the length of the string s
// Space Complexity : O(n) to store elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Iterate thru string, whenever we encounter a + or - operation, put number in stack along with + or - sign
// we encounter a * or / operation, we pop top element from stack, perform operation with the current number
// and push back in stack. Finally we take sum of all elements in the stack.


class basicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int lastNum = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                lastNum = lastNum * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign =='+') {
                    st.push(lastNum);
                }
                if (lastSign == '-') {
                    st.push(-lastNum);
                }
                if (lastSign == '*') {
                    st.push(st.pop() * lastNum);
                }
                if (lastSign == '/') {
                    st.push(st.pop() / lastNum);
                }
                lastSign = c;
                lastNum = 0;
            }
        }
        
        int val = 0;
        while (!st.isEmpty()) {
            val += st.pop();
        }
        return val;
    }
}