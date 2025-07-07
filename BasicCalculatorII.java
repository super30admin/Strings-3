
import java.util.Stack;

//Time: O(n) where n is the length of the string
//Space: O(n) for the recursive stack frames

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // check for digits
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            // check for operators or end of string
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.add(num);
                } else if (sign == '-') {
                    stack.add(-num);
                } else if (sign == '/') {
                    stack.add(stack.pop() / num);
                } else if (sign == '*') {
                    stack.add(stack.pop() * num);
                }
                num = 0;
                sign = ch;
            }
        }

        for (int i : stack) {
            result += i;
        }
        return result;
    }
}
