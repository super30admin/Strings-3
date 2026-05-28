// Time Complexity : O(n) because we traverse the string once
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We process the expression from left to right while maintaining the running result and the most recent evaluated term.
// Addition and subtraction directly update the result, while multiplication and division modify the previous term to preserve operator precedence.
// Whenever an operator or end of string is reached, we evaluate the current number using the previous operator and reset for the next number.

class Solution {

    public int calculate(String s) {

        int currNum = 0;

        // final calculated result
        int calc = 0;

        // most recent term for handling * and /
        int tail = 0;

        // previous operator
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // build multi-digit number
            if (Character.isDigit(c)) {

                currNum =
                    currNum * 10 + c - '0';
            }

            // evaluate when operator or end reached
            if (
                (
                    !Character.isDigit(c)
                    &&
                    c != ' '
                )
                ||
                i == s.length() - 1
            ) {

                // addition
                if (lastSign == '+') {

                    calc =
                        calc + currNum;

                    tail = currNum;
                }

                // subtraction
                else if (lastSign == '-') {

                    calc =
                        calc - currNum;

                    tail = -currNum;
                }

                // multiplication
                else if (lastSign == '*') {

                    calc =
                        (calc - tail)
                        +
                        (tail * currNum);

                    tail =
                        tail * currNum;
                }

                // division
                else if (lastSign == '/') {

                    calc =
                        (calc - tail)
                        +
                        (tail / currNum);

                    tail =
                        tail / currNum;
                }

                // reset for next number
                currNum = 0;

                // update operator
                lastSign = c;
            }
        }

        return calc;
    }
}