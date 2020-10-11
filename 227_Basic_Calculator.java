    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/basic-calculator-ii/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(n-k) .. k is number of operators in thee string 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Traverse to string. If it is digit then do (prev = prev * 10 + (ch-'0');) this is just to handle two digit noo
                    B) if it is not digit and not a space
                       then check it sign is +, if it is then push (num*1) on stack
                       then check it sign is -, if it is then push (num*(-1)) on stack
                       then check it sign is *, if it is then push (stack.pop()/(num))  on stack
                       then check it sign is /, if it is then push (stack.pop()*(num)) on stack
                    C) In loop lastly, change last sign to ch and reset number.
                    D) At the end, do sum of all elemets in stack and return it.
    */  

class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        char last_sign = '+';
        for(int x=0;x<s.length();x++){
            char ch = s.charAt(x);
            
            if(Character.isDigit(ch)){
                prev = prev * 10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ')|| x == s.length()-1){
                
                if(last_sign == '+'){
                    stack.push(prev * 1);
                }else if(last_sign == '-'){
                    stack.push(prev * (-1));
                }else if(last_sign == '*'){
                    stack.push(stack.pop() * (prev));
                }else if(last_sign == '/'){
                    stack.push(stack.pop() / (prev));
                }
                
                last_sign = ch;
                prev = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        return result;
    }
}