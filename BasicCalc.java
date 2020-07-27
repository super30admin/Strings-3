// Time Complexity : O(n) n is string length
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num=0;
        char lastSign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            
            if((!Character.isDigit(c) && c!= ' ') || i==s.length()-1){
                if(lastSign == '+') st.push(num);
                if(lastSign == '-') st.push(-num);
                if(lastSign == '*') st.push(st.pop() * num);
                if(lastSign == '/') st.push(st.pop() / num);
                lastSign = c;
                num = 0;
            }
        }
        
        int result = 0;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}