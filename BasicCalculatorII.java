package org.example;

// Time Complexity : O(n) -> n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class BasicCalculatorII {

    public int calculate(String s) {
        int curNum = 0;
        int calc = 0;
        int tail = 0;
        char lastSign = '+';

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curNum = curNum*10 + c - '0';
            }

            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1)
            {
                if(lastSign == '+')
                {
                    calc += curNum;
                    tail = curNum;
                }
                else if(lastSign == '-')
                {
                    calc -= curNum;
                    tail = -curNum;
                }
                else if(lastSign == '*')
                {
                    calc = calc-tail+(tail * curNum);
                    tail = tail * curNum;
                }
                else if(lastSign == '/')
                {
                    calc = calc-tail+(tail / curNum);
                    tail = tail / curNum;
                }
                curNum = 0;
                lastSign = c;
            }
        }

        return calc;
    }
}
