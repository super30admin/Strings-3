// Time Complexity : o(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        
        if(s==null||s.length()==0)
            return 0;
        
        Stack<Integer> stack=new Stack<>();
        
        s=s.trim()+'+';
        s=s.replace(" ","");
        
        int result=0;
        
        int num=0;
        char lastSign='+';
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            //if its digit
            if(Character.isDigit(ch))
                num=num*10+ch-'0';
            // not a digit 
            else
            {
                if(lastSign=='+')
                {
                    stack.push(num);
                }
                else if(lastSign=='-')
                {
                    stack.push(-num);
                }
                else if(lastSign=='*')
                {
                    stack.push(stack.pop()*num);
                }
                else
                {
                    stack.push(stack.pop()/num);
                }
                num=0;
                lastSign=ch;
            }
        }
        
        while(!stack.isEmpty())
        {
            result+=stack.pop();
        }
        return result;
    }
}