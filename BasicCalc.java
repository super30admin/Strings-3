public class BasicCalc {
    // TC O(N)
    // SC O(1)
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int calc = 0;
        int curr = 0;
        int tail = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = (curr * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || (i == s.length() - 1)) {
                if (sign == '+') {
                    calc = calc + curr;
                    tail = curr;
                } else if (sign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                } else if (sign == '*') {
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                } else {
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                sign = c;
                curr = 0;
            }
        }
        return calc;
    }
}
