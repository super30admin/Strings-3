/*
Problem: https://leetcode.com/problems/basic-calculator-ii/
*/
class Solution {
    Stack<Integer> numStack = null;
    Stack<Character> opStack = null;
    
    public int calculate(String s) {
        numStack = new Stack<>();
        opStack = new Stack<>();
        
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(i++));
                }
                numStack.push(num);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!opStack.isEmpty() && compareTo(opStack.peek(), ch) > 0) {
                    numStack.push(eval(opStack.pop(), numStack.pop(), numStack.pop()));
                }
                opStack.push(ch);
                ++i;
            } else {
                ++i;
            }
        }
        
        while (!opStack.isEmpty()) {
            numStack.push(eval(opStack.pop(), numStack.pop(), numStack.pop()));
        }
        
        return numStack.pop();
    }
    
    private int eval(char op, int num2, int num1) {
        switch(op) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return 0;
        }
    }
    
    private int compareTo(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return 1;
        } else if (op2 == '+' || op2 == '-') {
            return 1;
        }
        return -1;
    }
}