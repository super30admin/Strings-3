// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We iterate each character in the string, we calculate the based on the operation and store it in a variable
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int calc = 0, tail = 0;
        int curr = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';

            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    calc = calc + curr;
                    tail = curr;
                } else if (lastSign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    calc = calc - tail + tail * curr;
                    tail = curr * tail;
                } else {
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