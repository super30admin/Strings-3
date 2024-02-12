import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        return calculateWithoutSpace(s);
    }
    // TC: O(N) where N is length of string
    // SC: O(1)
    private int calculateWithoutSpace(String s) {
        int calc = 0, currNum = 0, tail = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0';
            }
            if ((!Character.isDigit(currChar) && !Character.isWhitespace(currChar)) || i == s.length() - 1) {
                if (operator == '+') {
                    calc += currNum;
                    tail = currNum;
                } else if (operator == '-') {
                    calc -= currNum;
                    tail = -currNum;
                } else if (operator == '*') {
                    calc = calc - tail + tail * currNum;
                    tail = tail * currNum;
                } else {
                    calc = calc - tail + tail / currNum;
                    tail = tail / currNum;
                }
                currNum = 0;
                operator = currChar;
            }
        }
        return calc;
    }

    // TC: O(N) where N is length of string
    // SC: O(N) where N is length of string
    private int calculateUsingStack(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int currNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0';
            }
            if((!Character.isDigit(currChar) && currChar != ' ') || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(currNum);
                } else if (operator == '-') {
                    stack.push(-currNum);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currNum);
                } else {
                    stack.push(stack.pop() / currNum);
                }
                currNum = 0;
                operator = currChar;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
