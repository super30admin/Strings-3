/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time complexity - O(N)
Space complexity - O(N)
Approach : Maintain stack for all calculations if +,- found push the number to stack with given operands and if *, / pop and do the ca;culations push the number to stack
*/

import java.util.Stack;
public class Basic_CalculatorII_LC_227 {
    public int calculate(String s) {
        //Base case
        if(s==null) return 0;
        //trim the string for trailing and leading white spaces
        s= s.trim();
        if(s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int curNumber = 0;
        char lastSign = '+';

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) { //digit found
                curNumber = curNumber * 10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1) { //sign found
                if(lastSign == '+') {
                    st.push(curNumber);
                } else if(lastSign == '-') {
                    st.push(-curNumber);
                } else if(lastSign == '*') {
                    st.push(st.pop() * curNumber);
                } else { //(lastSign == '/')
                    st.push(st.pop()/curNumber);
                }
                curNumber = 0; //reset it for next digit
                lastSign = ch;
            }

        }
        int result = 0;
        while(!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}