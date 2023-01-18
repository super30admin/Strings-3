// Time: O(n)
// Space: O(1)

class Basic_calculator_2 {
    public int calculate(String s) {
        if (s == null) return 0;
        int calc = 0;
        int tail = 0;
        int curr = 0;
        int lastSign = '+';
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr*10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    calc += curr;
                    tail = curr;
                }
                else if (lastSign == '-') {
                    calc -= curr;
                    tail = -curr;
                }
                else if (lastSign == '*') {
                    calc = calc - tail + (tail*curr);
                    tail = tail*curr;
                }
                else {
                    calc = calc - tail + (tail/curr);
                    tail = tail/curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}