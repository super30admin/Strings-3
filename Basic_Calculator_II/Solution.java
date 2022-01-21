// Time Complexity : O(n) where n is length of inout string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We iterate over string and keep a track of number formed so far and edit it everytime we get a sign
 * To perform multiplication and division, we keep a tail pointer to number formed in previos result '
 * And use formula (cal - tail) + (tail * curr)	
*/




class Solution {
    public int calculate(String s) {
        int cal = 0;
        int curr = 0;
        char sign = '+';
        int tail = 0;
        
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr * 10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                    if(sign == '+'){
                        cal = cal + curr;
                        tail = curr;
                    }
                    else if(sign == '-'){
                        cal = cal - curr;
                        tail = -curr;
                    }
                    else if(sign == '*'){
                        cal = (cal - tail) + (tail * curr);
                        tail = tail * curr;
                    }
                    else if(sign == '/'){
                        cal = (cal - tail) + (tail / curr);
                        tail = tail / curr;
                    }
                
                
                sign = ch;
                curr = 0;
            }
        }
        
        
        return cal;
        
    }
}