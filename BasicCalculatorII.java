class BasicCalculatorII {
    // TC:O(n) SC:O(1)
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        char lastSign = '+';
        int curr = 0;
        int calc = 0;
        int tail = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((!Character.isDigit(c) || i == s.length() - 1) && c != ' ') {
                if (lastSign == '+') {
                    calc = calc + curr;
                    tail = +curr;
                } else if (lastSign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                } else if (lastSign == '/') {
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;

            }
        }
        return calc;
    }
}