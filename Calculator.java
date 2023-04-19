// the time complexity of this implementation is O(n)
import java.util.Stack;

class Calculator {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    numStack.push(num);
                    num = 0;
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(c)) {
                    eval(numStack, opStack);
                }
                opStack.push(c);
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (opStack.peek() != '(') {
                    eval(numStack, opStack);
                }
                opStack.pop();
            }
        }
        while (!opStack.isEmpty()) {
            eval(numStack, opStack);
        }
        return numStack.pop();
    }

    private int precedence(char op) {
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    private void eval(Stack<Integer> numStack, Stack<Character> opStack) {
        char op = opStack.pop();
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        numStack.push(result);
    }
    public static void main(String[] args) {
        Calculator solution = new Calculator();
        String s = "2*(5+5*2)/3+(6/2+8)";
        int result = solution.calculate(s);
        System.out.println("Result: " + result);
    }

}
