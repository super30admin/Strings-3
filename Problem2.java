import java.util.Stack;

class Solution1 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char lastDigit = '+';
        int cal = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (lastDigit == '+') {
                    stack.push(num);
                }
                if (lastDigit == '-') {
                    stack.push(-num);
                }
                if (lastDigit == '*') {

                    stack.push(stack.pop() * num);
                }
                if (lastDigit == '/') {

                    stack.push(stack.pop() / num);
                }
                lastDigit = ch;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            cal = cal + stack.pop();
        }
        return cal;
    }
}


class Solution2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int tail = 0;
        char lastDigit = '+';
        int cal = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (lastDigit == '+') {
                    cal = cal + num;
                    tail = +num;
                }
                if (lastDigit == '-') {
                    cal = cal - num;
                    tail = -num;
                }
                if (lastDigit == '*') {
                    cal = cal - tail + (tail * num);
                    tail = tail * num;
                }
                if (lastDigit == '/') {
                    cal = cal - tail + (tail / num);
                    tail = tail / num;
                }
                lastDigit = ch;
                num = 0;
            }
        }

        return cal;
    }
}