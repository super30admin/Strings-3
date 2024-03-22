
//Using stacks
// Time Complexity : O(n), length of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Keep calculating the expression on the go and add it to the stack. Solve the expression inner brackets and return its result to calculated value


class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int calc = 0;
        int curr = 0;
        char lastSign = '+';

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                curr = curr * 10 + c -'0';
            }

            if(c == '+' || c == '-' || (i == s.length()-1 && s.charAt(i) != ')')){
                if(lastSign == '+'){
                    st.push(curr);
                }
                else if(lastSign == '-'){
                     st.push(-curr);
                }
                curr = 0;
                lastSign = c;
            }
            else if(c == '('){
                // to keep track of the sign before '('
                if(lastSign == '+'){
                    st.push(1);
                }
                else{
                    st.push(-1);
                }
                st.push(Integer.MAX_VALUE); // representing '('
                //new expression starts
                curr = 0;
                lastSign = '+';
            }
            else if( c == ')'){
                if(lastSign == '+'){
                    st.push(curr);
                }
                else if(lastSign == '-'){
                     st.push(-curr);
                }

                int inter = 0;
                //compute expression under the bracket
                while(st.peek() != Integer.MAX_VALUE){
                    inter += st.pop();
                }
                st.pop(); // remove ( from Stack
                inter *= st.pop(); // the sign before bracket
                st.push(inter); 
                curr = 0;
                lastSign = '+';
            }
        }

        while(!st.isEmpty()){
            calc += st.pop();
        }

        return calc;
    }
}