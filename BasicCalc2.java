// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int curr = 0;
        char lastSign = '+';
        int calc = 0;
        int tail = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((c != ' ' && !Character.isDigit(c)) || s.length() -1 == i) {
                if (lastSign == '+') {
                    calc += curr;
                    tail = curr;
                } else if (lastSign == '-') {
                    calc -= curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;

                } else if (lastSign == '/') {
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }

                curr = 0;
                lastSign = c;

            }
        }

        return calc;
    }
}