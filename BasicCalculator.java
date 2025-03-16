// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n)

import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        char lastSign = '+';
        int val = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                val = val*10 + (ch-'0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || (i == s.length()-1)){
                if(lastSign == '+'){
                    st.push(val);
                }else if(lastSign == '-'){
                    st.push(-val);
                }else if(lastSign == '*'){
                    st.push(st.pop()*val);
                }else if(lastSign == '/'){
                    st.push(st.pop()/val);
                }
                val = 0;
                lastSign = ch;
            }

        }

        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }

        return result;
    }
}
