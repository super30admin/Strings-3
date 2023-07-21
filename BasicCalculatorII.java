import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null)
            return 0;
        s.trim();

        char lastSign = '+';
        int curr = 0;
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr = curr * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || (i == n - 1)) {
                if (lastSign == '+') {
                    st.push(curr);
                } else if (lastSign == '-') {
                    st.push(-curr);
                } else if (lastSign == '*') {
                    st.push(st.pop() * curr);
                }

                else {
                    st.push(st.pop() / curr);
                }
                lastSign = ch;
                curr = 0;
            }
        }
        int result = 0;
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        String expression1 = "3+2*2";
        String expression2 = " 3/2 ";
        String expression3 = " 3+5 / 2 ";

        int result1 = basicCalculatorII.calculate(expression1);
        System.out.println("Result 1: " + result1);

        int result2 = basicCalculatorII.calculate(expression2);
        System.out.println("Result 2: " + result2);

        int result3 = basicCalculatorII.calculate(expression3);
        System.out.println("Result 3: " + result3);
    }
}
