
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int calc = 0;
        int curr = 0;
        char last ='+';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (last == '+') {
                    st.push(+curr);
                }
                if (last == '-') {
                    st.push(-curr);
                }
                if (last == '*') {
                    st.push(st.pop()*curr); // pop from stack and perform multiplication
                }
                if (last == '/') {
                    st.push(st.pop()/curr); // pop from stack and perform division
                }
                last = c;
                curr = 0;
            }
        }
        while(!st.isEmpty()){
            calc = calc + st.pop(); // add all the elements
        }
        return calc;
    }
}