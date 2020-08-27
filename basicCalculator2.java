// Time O(n)
// Space O(n)

class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        Stack<Integer> stack=new Stack<>();
        int curr=0;
        char lastsign='+';
        
        HashSet<Character> operator = new HashSet<>();
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
        
        for(int i=0;i<s.length();i++)
        {
            /* get the number */
            
            char c=s.charAt(i);
            
            if(Character.isDigit(c))
            {
                curr=curr*10 + c - '0';
            }
            
            if(operator.contains(c) || i==s.length()-1) 
            {
                if(lastsign=='*')
                {
                    stack.push(stack.pop() * curr);
                }
                else if(lastsign=='/')
                {
                    stack.push(stack.pop() / curr);
                }
                else if(lastsign=='-')
                {
                    stack.push(-1*curr);
                } else
                {
                    stack.push(curr);
                }
                
                lastsign=c;
                curr=0;
            }
        }
        
        /* Go over all stack elements */
        int result=0;
        while(!stack.isEmpty())
        {
            result+=stack.pop();
        }
        
        return result;
    }
}