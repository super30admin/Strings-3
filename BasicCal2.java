import java.util.Stack;

/***
 Using stack
 TC - O(n)
 SC - O(n)
 */
class BasicCal2 {
    public int calculate(String s) {

        if(s == null || s.length() == 0)
            return 0;

        Stack<Integer> st = new Stack<>();

        int curr =0;

        char lastOp = '+';

        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                curr = curr*10 + ch-'0';
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1) {
                if(lastOp == '+') {
                    st.push(curr);
                }

                else if(lastOp == '-') {
                    st.push(-curr);
                }

                else if(lastOp == '*') {
                    st.push(st.pop() * curr);
                }

                else if(lastOp == '/') {
                    st.push(st.pop() / curr);
                }

                lastOp = ch;
                curr =0;
            }
        }

        int result =0;

        while(!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }
}