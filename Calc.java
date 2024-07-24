public class Calc {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int curr = 0;
        char lastsign = '+';
        int cal = 0;
        int tail = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastsign == '+') {
                    cal = cal + curr;
                    tail = curr;
                }
                if (lastsign == '-') {
                    cal = cal - curr;
                    tail = -curr;
                }
                if (lastsign == '*') {
                    cal = cal - tail + tail * curr;
                    tail = tail * curr;
                }
                if (lastsign == '/') {
                    cal = cal - tail + tail / curr;
                    tail = tail / curr;
                }
                lastsign = c;
                curr = 0;
            }
        }
        return cal;
    }

    public static void main(String[] args) {
        Calc c = new Calc();
        int res = c.calculate("3+2*2");
        System.out.println(res);
    }
}
