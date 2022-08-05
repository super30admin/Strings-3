// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/basic-calculator-ii/

class Solution {
    public int calculate(String s) {

        int res = 0, lastNo = 0, currentNo = 0;
        char op = '+';

        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);

            if(Character.isDigit(current)){
                currentNo = (currentNo * 10) + (current-'0');
            }

            if(!Character.isDigit(current) && !Character.isWhitespace(current) || i == s.length() - 1){

                if(op == '+'){
                    res+= lastNo;
                    lastNo = currentNo;
                }
                else if(op == '-'){
                    res+= lastNo;
                    lastNo = -currentNo;
                }
                else if(op == '*'){
                    lastNo = lastNo * currentNo;
                }
                else if(op == '/'){
                    lastNo = lastNo / currentNo;
                }
                op = current;
                currentNo = 0;
            }
        }
        res+=lastNo;
        return res;
    }
}