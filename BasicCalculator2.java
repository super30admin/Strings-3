/*
time complexity: O(n)
space complexity:O(n)

take the first default sign as '+'
traverse the string, if ch is digit then keep updating the num by. num * 10 + ch - '0'.
if ch is not digit or i has reach last char of string then process the num 
if sign is '+', just add num to stack
if sign is '-', just add -num to stack
if sign is '*', pop from stack and multiply with num and push back to stack
if sign is '/', pop from stack and divide with num and push back to stack

reset sign = '+'
and num to 0

Finally pop all items from stack and add to result.


*/
class Solution {
    public int calculate(String s) {
        if(s.length() == 0 || s == null)return 0;
        
        Stack<Integer>stack = new Stack<>();
        int num = 0;
        int result = 0;
        char lastSign = '+';   
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            
            if((!Character.isDigit(ch) && ch != ' ') || (i == s.length()-1)){
                if(lastSign == '+'){
                    stack.push(num);
                }
                else if(lastSign == '-'){
                    stack.push(-num);
                }else if(lastSign == '*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop()/num);
                }
                lastSign = ch;
                num =0;
            }
        }
        
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        return result;
    }
}