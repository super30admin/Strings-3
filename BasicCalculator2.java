/*
The following solution implements a basic calculator using running sum. At each step in the expression, a cumulative sum, the 
last element used in the calculation of the primitve sum and the sign before this element is recorded. Using this information, 
according to the operator precedence the expression is evaluated.

This can also be done using a stack in O(n) space where n is the number of elements in the expression, and is useful for evaluating
the expression with brackets.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(n) where n is the length of the expression
    //Space Complexity: O(1)
    public int calculate(String s) {
        //By default we set the current sum, number and tail number to 0 and sign to +
        int currNum = 0;
        int tailNum = 0;
        int currSum = 0;
        char lastSign = '+';
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                currNum = currNum * 10 + c - '0';
            }
            //We account for spaces, and also evaluate if the pointer is at the end of the expression
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1)
            {
                if(lastSign == '+')
                {
                    currSum += currNum;
                    tailNum = currNum;
                }
                else if(lastSign == '-')
                {
                    currSum -= currNum;
                    tailNum = -currNum;
                }
                //For the multiply and divide operators, we backtrack to the previous current sum without the last tail number, 
                //so that we can give these operators precedence and use these operations on the latest number.
                //Consequently the tail number now gets multiplied by the current number to become the new tail, to anticipate
                //for further multiply and divide operations, if any.
                else if(lastSign == '*')
                {
                    currSum = currSum - tailNum + tailNum * currNum;
                    tailNum *= currNum;
                }
                else if(lastSign == '/')
                {
                    currSum = currSum - tailNum + tailNum / currNum;
                    tailNum /= currNum;
                }
                //Whenever we are at an operator, after evaluating the expression so far store the latest sign and reset the current number
                lastSign = c;
                currNum = 0;
            }
        }
        
        return currSum;
    }
}