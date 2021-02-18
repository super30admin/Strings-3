// Time Complexity : The time complexity is O(n) where n is the length of the string
// Space Complexity : The space complexity if O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int curNum = 0;
        int prevNum = 0;
        char ope = '+';

        int res=0;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            // Digit
            if(Character.isDigit(c)){
                curNum = (curNum*10) + (c-'0');
            }
            // Operator
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1){
                // Addition
                if(ope == '+'){
                    res += curNum;
                    prevNum = curNum;
                }
                //Subtraction
                if(ope == '-'){
                    res -= curNum;
                    prevNum = -curNum;
                }
                //Multiplication
                if(ope == '*'){
                    res = res - prevNum + (prevNum * curNum);
                    prevNum = (prevNum * curNum);
                }
                //Division
                if(ope == '/'){
                    res = res - prevNum + (prevNum / curNum);
                    prevNum = (prevNum / curNum);
                }
                ope = c;
                curNum = 0;
            }

        }

        return res;

    }
}