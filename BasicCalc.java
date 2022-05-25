public class BasicCalc {

    // TC: O(n) n - length of the string
    // SC: O(1)
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        char lastSign = '+';
        int calc = 0, tail = 0, current = 0;

        // variable tail is to keep track of whatever the last operation we did


        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                current = current * 10 + c - '0'; // This will help us to get a 2,3-digit numbers
            }

            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if(lastSign == '+') {
                    calc = calc + current;
                    tail = +current;
                }else if(lastSign == '-') {
                    calc = calc - current;
                    tail = -current;
                }else if(lastSign == '*') {
                    calc = calc - tail + (tail * current); // Because of the operator precedence,
                                                        // we need to revert the last operation which has less precedence than the current operator
                    tail = tail * current;
                }else if(lastSign == '/') {
                    calc = calc - tail + (tail / current);
                    tail = tail / current;
                }

                lastSign = c;
                current = 0;
            }

        }
        return calc;
    }
}
