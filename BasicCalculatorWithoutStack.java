// Time Complexity : O(n) to iterate over the entire string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Start by initalizing few variables like lastSign, curr, calc, tail. Then check if a character is a digit then simply  curr = curr * 10 + c - '0' and then check current element is not a digit nor a space and then check for the sign and accordingly calculate calc and tail
 */
class Solution {
    public int calculate(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int curr = 0;
        char lastSign = '+';
        int calc = 0, tail = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    calc = calc + curr;
                    tail = +curr;
                }
                if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                if(lastSign == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail*curr;
                }
                if(lastSign == '/'){
                    calc = calc - tail + tail / curr;
                    tail = tail/curr;
                }
                lastSign = c;
                curr = 0;
            }
        }

        return calc;
    }
}