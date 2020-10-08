/*
 * #227. Basic Calculator II
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:

Input: " 3+5 / 2 "
Output: 5

Note:

1. You may assume that the given expression is always valid.
2. Do not use the eval built-in library function.

 */


/*
 * Time Complexity: O (N) -> To traverse 'N' number of characters in a string
 * 
 * Space Complexity: O (N) -> Stack to store the 'N' numbers with its sign
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.strings3;

import java.util.Stack;

public class BasicCalculator2 {
	public int calculate(String s) {
        
        // #1. Base condition
        if(s == "" || s.length() == 0){
            return 0;
        }
        
        // #2. Create a stack to store the numbers with only '+' or '-' preceeding sign,
        // for '*' or '/' signs, pop number from stack, perform operation and then push back the result in stack 
        Stack<Integer> stack = new Stack<Integer>();
        
        // #3. Initialize the 'num' and 'last_sign' variables
        int num = 0;
        char last_sign = '+';
        
        // #4. Traverse through the given string -> simple expression and compute the result
        for(int i = 0; i < s.length(); i++){
            
            // Get the current character from given string
            char ch = s.charAt(i);
            
            // If character is a digit
            if(Character.isDigit(ch)){
                // compute the current num
                // (ch - '0') -> converts the character 'ch' to integer by subtracting ASCII value of '0' from current character 'ch'
                num = num * 10 + (ch - '0');
            }
            
            /*
            * Instead of 'else if', we are using 'if' to handle the case when we reached last digit 
            * If we had used else if(), then at the last digit, first if() statement would have executed and we would have to handle this case out of for loop after going out of bounds
            */
            
            
            // If the character is an operator or we are at the last digit in a string
            // If character is a space, just skip it
            
            /*
            * If character is an operator, then do two things:
            *   1. Check the last_sign
            *           If '+' or '-', then push the number with sign in a stack
            *           If '*' or '/', then pop the top from stack, multiply it with current num and push back to the stack
            *   2. Reset the num to 0 because new digit will be encountered after operator and change last_sign to current character(operator)
            */
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                // 1. 
                if(last_sign == '+'){
                    stack.push(num * 1);
                }else if(last_sign == '-'){
                    stack.push(num * -1);
                }else if(last_sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(last_sign == '/'){
                    stack.push(stack.pop() / num);
                }
                
                // 2. 
                num = 0;
                last_sign = ch;
            }
                
        }
        
        // #5. Pop from the stack and add the numbers until it is empty
        int output = 0;
                   
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        
        return output; // return the output
        
            
    }

}
