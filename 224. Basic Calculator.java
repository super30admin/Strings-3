class Solution {// Time and space of O(N)
    int result= 0;
    int idx = 0;
    int num = 0;
    int min = Integer.MIN_VALUE;
    int sign = 1 ; // 1 for positive , -1 for negative
    public int calculate(String s) {
      //Base case 
        if(s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>(); 
        
        while(idx < s.length()){
            char c  = s.charAt(idx);
           // System.out.println(c);
            {
             if(Character.isDigit(c)){
                    num = num*10 + (c -'0');
                    
                }
             if(!Character.isDigit(c) && c != ' '|| idx == s.length() - 1){
                 
                 if(c == '('){
                     stack.push(sign);
                     //System.out.print(sign);
                     sign = 1;
                     stack.push(min);
                     
                 }
                else if(sign == 1){
                     stack.push(num);
                     }
                 else if(sign == -1){
                     stack.push(-num);
                     }
                 if(c == ')' ){
                 while(!stack.isEmpty() && stack.peek() != min){
                     result += stack.pop();
                 }
                 stack.pop();
                 stack.push(stack.pop()*result);                 
             }
                num = 0 ;
                result = 0;
                
              //" 2-1 + 2 "  
                 if(c== '+'|| c =='-'){
                     sign = c=='+'? 1:-1 ;
                 }
            }
            idx++;
          }
        }
        
        while (!stack.isEmpty() && stack.peek() != min ){
            result += stack.pop();
        }
        return result;
    }
   
}
//"   (  3 ) "   "(1+(4+5+2)-3)+(6+8)   "2-(5-6)""