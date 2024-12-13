// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum =0;
        char lastSign = '+';

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastSign == '+'){
                    st.push(currNum);
                }else if(lastSign == '-'){
                    st.push(-currNum);
                }else if(lastSign == '*'){
                    int popped = st.pop();
                    st.push(popped * currNum);
                }else if(lastSign == '/'){
                    int popped = st.pop();
                    st.push(popped / currNum);
                }
                currNum =0;
                lastSign = c;
            }
        }
        int result =0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
