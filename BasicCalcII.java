// Time Complexity : O(N) N is length of String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        Character lastSign = '+';
        int num = 0;
        int tail = 0;
        int calc = 0;

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c -'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1){
                if(lastSign == '+') {
                    calc = calc + num;
                    tail = +num;
                }
                if(lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                }
                if(lastSign == '*') {
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                }
                if(lastSign == '/'){
                    calc = calc - tail + (tail / num);
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calc;
    }
}