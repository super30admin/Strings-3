// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int calculate(String s) {
        int len = s.length();
        int num = 0;
        Stack<Integer> st = new Stack<Integer>();
        char sign = '+';
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + c - '0';
            if((!Character.isDigit(c) && c != ' ') || (i == len - 1)) {
                if(sign == '+')
                    st.push(+num);
                if(sign == '-')
                    st.push(-num);
                if(sign == '*')
                    st.push(st.pop() * num);
                if(sign == '/')
                    st.push(st.pop() / num);
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while(!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}