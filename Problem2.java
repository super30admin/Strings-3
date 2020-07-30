// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        if(s==null || s.length() == 0) return 0;
        
        char lastSign = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = (num*10) + (c-'0');
            }
            if((!Character.isDigit(c) && c!=' ') || i == s.length()-1){
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-1*num);
                else if(lastSign == '*') st.push(st.pop()*num);
                else st.push(st.pop()/num);
                num = 0;
                lastSign = c;
            }
        }
        
        int result = 0;
        
        while(!st.isEmpty()){
            result += st.pop();
        }
        
        
        return result;
    }
}