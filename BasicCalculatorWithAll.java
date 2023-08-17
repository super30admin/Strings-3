package org.example;

import java.util.Stack;
// Time Complexity : O(n) -> n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
public class BasicCalculatorWithAll {
    class Solution {
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
                        else if(lastSign == '-')st.push(-curNum);
                        else if(lastSign == '*') st.push(st.pop()*curNum);
                        else st.push(st.pop()/curNum);
                    }
                }
                else if( c == '(')
                {
                    if(lastSign == '+') st.push(1);
                    else if(lastSign == '-')st.push(-1);
                    else if(lastSign == '*')st.push(null);  // for multiplication
                    else if(lastSign == '/')st.push(Integer.MIN_VALUE); // for division
                    st.push(openBrace);
                    lastSign = '+';  curNum = 0;
                }
                else if( c == ')')
                {
                    if(lastSign == '+') st.push(curNum);
                    else if(lastSign == '-') st.push(-curNum);
                    else if(lastSign == '*') st.push(st.pop()*curNum);
                    else if(lastSign == '/') st.push(st.pop()/curNum);
                    int intrMed = 0;
                    while(st.peek()!=openBrace)
                    {
                        intrMed += st.pop();
                    }
                    st.pop();  //pop openBrace
                    if(st.peek()==null)   // if it is multiplication
                    {
                        st.pop();
                        st.push(st.pop()*intrMed);
                    }else if(st.peek() == Integer.MIN_VALUE)  // if it is division
                    {
                        st.pop();
                        st.push(st.pop()/intrMed);
                    }
                    else{
                        st.push(intrMed*st.pop()); //pop +1 -1
                    }
                    lastSign = ' ';  curNum = 0;
                }
                else if( c == '+' || c == '-' ||  c == '*' || c == '/' || lastSign == ' ')
                {
                    if(lastSign == '+') st.push(curNum);
                    else if(lastSign == '-')st.push(-curNum);
                    else if(lastSign == '*')
                    {
                        st.push(st.pop()*curNum);
                    }
                    else if(lastSign == '/')
                    {
                        int pop = st.pop();
                        st.push(pop/curNum);
                    }
                    lastSign = c; curNum = 0;
                }
            }

            while(!st.isEmpty()){
                result += st.pop();
            }
            return result;
        }
    }
}
