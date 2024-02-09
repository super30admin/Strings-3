// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Keep pushing chars to stack including (), if we encounter ( push a 
// large value. If we encounter ) calculate intermidiate value and * with curr and push.
// finally return added value from stack.

// 227. Basic Calculator I

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        int last = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10+c - '0';
            }
            if(c == '+' || c == '-' || (i == s.length()-1 && s.charAt(i) != ')')){
                if(last =='+'){
                    st.push(curr);
                }
                else if(last =='-'){
                    st.push(-curr);
                }
                curr = 0;
                last = c;
            }
            else if(c == '('){
                if(last == '+'){
                    st.push(1);
                }
                else{
                    st.push(-1);
                }
                st.push(Integer.MAX_VALUE);
                curr = 0;
                last = '+';
            }
            else if(c == ')'){
                if(last =='+'){
                    st.push(curr);
                }
                else if(last =='-'){
                    st.push(-curr);
                }
                int inter = 0;
                while(st.peek() != Integer.MAX_VALUE){
                    inter += st.pop();
                }
                st.pop();
                st.push(st.pop()*inter);
                curr = 0;
                last = '+';
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}