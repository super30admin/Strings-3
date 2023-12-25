// Time Complexity : O(n), where n is the length of the input string s
// Space Complexity : O(m), where m is the maximum number of elements that can be present in the stack at any given time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        if(s == null)
            return 0;
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        int lastSign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+'){
                    st.push(curr);
                } else if(lastSign == '-'){
                    st.push(-curr);
                } else if(lastSign == '*'){
                    st.push(st.pop() * curr);
                } else {
                    st.push(st.pop() / curr);
                }
                curr = 0;
                lastSign = c;
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}