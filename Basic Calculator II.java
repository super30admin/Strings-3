// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will maintain four vaiables curr to store the current value, LastSign to store the expression, calculated value to store the value 
// calculated so far and tail to maintain the last value in the string.
// Everytime we encounter an expression, we will reset curr to 0. and perform the operation with the calculated value.
// Whenever we encounter multiplication, we will find the calculated value by subtracting it with tail and then add the product of tail and current with it. 

class Solution {
    public int calculate(String s) {
        if(s==null) return 0;
        s.trim();
        int curr=0;
        char lastSign='+';
        int calc=0;
        int tail=0;
        int n=s.length();
      
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))        //if it is a number
            {
                curr=curr*10 + c-'0';
            }
            
            //if the character is an expression
            if((!Character.isDigit(c) && c!=' ') || i==n-1)
            {
                if(lastSign=='+')
                {
                    calc=calc+curr;
                    tail=curr;
                }
                else if(lastSign=='-')
                {
                   calc=calc-curr;
                   tail=-curr;
                }
                else if(lastSign=='*')
                {
                   calc=calc-tail+(tail*curr);
                   tail=tail*curr;
                }
                else
                {
                    calc=calc-tail+(tail/curr);
                    tail=tail/curr;
                }
                //reset curr to 0
                curr=0;
                lastSign=c;
            }
        }
        return calc;
    }
}