// Time Complexity : O(n); where n = length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        int calc = 0;
        int curr = 0;
        int tail = 0;
        char lastSign = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            } 
            // take the last number into calculation
            if((!Character.isDigit(c) || i == s.length() - 1) && c!= ' '){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*'){
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }
                else if(lastSign == '/'){
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;
            }
        }
        return calc;
    }
}