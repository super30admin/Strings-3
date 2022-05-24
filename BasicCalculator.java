// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int calculate(String s) {
        int calculated = 0;
        int tail = 0;
        int current = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)) {
                current = current * 10 + (ch - '0');
            }
            
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                                
                if(lastSign == '+') {
                    calculated += current;
                    tail = current;
                }
                
                if(lastSign == '-') {
                    calculated -= current;
                    tail = -1 * current;
                }
                
                if(lastSign == '*') {
                    calculated = (calculated - tail) + (tail * current);
                    tail *= current;
                }
                
                if(lastSign == '/') {
                    calculated = (calculated - tail) + (tail / current);
                    tail /= current;
                }
                current = 0;
                lastSign = ch;
            }
        }
        return calculated;
    }
}