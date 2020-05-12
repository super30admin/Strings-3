class Solution {
    public int calculate(String s) {
        
        if (s.length() == 0) return 0;
        
        int num = 0;
        char sign = '+';
        
        int size = s.length();
        
        Stack<Integer> stack = new Stack<>();
        
        for ( int i = 0; i < size; i++){
            
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }   
            
            if (!Character.isDigit(ch) && ch != ' ' || i == size - 1) {
                if (sign == '+'){
                    stack.push(+    num);
                }else if (sign == '-'){
                    stack.push(num * -1);
                }else if (sign == '*'){
                    stack.push(stack.pop() * num);
                }else if (sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }
        
        int ret_Val = 0;
        while(!stack.isEmpty()){
            ret_Val += stack.pop();
        }
       return ret_Val; 
    }
}