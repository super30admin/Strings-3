// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//use stack to keep the values
//keep track of sign. Add values based on sign character.

class Solution {
    public int calculate(String s) {
 //T: O(N) ietrate over all the string elements of length N 
 //S: O(N) for the stack that we maintain       
        //base check
        if(s == null || s.length() == 0) return -1; //ask interviewer
        
        //need stack to store elements
        Stack<Integer> stack = new Stack<>();
        
        char sign = '+';
        int value = 0;
        int i = 0; //starting pointer
        
        int result = 0;
        
        //iterate over the length of the string to access each character
        while(i< s.length()){
            
            char ch = s.charAt(i);
            
            //check if character is digit
            if(Character.isDigit(ch)){
                value = value * 10 + ch - '0';
            }
            
            //if character is not digit means a sign then do the following:
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if(sign == '+')
                    stack.push(value);
                
                if(sign == '-')
                    stack.push(-value);
                
                if(sign == '*')
                    stack.push(stack.pop() * value);
                
                if(sign == '/')
                    stack.push(stack.pop() / value);
               
                //reinitialize value and sign
                value = 0;
                sign = ch;
            }
            i++;
            
        }
        
        //pop and add elements one by one from stack
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        return result;
    }
}