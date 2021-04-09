class BasicCalculatorII {
    
    // Time Complexity: O(n)    (where n -> length of the string)
    // Space Complexity: O(k)   (where k -> no. of operators in the string)
    
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int i = 0;
        
        while(i < n){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            
            if(c != ' ' && !Character.isDigit(c) || i == n - 1){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(num * -1);
                }else if(sign == '*'){
                    int temp = stack.pop();
                    stack.push(temp * num);
                }else if(sign == '/'){
                    int temp = stack.pop();
                    stack.push(temp / num);
                }
                
                num = 0;
                sign = c;
            }
            i++;
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        return result;
    }
}