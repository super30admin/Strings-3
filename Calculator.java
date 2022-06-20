/**
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int calculate(String s) 
    {
        
        if(s == null || s.trim().length() == 0)
            return 0;
        
        s = s.trim();
        int length = s.length();
        
        char operation = '+';
        char input[] = s.toCharArray();
        
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i < length; i++)
        {
            char ch = input[i];
            
            if(ch != ' ')
            {
                boolean isDigit = Character.isDigit(ch);
                
                if(isDigit)
                {
                    int currentDigit = Integer.parseInt(ch+"");
                    current = current * 10 + currentDigit;
                }
                
                if(!isDigit || i == length -1)
                {
                    switch(operation)
                    {
                        case '+':
                            stack.push(current);
                            break;
                        case '-':
                            stack.push(-current);
                            break;
                        case '*':
                            stack.push(stack.pop() * current);
                            break;
                        case '/':
                            stack.push(stack.pop() / current);
                            break;
                    }
                    
                    operation = ch;
                    current = 0;
                }
            }
        }
        
        int result = 0;
        while(!stack.isEmpty())
        {
            result = result + stack.pop();
        }
        
        return result;
        
        
    }
}