// Time Complexity : O(length of the string)
// Space Complexity : Proportional to n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - We iterate over the string and check if a character is a digit. If yes, add it to the stack.
 * 2 - Next, we check for operators until we find, / or * so that the result can be calculated and added to the stack
 * 3 - In the end, we have to pop until stack is empty and keep adding to the result because only left would be + or -
 */

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        
        int currNum = 0;
        int lastSign = '+';
        int result = 0;
        
        for(int i = 0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = 10*currNum + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1)
            {
                if(lastSign == '+')
                    st.push(currNum);
                else if(lastSign == '-')
                    st.push(-currNum);
                else if(lastSign == '*')
                    st.push(st.pop()*currNum);
                else if(lastSign == '/')
                    st.push(st.pop()/currNum);
                currNum = 0;
                lastSign = c;
            }
        }
        while(!st.isEmpty())
        {
            result += st.pop();
        }
        return result;
    }
}
