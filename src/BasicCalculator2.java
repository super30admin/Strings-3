/*
Problem - Given a string s which represents an expression,
 evaluate this expression and return its value.
 Approach - We are reading the string left to right and forming numbers digit by digit.
 When we hit an operator, we apply the previous sign and adjust the result based on precedence using a tail tracker.
 This lets us handle * and / immediately without a stack, by reversing the last number and applying the new operation.
 Time Complexity -
 Space Complexity -
 */
public class BasicCalculator2 {
    public int calculate(String s) {
        int curNum = 0;
        char lastSign = '+';
        int calc = 0;// running total of the expression so far
        int tail = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Build multi-digit numbers: "123" -> curNum becomes 123
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
            }
             /*
             If we see an operator (non-digit and not space), OR we are at the last character,
             we should apply the previous operator (lastSign) to curNum.
             i == s.length() - 1 so single-number inputs like "7" get processed.
            */
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                if (lastSign == '+') {
                    calc = calc + curNum;
                    tail = curNum;
                } else if (lastSign == '-') {
                    calc = calc - curNum;
                    tail = -curNum;
                } else if (lastSign == '*') {
                    // Replace the last committed number (tail) with (tail * curNum)
                    calc = (calc - tail) + (tail * curNum);
                    tail = tail * curNum; // update tail to the multiplied result
                } else if (lastSign == '/') {
                    // Replace the last committed number (tail) with (tail/ curNum)
                    calc = (calc - tail) + (tail / curNum);
                    tail = tail / curNum;// update tail to the divided result
                }
                curNum = 0;// Reset for building the next number
                if (c == '+' || c == '-' || c == '*' || c == '/') lastSign = c;
            }
        }
        return calc;
    }
}
