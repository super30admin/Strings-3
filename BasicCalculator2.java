//Time complexity=O(m*n)
//Space complexity=O(m) string length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)return 0;
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int num = 0;
        int n = s.length();
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == n - 1){
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop() * num);
                else st.push(st.pop()/num);
                lastSign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result +=st.pop();
        }
        return result;
    }
}