/*
 * TC: O(n), n: length of s
 * SC: O(1).
 * 
 * Approach: I will keep track of my tail i.e the last number with operator.if i see +,- then i will straightaway do calculate and
 * update my tail. If i encounter *,/ then i will substact tail from the result and add (tail*current_Number).
 */

class Solution {
    public int calculate(String s) {
        int curr = 0;
        int result = 0;
        char lastSign = '+';
        int tail = 0;
        s = s.trim();
        

        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1){

                if(lastSign == '+'){
                    result += curr;
                    tail = curr;
                }else if(lastSign == '-'){
                    result -= curr;
                    tail = -curr;
                }else if(lastSign == '*'){
                    result =result - tail + (tail*curr);
                    tail = tail*curr;
                }else if(lastSign == '/'){
                     result =result - tail + (tail/curr);
                     tail = tail/curr; 
                }
            
            curr = 0;
            lastSign = ch;
            }
        }
    return result;   
    }
}