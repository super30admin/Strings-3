// Time Complexity : O(n) --> where n is the length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (227): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> st = new Stack<>();
        char lastSign = '+'; int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == n-1) {
                if (lastSign == '+') st.push(num);
                else if (lastSign == '-') st.push(-num);
                else if (lastSign == '*') st.push(st.pop() * num);
                else st.push(st.pop() / num);
                lastSign = c; num = 0;
            }
        } 
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}