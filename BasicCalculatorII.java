//Time Complexity-O(n) where n is the length of string
//Space Complexity-O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer>stack=new Stack();
        int num=0;
        char sign='+';
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                num=num*10+(ch-'0');
            }
            if((!Character.isDigit(ch)&&
              ch!=' ')||
               i==s.length()-1)
            {
                if(sign=='+')
                {
                    stack.push(num);                    
                }
                else if(sign=='-')
                {
                    stack.push(num*-1);
                }
                else if(sign=='*')
                {
                    num=stack.pop()*num;
                    stack.push(num);
                }
                else if(sign=='/')
                {
                    num=stack.pop()/num;
                    stack.push(num);
                }
                num=0;
                sign=ch;
                
            }
        }
        int output=0;
        while(!stack.isEmpty())
        {
            output+=stack.pop();
        }
        return output;
    }
}