// Time Complexity : O(n), n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Iterate over the string and evaluate the expression on the fly, using curr, calc, tail and lastSign variables to evaluate the expression.
 * 2. If there is a multiplication or divison, give precedence to it by using formula calc - tail + (tail * curr) or calc - tail + (tail / curr);
 * 3. Return the final result.
 */

class Solution {
    public int calculate(String s) {
        int n = s.length();
        s.trim();
        int curr = 0, calc = 0, tail = 0;
        char lastSign = '+';

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr * 10 + (ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == n-1){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }else if(lastSign == '*'){
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }else {
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }

                lastSign = ch;
                curr = 0;
            }
        }

        return calc;
    }
}