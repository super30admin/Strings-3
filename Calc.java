Time Complexity: o(n)
Space Complexity: o(1)
class Solution {
    public int calculate(String s) {
        int val = 0;
        char sign = '+';
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                val = val *10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1)
            {
                if(sign  == '+')
                {
                    st.push(val);
                }
                else if(sign == '-')
                {
                    st.push(-val);
                }
                else if(sign == '*')
                {
                    st.push(st.pop() * val);
                }
                else if(sign == '/')
                {
                    st.push(st.pop()/val);
                }
                val = 0;
                sign = c;
                
            }
            
        }
        while(!st.isEmpty())
        {
            result += st.pop();
        }
        return result;
    }
}