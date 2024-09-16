class BasicCalculatorII {
    // Approach 1 - using stack
    // Time complexity - O(n)
    // Space complexity - O(n)
    // Tested in leetcode
    
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int i=0;
        char sign = '+';
        int temp = 0;
        
        // iterate upto string's length
        while(i < s.length()){
            // when character is a digit then store into a temp variable 
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                temp = temp * 10 + (c - '0');
            }
            
            // when '+' / '-' operator is found then push the temp value into stack 
            // otherwise pop element from the stack, perform operation between popped element and temp and push back to stack.
            if((!Character.isDigit(c)  && c != ' ') || i == s.length()-1){
                if( sign == '+' ){
                    stack.push(+temp);
                }
                else if( sign == '-'){
                    stack.push(-temp);
                }
                else if(sign == '*' || sign == '/'){
                    int p = stack.pop();
                    if(sign == '*'){
                        stack.push(+(p*temp));
                    }
                    else
                        stack.push(+(p/temp));
                } 
                 temp = 0;
                 sign = c;
            }
            i++;
        }
        
       int ans =0;
        // add all variables of stack and return the result
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}