// Leetcode : 227, Basic Calculator 2

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        char sign = '+';
        int num = 0;
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            
            if(ch != ' ' && !Character.isDigit(ch) || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(num);
                }
                else if(sign == '-'){
                    stack.push(num * -1);
                }else if(sign == '*'){
                    int val = stack.pop();
                    stack.push(num * val);
                }else if(sign == '/'){
                    int val = stack.pop();
                    stack.push(val / num);
                }
                num = 0;
                sign = ch;
            }
            i++;
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}