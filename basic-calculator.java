// Time - O(N)
// Space -O(N)

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;   
        }
        
        Stack<Integer> st = new Stack<>();
        // compute num
        
        int num = 0;
        char lastSign = '+';
        int result = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);                                
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch != ' ') || (i == s.length() - 1)) {
                if(lastSign == '+') {
                    st.push(num);
                }
                else if(lastSign == '-') {
                    st.push(-num);
                }
                else if(lastSign == '*') {
                    st.push(st.pop() * num);
                }
                else if(lastSign == '/') {
                    st.push(st.pop() / num);
                }
                num = 0;
                lastSign = ch;
            }
        }
        
        while(!st.isEmpty()) {
            result += st.pop();
        }
        
        return result;
    }
}
