class BasicCalculator {

   /**

    Time Complexity: O(n)
      n -> s.length
      
    Space Complexity: O(1)

    Were you able to solve this on leetcode? Yes
    */
    public int calculate(String s) {
      char lastSign = '+';
      int curr = 0;
      int calc = 0;
      int tail = 0;
      
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          
          if(Character.isDigit(c)){
              curr = curr * 10 + c - '0';
          }
          
          if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
              if(lastSign == '+') {
                  calc += curr;
                  tail = curr;
              } else if (lastSign == '-') {
                  calc -= curr;
                  tail = -curr;
              } else if (lastSign == '*') {
                  calc = (calc - tail) + (tail * curr);
                  tail = tail * curr;
              } else {
                  calc = (calc - tail) + (tail / curr);
                  tail = tail / curr;
              }
              
              curr = 0;
              lastSign = c;
          }
      }
      
      return calc;
    }

    /**

    Time Complexity: O(n)
      n -> s.length
      
    Space Complexity: O(n)

    */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        int curr = 0;
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') continue;
        
            if(Character.isDigit(c)){
                curr = curr * 10 + (c - '0');
            } 
        
            if(i == s.length()-1 || !Character.isDigit(c)){
                // the character is a sign
                if(lastSign == '*'){
                    curr = curr * stack.pop();
                    stack.push(curr);
                } else if (lastSign == '/'){
                    curr = stack.pop() / curr;
                    stack.push(curr);
                } else {
                    // last sign is + or -
                    if(lastSign == '+'){
                        stack.push(curr);
                    } else {
                        stack.push(-1 * curr);
                    }
                }
            
                lastSign = c;
                curr = 0;
            }
        }
    
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
    
        return result;
    }
}