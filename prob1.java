//TC:o(n)
//sc:o(n)

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        if(s.length()==0) return 0;
        
        int num=0;
        char sign = '+';
        for(int i=0;i<s.length();i++)
        {
           char ch = s.charAt(i);
           if(Character.isDigit(ch))
              num=num*10+(ch-'0');
           else if(ch!=' ')
           {
             if(sign=='+') 
                stk.push(0+num);
             else if(sign=='-')
                 stk.push(0-num);
             else if(sign=='*')
                 stk.push(stk.pop()*num);
             else if(sign=='/')
                 stk.push(stk.pop()/num);
             
               sign =ch;
               num=0;
           }  
        }
        
        if(sign=='+')
            stk.push(num);
        else if(sign=='-')
             stk.push(0-num);
        else if(sign=='*')
              stk.push(stk.pop()*num);
        else if(sign=='/')
              stk.push(stk.pop()/num);
        
       int val =0;
        while(!stk.isEmpty())
        {
         val=val+stk.pop();
        }
      
      return val;
    }
}