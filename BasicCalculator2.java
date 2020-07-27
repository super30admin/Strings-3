/**
 * Time complexity : O(n) where n = length of the string
 * Space Complexity : O(n) where n = Numbers without sign
 */

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        int sign = '+';
        int n = s.length();
        for(int i = 0 ; i < s.length() ; i ++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c!= ' ') || i ==n-1 )
            {
                if(sign == '+') st.push(num);
                else if(sign == '-') st.push(-1 * num);
                else if(sign == '*') st.push(st.pop() * num);
                else if(sign == '/') st.push(st.pop()/num);
                num = 0; sign = c;
            }
        }
        int sum = 0;
        while(!st.isEmpty())
        {
            sum = sum + st.pop();
        }

        return sum;
    }
}