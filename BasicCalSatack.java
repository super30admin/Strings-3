class Solution {
    public int calculate(String s) {
        //tc - o(n)
        //sc-o(n)
        if(s == null || s.length() == 0) return 0;
        char lastSign = '+';
        int curr =0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curr = curr*10 + c -'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1)
            {
                if(lastSign == '+')
                {
                    st.push(curr);
                }
                else if(lastSign == '-')
                {
                    st.push(-curr);
                }
                else if(lastSign == '*')
                {
                   st.push(st.pop()* curr);
                }
                else
                {
                    st.push(st.pop() / curr);
                }
                curr = 0;
                lastSign = c;

            }
        }
        int result = 0;
        while(!st.isEmpty())
        {
            result+= st.pop();
        }
        return result;
    }
}