//tc is O(length(string))
//sc is O(1)
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        s = s.trim();

        int calc = 0;
        int tail = 0;
        int num = 0;
        int last_sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');

            }

            if ((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                if (last_sign == '+') {
                    calc = calc + num;
                    tail = +num;

                }

                if (last_sign == '-') {
                    calc = calc - num;
                    tail = -num;

                }

                if (last_sign == '*') {
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                }

                if (last_sign == '/') {
                    calc = calc - tail + (tail / num);
                    tail = tail / num;
                }

                last_sign = c;
                num = 0;

            }
        }

        return calc;
    }
}