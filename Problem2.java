class Solution {
    public int calculate(String s) {
        // If length = 0 , return 0
        
        if(s.length() == 0) return 0;
        
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int i = 0 ;
        
        while(i < s.length()){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                num = num * 10 +(ch - '0');
            }
            
            if(ch != ' ' && !Character.isDigit(ch) || i == s.length() - 1){
                
                if(sign == '+'){
                    stack.push(num);
                }
                else if(sign == '-'){
                    stack.push(num* -1);
                }
                else if(sign == '*'){
                    int temp = stack.pop();
                    stack.push(num * temp);
                }
                else if(sign == '/'){
                  int temp = stack.pop();
                    stack.push(temp / num);  
                }
                num = 0 ;
                sign = ch;
            }
            i++;
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
} // TC O(n) , SC - Stack size which is O(n) in worst case scenario
