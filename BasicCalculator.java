/*
 * Time complexity : O(n)
 * Space complexity : O(n)
 * 
 */
class Solution {
    public int calculate(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
    
        Stack<Integer> stack = new Stack<Integer>();
        
        char currentSign = '+';
        int currentNum = 0;
        
        for(int i=0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currentNum = currentNum * 10 + ch - '0';  
               
            }
            
            if((!Character.isDigit(ch) && (ch != ' ')) || (i == s.length()-1)){
                
                if(currentSign == '+'){
                    stack.push(currentNum);
                }else if(currentSign == '-'){
                    stack.push(-currentNum);
                }else if(currentSign == '*'){
                    stack.push(stack.pop() * currentNum);
                }else if(currentSign == '/'){
                    stack.push(stack.pop() / currentNum);
                }
                
                currentSign = ch;
                currentNum = 0;
                
            } 
        }
        
        
        int sum = 0;
        while(!stack.isEmpty()){
            sum = sum + stack.pop();
        }
        
        return sum;
    }
}