// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n) Stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Push the operands into the stack as you encounter an opeartor. The previous number
is pushed into the stack and the last seen sign is always updated according to the sign of the previous number. To maintain the prcedence of 
multiplication and division operator, as you encounter the sign, pop from the stack and apply the corresponding operation and push the result as
they need to be completed first on priority operators. The last operand is always pushed into the stack. At the end add all the stack elements.
*/
class Solution {
    public int calculate(String s) {
        if(s== null || s.length() == 0){return 0;}
        Stack<Integer> stk = new Stack<>();
        char lastSign = '+';                                                                            // Initially
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10 * num + (c - '0');                                                                 // if a number convert to int
            } 
                if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                    if(lastSign == '+') stk.push(num);                                                      // If operator, push into the stack
                    else if(lastSign == '-') stk.push(-num);
                    else if(lastSign == '*') {
                       stk.push(stk.pop() * num);                                                       // If priority operator, push the result
                    }
                    else if(lastSign == '/') {
                       stk.push(stk.pop()/num); 
                    }
                    num  = 0; 
                    lastSign = c;                                                                   // Reset the number and update the last seen sign always
                }
        }
        int result  =0;
        while(!stk.isEmpty()){
            result+=stk.pop();                                                                  // At the end, sum all the stack elements
        }
        return result;
    }
}