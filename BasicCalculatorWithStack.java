// Time Complexity : O(n) to iterate over the entire string
// Space Complexity : O(n) as we are using an explicit stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Start by initalizing few variables like lastSign, curr and a stack. Then check if a character is a digit then simply  curr = curr * 10 + c - '0' and then check current element is not a digit nor a space and then check for the sign and accordingly push the values in the stack. Then finally calculate result by popping the elements from stack.
 */
class Solution {
    public int calculate(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int curr = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    st.push(+curr);
                }
                if(lastSign == '-'){
                    st.push(-curr);
                }
                if(lastSign == '*'){
                    st.push(st.pop() * curr);
                }
                if(lastSign == '/'){
                    st.push(st.pop() / curr);
                }
                lastSign = c;
                curr = 0;
            }
        }
        int calc = 0;

        while(!st.isEmpty()){
            calc = calc + st.pop();
        }

        return calc;
    }
}