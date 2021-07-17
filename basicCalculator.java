// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {
        //edge '3+2*2/3-1' ---> 2 3
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int result = 0;
        int num = 0; char lastSign = '+';
        int calc = 0; int tail = 0;
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)){
                if(lastSign == '+') {
                    calc = calc + num;
                    tail = num;
                }
                else if(lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                }
                else if(lastSign == '*') {
                    calc = calc - tail + tail*num;
                    tail = tail*num;
                }
                else{
                    calc = calc - tail + tail/num;
                    tail = tail/num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calc;
    }
}

