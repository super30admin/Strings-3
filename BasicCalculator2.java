// Time: O(n)
// Space: O(1)

// Approach: Traverse the string and keep track of currentNumber,
// lastSign, calculated value and tail. Give precedence to multiplication and division.

class BasicCalculator2 {
    public int calculate(String s) {
        s = s.trim();

        int currentNumber = 0;
        char lastSign = '+';
        int calculated = 0;
        int tail = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ') {
                continue;
            }

            if (Character.isDigit(current)) {
                currentNumber = currentNumber * 10 + current - '0';
                // we need to calculate the expression if this is the final expression
                if (i != s.length() - 1) {
                    continue;
                }
            }

            // it's an expression; calculate the last expression and update the current
            // expression
            if (lastSign == '+') {
                calculated = calculated + currentNumber;
                tail = currentNumber;
            } else if (lastSign == '-') {
                calculated = calculated - currentNumber;
                tail = -currentNumber;
            } else if (lastSign == '*') {
                calculated = calculated - tail + tail * currentNumber;
                tail = tail * currentNumber;
            } else {
                calculated = calculated - tail + tail / currentNumber;
                tail = tail / currentNumber;
            }

            // resetting number
            currentNumber = 0;
            lastSign = current;
        }

        return calculated;
    }
}