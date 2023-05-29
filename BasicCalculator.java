import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        if(s == null) return 0;
        int curr =0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                if(lastSign == '+') {
                    st.push(curr);
                } else if(lastSign == '-') {
                    st.push(-curr);
                } else if(lastSign == '*') {
                    int popped = st.pop();
                    st.push(popped * curr);
                } else {
                    int popped = st.pop();
                    st.push(popped / curr);
                }
                curr = 0;
                lastSign = c;
            }
        }
        int result = 0;
        while(!st.isEmpty()) {
            result = result+st.pop();
        }
        return result;
    }
}
