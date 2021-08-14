// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Iterative approach using stacks
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        s = s.trim() + '+';
        s = s.replace(" ", "");
        
        int result = 0;
        int num = 0;
        char lastSign = '+';
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            //digit
            if(Character.isDigit(c)){
                
                //in order to get ascii value of c we need to subtract by ascii of 0
                num = num * 10 + c - '0';
            }
            //not a digit or last character
            else{
                if(lastSign == '+'){
                    stack.push(num);
                }
                else if(lastSign == '-'){
                    stack.push(-num);
                }
                else if(lastSign == '*'){
                    stack.push(stack.pop() * num);
                }
                else if(lastSign == '/'){
                    stack.push(stack.pop() / num);
                }
                
                num = 0;
                lastSign = c;
            }
        }
        
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}