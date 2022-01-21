// Time complexity : O(n)
// Space Complexity : O(n) :Stack

class Solution {
    public int calculate(String s) {
        
        
        // Create a stack to store the delayed operands
        Stack<Integer> stack = new Stack<>();
        
        // Current Number  
        int num = 0;
        // Current sign
        char lastSign = '+';
        
        // Iterate through each character in the string (expression)
        
        for (int i = 0; i < s.length() ; i++){
            
            // Current character at i index
            char c = s.charAt(i);
            
            // ASCII value check whether it is upper case or lower case
            
            // If c is a number (0-9 digits)
            if (c >= 48 && c <= 57){
                
                // The digits can end up having 
                num =  num * 10 + (c -  48); //0 -> c-48;
            }
            
            // If c is an operator 
            // At the last character, we need to consider that number as the second operand
            if ( c == '*' || c == '/' || c == '-' || c == '+' || i == s.length() - 1){
                
                if ( lastSign == '+'){
                    stack.push(num);
                }
                
                else if ( lastSign == '-'){
                    stack.push(num * -1);
                }
                
                else if ( lastSign == '*'){
                    stack.push(num * stack.pop());
                }
                
                
                else if ( lastSign == '/'){
                    stack.push(stack.pop() / num);
                }
                
                // reset the number as the current character is an operator
                num = 0;
                lastSign = c;
            }
                
        }
        
        // All the + and - are delayed earlier , adding the elements in the stack will evaluate the expression
        while (!stack.isEmpty()){
            
            num = num + stack.pop();
            
        }
        
        return num;
    }
}