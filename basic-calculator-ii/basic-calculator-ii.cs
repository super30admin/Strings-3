public class Solution {
    public int Calculate(string s) {
        var stack = new Stack<int>();
         char op = '+';
        int num =0;
        
        for(int i=0;i<=s.Length;i++)
        {
            char c = i<s.Length ? s[i] : '+';
            if(c == ' ') continue;
            
            if(char.IsNumber(c))
            {
                num = num *10 + (c-'0');
            }
            else
            {
                if(op =='+') stack.Push(num);
                if(op =='-') stack.Push(-num);
                if(op=='*') stack.Push(stack.Pop() * num);
                if(op =='/') stack.Push(stack.Pop() / num);
                
                op = c;
                num =0;
            }
        }
        
        return stack.Sum();
        
    }
}
