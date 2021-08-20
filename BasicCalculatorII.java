// Time complexity : O(n) 
// Space complexity: O(1)
// Run on leetcode: yes
// Issues faced: None

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        char curr_sign = '+';
        int sum = 0;
        int tail = 0;
        char prev_sign = '+';
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int digit = Character.getNumericValue(c);
                i++;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    digit = digit * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                i--;
                if(curr_sign == '+'){
                    sum = sum + digit;
                    tail = digit;
                }
                else if(curr_sign == '-'){
                    sum = sum - digit;
                    tail = -1 * digit;
                }
                else if(curr_sign == '*'){
                    sum = (sum - tail) + tail * digit;
                    tail = tail * digit;  
                }
                else{ 
                    sum = (sum - tail) + tail / digit;
                    tail = tail / digit;  
                }
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                prev_sign = curr_sign;
                curr_sign = c;
            }
        }
        
        return sum;
    }
}
