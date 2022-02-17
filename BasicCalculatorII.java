//  Time Complexity = O(n)
//  Space Complexity = O(1)

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();

        int calc = 0;
        int cur = 0;
        int tail = 0;
        char lastOperator = '+';

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }

            if ((!Character.isDigit(c) || i == s.length() - 1) && !Character.isWhitespace(c)) {
                switch(lastOperator) {
                    case '+':
                        calc = calc + cur;
                        tail = cur;
                        break;

                    case '-':
                        calc = calc - cur;
                        tail = -cur;
                        break;

                    case '*':
                        calc = calc - tail + tail * cur;
                        tail = tail * cur;
                        break;

                    case '/':
                        calc = calc - tail + tail / cur;
                        tail = tail / cur;
                        break;
                }

                lastOperator = c;
                cur = 0;
            }

        }

        return calc;
    }
}
