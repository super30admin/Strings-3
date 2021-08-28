//Time complexity: O(N),  N -> Length of input string.
//Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {

        if(s == null || s.length() == 0) return 0;

        int num = 0, tail = 0, calNum = 0;
        char lastSign = '+';
        s = s.replace(" ","");
        s = s + "+";

        for(char ch: s.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                num = num*10 + Character.getNumericValue(ch);
            } else {
                if(lastSign == '+') {
                    calNum = calNum + num;
                    tail = num;
                } else if(lastSign == '-') {
                    calNum = calNum - num;
                    tail = -num;
                } else if(lastSign == '*') {
                    calNum = calNum - tail + (tail * num);
                    tail = tail * num;
                } else if(lastSign == '/') {
                    calNum = calNum - tail + (tail / num);
                    tail = tail / num;
                }
                lastSign = ch;
                num = 0;
            }
        }
        return calNum;
    }
}