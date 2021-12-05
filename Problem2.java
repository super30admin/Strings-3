//leetcode 227: Basic Calculator 2
// time - O(n)
// sapce - O(n)
class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack();
        char lastSign = '+';
        int num = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - 48;
            }
            
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1){
                
                if(lastSign == '+'){
                    stack.push(num);
                }
                
                if(lastSign == '-'){
                    stack.push(-num);
                }
                
                if(lastSign == '*'){
                    stack.push(stack.pop() * num);
                }
                
                if(lastSign == '/'){
                    stack.push(stack.pop() / num);
                }
                
                num = 0;
                lastSign = c;
            }
        }
        
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        
        return result;
    }
}