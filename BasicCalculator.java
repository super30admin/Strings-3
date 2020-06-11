import java.util.*;

/**
 * Time complexity: O(N) where N is length of String
 * Space complexity: O(N)
 * 
 * Approach:
 * 1. Add integers in stack if the sign is +. If sign is -, add negative number to stack.
 * 2. If sign is * or /, pop the last integer from the stack, compute the * or / operation and add the result
 * into the stack.
 * 3. At the end, add all numbers in the stack which is the final result.
 */

class BasicCalculator {
    public int calculate(String s) {
        int result = 0;
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        char lastSign = '+';
        int num = 0;
        int n = s.length();
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);  
            if(Character.isDigit(c)) {
                num = num*10 + (c-'0');
            }
            if(!Character.isDigit(c) && c != ' ' || i == n-1){
                if(lastSign == '+') {
                    stack.push(num);
                }
                else if(lastSign == '-') {
                    stack.push(-num);
                }
                else if(lastSign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if(lastSign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                num = 0;
                lastSign = c;
            }
            
        }
        
        while(!stack.isEmpty()) {
            result += stack.pop();        }
        
        return result;
    }
}