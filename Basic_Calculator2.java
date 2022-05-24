//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int calculate(String s) {
        
   
        if(s == null || s.length()==0)
            return 0;
        
        Stack<Integer> stk = new Stack<>();
        
        char sign = '+';
        int value = 0;
        int i=0;
        
       while(i<s.length())
       {
           char ch = s.charAt(i);
           //check if the char is a digit
           if(Character.isDigit(ch))
           {
               value = value * 10 + (ch - '0');
           }
           
           //if there is a space at last we still want to do the calculations ==> i==s.length()-1
           if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1)
           {
               if(sign == '+')
                   stk.push(value);
               if(sign == '-')
                   stk.push(-value);
               if(sign == '*')
                   stk.push(stk.pop() * value);
               if(sign == '/')
                   stk.push(stk.pop() / value);
               
               //reseting the value for next digit
               value = 0;
               sign = ch;
           }
           
           i++;

       }
       
        int result = 0;
        while(!stk.isEmpty())
            result = result + stk.pop();
        
        return result;
    }
}
