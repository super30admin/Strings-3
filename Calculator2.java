class Solution {
    //Time O(N)
    //Space O(N)
    public int calculate(String s) {
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char LastSign = '+';
        int num = 0;
        s = s.trim();
        for(int i=0 ; i<s.length() ; i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num*10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length()-1))
            {
                if(LastSign == '+') stack.push(num);
                else if(LastSign == '-') stack.push(-num);
                else if(LastSign == '*') stack.push(stack.pop()*num);
                else if(LastSign == '/') stack.push(stack.pop()/num);
                LastSign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty())
        {
            result += stack.pop();
        }
        return result;
    }
}