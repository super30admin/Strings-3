// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int calculate(String s) {
        return calculateUtil(s.trim(), 0, 0, 0, '#');
    }

    private int calculateUtil(String s, int index, int calVal, int preVal, char sign) {
        // edge case
        if (index == s.length())
            return calVal;
        int curVal = 0;
        // current char is space just ignore it
        if (s.charAt(index) == ' ')
            return calculateUtil(s, index + 1, calVal, preVal, sign);
        // current char is number/digit
        if (Character.isDigit(s.charAt(index))) {
            // get the current number in the calculated value
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                curVal = 10 * curVal + Character.getNumericValue(s.charAt(index));
                index++;
            }
            index -= 1;
            // in case of multiplication and division operation whatever mess I had created
            // in the previous calculation, will
            // remove that, do the current calculation and substract previous mess to
            // nullify that.
            if (sign == '*')
                return calculateUtil(s, index + 1, calVal - preVal + preVal * curVal, preVal * curVal, '#');
            if (sign == '/')
                return calculateUtil(s, index + 1, calVal - preVal + preVal / curVal, preVal / curVal, '#');
            if (sign == '+')
                return calculateUtil(s, index + 1, calVal + curVal, curVal, '#');
            if (sign == '-')
                return calculateUtil(s, index + 1, calVal - curVal, -curVal, '#');
            return calculateUtil(s, index + 1, curVal, curVal, '#');
        }
        return calculateUtil(s, index + 1, calVal, preVal, s.charAt(index));
    }
}