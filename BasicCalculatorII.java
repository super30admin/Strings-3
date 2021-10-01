
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach
1) in this we use the BODMAS rule.
2) however * and / have the precednece from left to right 
3) Thus we make use of numStack to keep check on integer operations
4) lastsign will help us keep track of previous sign. This is to avoid incorrect computation
-> if * and / are two signs present, when we reach / last sign will indicate at * and we can compute the operations first for * and then perform division
5) we start with a positive sign if we do not encounter anything.
6) On line 38 and 42 we use if and not if else, to check if we have reached the end of string. 
-> if we use if and else then if the last number is digit then we might not check for previous operations and then just iterate till end of string and might not compute remaining operations.
*/

import java.util.*;
class BasicCalculatorII {
    public int calculate(String s) {
        
        if(s==null || s.length()==0)
        {
            return 0;
        }
        
        int num=0;
        char lastSign ='+'; // starting with a positive number until we encounter any other sign
        
        int result=0;
        
        Stack<Integer> numStack = new Stack(); // store the integers after every operation to store the precedence as we might encounter + and then *, thus first we perform the * operation and then +
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num= num*10 + c-'0';
            }
         if((!Character.isDigit(c) && c!=' ') || (i==s.length()-1))
            {
                // if the character is not a digit
                // -> it can be a sign or a blank space we just confirm that and also look for the last index. 
                
                if(lastSign =='+')
                {
                    numStack.push(num);
                }
                else if(lastSign=='-')
                {
                    numStack.push(-num);
                }
                else if(lastSign=='*')
                {
                    numStack.push(numStack.pop()*num);
                }
                else // when the sign is division 
                {
                    numStack.push(numStack.pop()/num);
                }
                // resetting the signs and the number for next operation
                lastSign =c;
                num=0;
                
            }
            
            
        }
        
        while(!numStack.isEmpty())
        {
            result+=numStack.pop();
        }
        
        return result;
    }
}