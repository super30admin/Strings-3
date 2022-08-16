//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char lastSign = '+';
        int num = 0;
        int calc = 0;
        int tail = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { // if a digit is encountered, build the number.
                num = num * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) { // if a sign or whitespace is encountered:
                                                                              // based on the sign, the calculated value
                                                                              // and tail get computed and even if the
                                                                              // end of the string s is reached we
                                                                              // calculate to return the final answer.
                if (lastSign == '+') {
                    calc = calc + num;
                    tail = +num;
                } else if (lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                } else if (lastSign == '*') {
                    calc = calc - tail + tail * num;
                    tail = tail * num;
                } else {
                    calc = calc - tail + tail / num;
                    tail = tail / num;
                }
                num = 0; // when a sign is encouneterd : the num is reset to 0
                lastSign = c; // and lastSign gets updated to current sign
            }
        }

        return calc;
    }
}