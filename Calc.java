// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> st = new Stack<>();
        int num = 0;
        Character sign = '+';
        for(Character c:s.toCharArray())
        {
           if(c!=' ')
           {
                if(Character.isDigit(c))
            {
                num =  (num*10) + c-'0';
            }
            else if(!st.isEmpty() && (sign == '*' || sign=='/'))
            {
              
                int num2 = st.pop();
                st.push(sign=='*'?num*num2:num2/num);
                num = 0;
                sign = c;       
            }
            else
            {
                
                    st.push(sign=='+'?num:-num);
                    num=0;
                    sign = c;
            }
           }
        }
        if(!st.isEmpty() && (sign == '*' || sign=='/'))
        {
            int num2 = st.pop();
            st.push(sign=='*'?num*num2:num2/num);
        }
        else
        {
            st.push(sign=='+'?num:-num);
        }
        int total = 0;
        while(!st.isEmpty()) total+=st.pop();
        return total;
        
    }
}