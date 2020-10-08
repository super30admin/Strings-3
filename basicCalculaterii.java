//Time Complexity: O(n)
//Space Complexity: O(n) for stack
//Did run on leetcode: yes
/** Approach: each time we keep number and last_sign
    if the char is not digit then
    if last_sign is + or -, push the num with acc to last_sign
    if * or / then pop stack perform operation based on last_sign
    after each operation reset num to 0 and update last_sign to current ch
    in the end add all the elements of stack and return the sum**/

class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        int num = 0;
        char last_sign = '+';
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
                num = num*10 + (ch - '0');
            
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(last_sign=='+'){
                    stack.push(num*1);
                }else if(last_sign=='-'){
                    stack.push(num*-1);
                }else if(last_sign=='*'){
                    stack.push(stack.pop()*num);
                }else if(last_sign=='/'){
                    stack.push(stack.pop()/num);
                }
                
                num = 0;
                last_sign = ch;
            }
        }
        
        int output = 0;
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        
        return output;
    }
}
