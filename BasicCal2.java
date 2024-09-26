/*

Passed All Test Cases 

Time-> O(2N) -> O(N), N is # of characters in string
Space-> O(N), N is # of characters in string 

*/
class Solution {
    public int calculate(String s) {
        //cleaning string 
        s = s.replace(" ", "") ; 
        
        int value = 0 ; 
        char sign = '+' ; 
        
        int ans = 0 ; 
        
        Stack<Integer> stack = new Stack<>() ; 
        
        for (int i = 0 ; i < s.length() ; i++) {
            
            char check = s.charAt(i) ; 
            
            if(Character.isDigit(check)) {
                value = value * 10 + (check - '0') ; 
            }
            
            if(!Character.isDigit(check) || (i == s.length() - 1)) {
                
                if(sign == '+') {
                    stack.push(value) ; 
                } 
                else if(sign == '-') {
                    stack.push(-value) ; 
                } 
                else if (sign == '*') {
                    stack.push(stack.pop() * value) ; 
                } 
                else if (sign == '/') {
                    stack.push(stack.pop() / value) ; 
                }
                
                sign = check ; 
                
                value = 0 ; 
            }
        }
            
            while (!stack.isEmpty()) {
                ans += stack.pop() ; 
            }
            
            return ans ; 
        }
}