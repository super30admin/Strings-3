// Time Complexity : O(n) --length of string
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//227. Basic Calculator II

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int calc = 0, tail = 0;
        int num = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)){
                
                if(lastSign == '+'){
                    calc = calc + num;
                    tail = +num;
                }
                if(lastSign == '-'){
                    calc = calc - num;
                    tail = -num;
                }
                if (lastSign == '*'){
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