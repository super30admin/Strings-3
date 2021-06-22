//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//logic to add only the integers in the stack and process the signs * and / before entering the integers in stack to maintain the precedence.
Solution {
    public int calculate(String s) {
        
        if(s.length() == 0){
            
            return 0;
        }
        s = s.trim();
        char lastSign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            
            char ch = s.charAt(i);
            
      
            
            if(Character.isDigit(ch)){
                
                int temp = ch - '0';
                num = num * 10 + temp;
            }
            
            if(ch != ' ' &&(!Character.isDigit(ch) || i == s.length() - 1)){
                
                if(lastSign == '+'){
                    
                   stack.add(num);
                   // num = 0;
                }
               else if(lastSign == '-'){
                    stack.add(-num);
                   //num = 0;
                    
                }
               else if(lastSign == '*'){
                    
                   int temp1 = stack.pop();
                   temp1 = temp1*num;
                   stack.add(temp1);
                    
                }
              else if(lastSign == '/'){
                    int temp2 = stack.pop();
                   temp2 = temp2/num;
                   stack.add(temp2); 
                    
                }
                
                num = 0;
                lastSign = ch;
            }
        }
        int result = 0;
   //     System.out.println(stack);
        while(!stack.isEmpty()){
            
            result = result + stack.pop();
        }
        
        return result;
    }
}