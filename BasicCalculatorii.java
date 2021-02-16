// Time Complexity : O(n) n is length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
package Strings-3;

public class BasicCalculatorii {
    class Solution {
        public int calculate(String s) {
         int currNum = 0;
         int prevNum = 0;
         int result = 0; 
         char operation = '+';
            for(int i=0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if(Character.isDigit(c))
                {
                   currNum = currNum*10 + Integer.parseInt(String.valueOf(c)); 
                } 
                if(!Character.isDigit(c) && c!=' ' || i ==s.length()-1)
                {
                    if(operation == '+' || operation == '-')
                    {
                        result += prevNum;
                        prevNum = (operation == '+')? currNum : -currNum;
                    }else if(operation == '*')
                    {
                        prevNum = prevNum * currNum;
                    }else if(operation == '/')
                    {
                        prevNum = prevNum / currNum;
                    }
                    
                    operation = c;
                    currNum = 0;
                }
            }
            result+=prevNum;
            return result;
            
        }
    }
}
