// Time Complexity : O(n); where n = length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int curr = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            } 
            // take the last number into calculation
            if((!Character.isDigit(c) || i == s.length() - 1) && c!= ' '){
                if(lastSign == '+'){
                    st.push(+curr);
                }
                else if(lastSign == '-'){
                    st.push(-curr);
                }
                else if(lastSign == '*'){
                    st.push(st.pop()*curr);
                }
                else if(lastSign == '/'){
                    st.push(st.pop()/curr);
                }
                lastSign = c;
                curr = 0;
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}