package org.example;
// Time Complexity : O(n) -> n is the length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class BasicCalculatorIIUsingStack {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();
        int curNum = 0;
        char lastSign = '+';
        int result = 0;

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curNum = curNum*10 + c - '0';
            }

            if((!Character.isDigit(c) && c != ' ')|| i==s.length()-1)
            {
                if(lastSign == '+')
                {
                    st.push(curNum);
                }
                else if(lastSign == '-')
                {
                    st.push(-curNum);
                }
                else if(lastSign == '*')
                {
                    int popped = st.pop();
                    st.push(popped * curNum);
                }
                else{
                    int popped = st.pop();
                    st.push(popped / curNum);
                }
                lastSign = c;
                curNum = 0;
            }

        }

        while(!st.isEmpty())
        {
            result +=st.pop();
        }
        return result;
    }
}