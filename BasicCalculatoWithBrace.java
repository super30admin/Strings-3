package org.example;

// Time Complexity : O(n) -> n is the length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class BasicCalculatoWithBrace {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curNum = 0;
        int openBrace = Integer.MAX_VALUE;
        char lastSign = '+';
        int result = 0;
        s = s.trim();

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curNum = curNum * 10 + c - '0';
                if(i == s.length()-1)
                {
                    if(lastSign == '+') st.push(curNum);
                    else st.push(-curNum);
                }
            }
            else if( c == '(')
            {
                if(lastSign == '+') st.push(1);
                else st.push(-1);
                st.push(openBrace);
                lastSign = '+';  curNum = 0;
            }
            else if( c == ')')
            {
                if(lastSign == '+') st.push(curNum);
                else st.push(-curNum);
                int intrMed = 0;
                while(st.peek()!=openBrace)
                {
                    intrMed += st.pop();
                }
                st.pop();  //pop openBrace
                st.push(intrMed*st.pop()); //pop +1 -1
                lastSign = '+';  curNum = 0;
            }
            else if( c == '+' || c == '-')
            {
                if(lastSign == '+') st.push(curNum);
                else st.push(-curNum);
                lastSign = c; curNum = 0;
            }
        }

        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}