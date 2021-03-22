/**
 * TC: O(N)
 * SC: O(N)
 * Approach: The precedence of * and / is greater than + and -
 *           So in an arithmetic expression, * and / operations have to be evaluated first 
 *           So use a stack to store all the operands on whom + or - have to be performed
 *           If we see a * or / pop from the stack and complete the operation with currentNumber
 *           This way, all * and / operations are evaluated first
 *           Store - operation as a negative number on the stack
 *           After passing through the string and evaluating * and / operations, and pushing operands on the stack,
 *           empty the stack by adding all the operands
 */

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> operands = new Stack<>();
        int answer = 0, currentNumber = 0;
        char lastOperation = '+';
        
        for(int i = 0 ; i < s.length() ; i++) {
            // get current character
            char currentCharacter = s.charAt(i);
            
            // if current character is a digit then build the current number
            if(Character.isDigit(currentCharacter)) {
                currentNumber = currentNumber * 10 + (currentCharacter - '0');
            }
            
            // if current character is not a digit or whitespace or we have reached the end of the string then look
            // at the last operation and process it
            if((!Character.isDigit(currentCharacter) && currentCharacter != ' ') || (i == s.length() - 1)) {
                // if addition then push the currentNumber on the stack
                if(lastOperation == '+') {
                    operands.push(currentNumber);
                }
                // if subtraction then negate the currentNumber and push on the stack
                else if(lastOperation == '-') {
                    operands.push(-currentNumber);
                }
                // if last operation is multiplication then pop from the stack and complete the operation and push again
                else if(lastOperation == '*'){
                    operands.push(operands.pop() * currentNumber);
                }
                // if last operation is division then pop from the stack and complete the operation and push again
                else if(lastOperation == '/'){
                    operands.push(operands.pop() / currentNumber);
                }
                // reset current number
                currentNumber = 0;
                // remember current operation as last operation
                lastOperation = currentCharacter;
            }
        }
        
        // build the answer
        while(!operands.isEmpty()) {
            answer += operands.pop();
        }
        
        return answer;
        
    }
}
