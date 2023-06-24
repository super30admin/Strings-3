import java.util.Stack;

public class BasicCalc {

    // TC: O(n) n - length of the string
    // SC: O(1)
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        char lastSign = '+';
        int calc = 0, tail = 0, current = 0;

        // variable tail is to keep track of whatever the last operation we did


        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                current = current * 10 + c - '0'; // This will help us to get a 2,3-digit numbers
            }

            // It should be if and not else if because for the last character in the string,
            // For example, 3 + 24 * 2 -> Here, at 2, we need to evaluate the above condition as well as the (i = s.length() - 1) condition mentioned below
                // Putting else if will evaluate either of the two conditions and not the both
            //We need to do two things -> check whether it's a digit or not, evaluate the expression as we reach an end
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if(lastSign == '+') {
                    calc = calc + current;
                    tail = +current;
                }else if(lastSign == '-') {
                    calc = calc - current;
                    tail = -current;
                }else if(lastSign == '*') {
                    calc = calc - tail + (tail * current); // Because of the operator precedence,
                                                        // we need to revert the last operation which has less precedence than the current operator
                    tail = tail * current;
                }else if(lastSign == '/') {
                    calc = calc - tail + (tail / current);
                    tail = tail / current;
                }

                lastSign = c;
                current = 0;
            }

        }
        return calc;
    }

    // Stack approach
    // TC: O(n)
    // SC: O(n)
    public int calculate2(String s) {
        if(s == null || s.length() == 0) return 0;

        char lastSign = '+';
        int calc = 0, current = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                current = current * 10 + c - '0'; // This will help us to get a 2,3-digit numbers
            }

            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if(lastSign == '+') {  // This will evaluate to true for the very first number in the string
                    stack.push(current);
                }else if(lastSign == '-') {
                    stack.push(-current);
                }else if(lastSign == '*') {
                    stack.push(stack.pop() * current);
                }else if(lastSign == '/') {
                    stack.push(stack.pop() / current);
                }

                lastSign = c;
                current = 0;
            }

        }
        while(!stack.isEmpty()) {
            calc = calc + stack.pop();
        }
        return calc;
    }

    public static void main(String[] args) {
        BasicCalc calc = new BasicCalc();
        calc.calculate2("7*4");
    }
}
