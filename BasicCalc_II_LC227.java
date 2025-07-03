// Time Complexity : O(n) n = s.length
// Space Complexity : O(n) all no. pushed into stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class BasicCalc_II_LC227 {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char lastSign = '+';

        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr = curr * 10 + ch - '0';
            }

            if ((!Character.isDigit(ch) && ch != ' ')|| i == s.length() - 1) {
                if (lastSign == '+') {
                    stack.push(curr);
                } else if (lastSign == '-') {
                    stack.push(-curr);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * curr);
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / curr);
                }
                lastSign = ch;
                curr = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }
}