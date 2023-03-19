import java.util.Stack;
/*
Basic Calculator ii
approach: use tail, lastSign, calc && curr
time: O(n)
space: O(1)
 */
public class Problem1 {
    public int calculate(String s) {
        int cur = 0, tail = 0, calc = 0;
        char lastSign = '+';

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                cur = cur*10+c-'0';
            }
            if(c=='+' || c=='-' || c=='*' || c=='/' || i==s.length()-1){
                if(lastSign=='+') {
                    calc = calc+cur;
                    tail = +cur;
                }
                else if(lastSign=='-') {
                    calc = calc-cur;
                    tail = -cur;
                }
                else if(lastSign=='*') {
                    calc = calc-tail+tail*cur;
                    tail = tail*cur;
                }
                else if(lastSign=='/') {
                    calc = calc-tail+tail/cur;
                    tail = tail/cur;
                }
                lastSign = c;
                cur = 0;
            }
        }
        return calc;
    }

    //space: O(n)
    public int calculateStack(String s) {
        int cur = 0, tail = 0, calc = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                cur = cur*10+c-'0';
            }
            if(c=='+' || c=='-' || c=='*' || c=='/' || i==s.length()-1){
                if(lastSign=='+') {
                    st.push(+cur);
                }
                else if(lastSign=='-') {
                    st.push(-cur);
                }
                else if(lastSign=='*') {
                    st.push(cur*st.pop());
                }
                else if(lastSign=='/') {
                    st.push(st.pop()/cur);
                }
                lastSign = c;
                cur = 0;
            }
        }

        while(!st.isEmpty()) {
            calc +=st.pop();
        }
        return calc;
    }

    public static void main(String []args) {
        Problem1 problem1 = new Problem1();
        problem1.calculate("3+5/2");
    }
}
