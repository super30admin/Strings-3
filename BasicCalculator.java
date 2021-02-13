class BasicCalculator {
    /*
      Time : O(N) | N - length of a string
      Space : O(N/2) ~ O(N) | Space for stack. | half of the space will be consumed by the operators and half by digits
      Leetcode : YES
      
    */
    
    /*
      Approach
      1. Start scanning from left to right.
      2. if it is a digit then multiply it by 10 and add it to the current number;
      3. if it is a operator then check what was the prev operator. 
      4. if prev operator was multiply or divide then we have to perfor operation immidiately,
         hence pop last element and perform operation push back result to stack.
      5. if prev is + or - then add num directly to the stack.
      6. imp to remember to check if i == last element, if so then anyways we have to perform then operation.
      7. Finally add everything back to the result.
    */
    public int calculate(String s) {
        if(s == null || s.length() == 0) return -1;
        
        Stack<Integer> stk = new Stack<>();
        int num = 0;
        char prev = '+';
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            
            if((c == '*' || c == '/' || c == '+' || c == '-') || i == s.length() -1){
                if(prev == '*'){
                    stk.push(num * stk.pop());             
                }else if(prev == '/'){
                    stk.push(stk.pop() / num);
                }else if(prev == '-'){
                    stk.push(-num);
                }else{
                    stk.push(num);
                }
                prev = c;
                num = 0;
            }   
        }
        
        int result = 0;
        while(!stk.isEmpty()){
            result += stk.pop();
        }
        
        return result;
    }
}
