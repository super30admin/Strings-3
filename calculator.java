// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int calculate(String s) {
        s = s.trim();
        int curr = 0;
        char lastSign = '+';
        int calc = 0;
        int tail = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10 + c - '0';
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1){
                if(lastSign == '+'){
                    calc += curr;
                    tail = curr;
                } else if( lastSign == '-'){
                    calc -= curr;
                    tail = -curr;
                } else if(lastSign == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail*curr;
                } else if (lastSign == '/') {
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}
