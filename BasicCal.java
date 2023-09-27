class Solution {
    public int calculate(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        int cal = 0;
        int curr = 0;
        int tail = 0;
        char lastsign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastsign == '+') {
                    cal = cal + curr;
                    tail = curr;
                } else if (lastsign == '-') {
                    cal = cal - curr;
                    tail = -curr;
                } else if (lastsign == '*') {
                    cal = cal - tail + (tail * curr);
                    tail = tail * curr;
                } else {
                    cal = cal - tail + (tail / curr);
                    tail = tail / curr;
                }
                lastsign = c;
                curr = 0;
            }
        }

        return cal;

    }
}