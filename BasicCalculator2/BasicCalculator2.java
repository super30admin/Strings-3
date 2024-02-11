/* Time Complexity :  O(n)
 *  n - length of the string */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int currNum = 0;
        char lastSign = '+';
        int calc = 0;
        int tail = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum * 10 + ch - '0';
            }
            if(i == s.length()-1 || (!Character.isDigit(ch) && ch != ' ')){
                if(lastSign == '+'){
                    calc = calc + currNum;
                    tail = currNum;
                } else if(lastSign == '-'){
                    calc = calc - currNum;
                    tail = -currNum;
                } else if(lastSign == '*'){
                    calc = calc - tail + (tail * currNum);
                    tail = tail * currNum;
                } else{
                    calc = calc - tail + (tail / currNum);
                    tail = tail / currNum;
                }
                currNum = 0;
                lastSign = ch;
            }
        }
        return calc;
    }
}