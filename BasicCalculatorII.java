//Problem 100: Basic Calculator II
//TC:O(n), n is string length 
//SC: O(n/2)=> n, because in stack we will have only numbers which are half the length of the string 

/*
  As I have to follow BODMAS using lastPrecedence, i.e Stack DS is required
  Manintaing two variables , one is lastSign and other one is num. Whenever an expression is hitted or u r at last index of the string, just process the num according to the lastSign. After processing the number reset the num to 0 and lastSign to current character.
  if lastSign = '+' or '-', insert the number in stack according to their sign
  if lastSign = '/' or '*', pop the element from stack , multiply it with the number and then insert the result in stack.

  In last empty the stack as astack will contain only + & - numbers
  Eg: "4+2*3-8/2"
*/

import java.util.*;
class Solution100 {
    public int calculate(String s) {
        
        if(s==null || s.length()==0) return 0;
        
        Stack<Integer> numStack = new Stack<>();
        char lastSign = '+';
        int num = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                num = num*10+ch-'0';
            }
            
            //process the numbers with respect to the last sign if we hit an expression or we are at last index
            if((!Character.isDigit(ch)&& ch!=' ') || i==s.length()-1){
                
                if(lastSign=='+') numStack.push(num);
                else if(lastSign=='-') numStack.push(-num);
                else if(lastSign=='*'){
                   numStack.push(numStack.pop()*num);   
                }else if(lastSign=='/'){
                    numStack.push(numStack.pop()/num);   
                }
                
                lastSign = ch;
                num = 0;
            }
            
        }
        
        int result = 0;
        while(!numStack.isEmpty()){
            result += numStack.pop();
        }
        
        return result;
    }
}