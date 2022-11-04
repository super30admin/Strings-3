// Time Complexity  : O(N)
// Space Complexity : O(1)
class Solution {
    public int calculate(String s) {
        // base case
        if ( s == null || s.length() == 0) return 0;

        s = s.trim();
        char lastSign = '+';
        int num=0, calVal = 0, tail=0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c -'0';
            }

            if ((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                if (lastSign == '+') {
                    calVal = calVal + num;
                    tail = +num;
                } else if (lastSign == '-') {
                    calVal = calVal - num;
                    tail = -num;
                } else if (lastSign == '*') {
                    calVal = calVal - tail + (tail * num);
                    tail = tail * num;
                } else {
                    calVal = calVal - tail + (tail/num);
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calVal;
    }
}
