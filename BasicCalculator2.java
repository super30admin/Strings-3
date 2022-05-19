// Time Complexity : O(length of input string)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {

    //Aproach 2 - without stack, store previous values in tail (like problem # 282)

    public int calculate(String s) {

        s = s.trim(); //string may have spaces around

        if(s == null || s.length() == 0)
            return 0;

        //we take care of the current number, last sign, calculated value and tail
        int current = 0;
        char lastSign = '+';
        int calculated = 0;
        int tail = 0;

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);

            //if c is a digit, update current number, multiply by 10 because it could be a multi digit number without any operands in between
            if(Character.isDigit(c))
                current = current*10 + c - '0';

            //if c is an operand or we have hit the end of the string, we need to process
            //there could be spaces in between the string also
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1)
            {
                if(lastSign == '+')
                {
                    calculated += current;
                    tail = current;
                }
                else if(lastSign == '-')
                {
                    calculated -= current;
                    tail = -current;
                }
                else if(lastSign == '*')
                {
                    calculated = calculated - tail + tail * current;
                    tail = tail * current;
                }
                else
                {
                    calculated = calculated - tail + tail / current;
                    tail = tail / current;
                }
                //reset current to 0
                current = 0;
                //update last sign to current c
                lastSign = c;
            }
        }

        return calculated;
    }
}
