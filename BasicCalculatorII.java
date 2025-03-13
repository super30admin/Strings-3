class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int cur =0;
        char lastSign = '+';
        for(int i=0;i<s.length();i++)
        {
            char ch =s.charAt(i);
            if(Character.isDigit(ch))
            {
                cur = cur * 10 + ch -'0';
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(lastSign=='+')
                {
                        st.push(+cur);
                }
                else if(lastSign=='-')
                {
                    st.push(-cur);
                }
                else if(lastSign=='*')
                {
                    int lastEle = st.pop();
                    st.push(lastEle*cur);
                }
                else{
                    int lastEle = st.pop();
                    st.push(lastEle/cur);
                }
                cur =0;
                lastSign = ch;
            }
        }
        int res=0;
        while(!st.isEmpty())
        {
            res+=st.pop();
        }
        return res;
    }
}

//tc: O(n)
//sc: O(n)