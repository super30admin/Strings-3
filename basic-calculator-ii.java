class Solution {
    //TC: O(n)
    //SC: O(1)
    public int calculate(String s) {
        s= s.trim();
        int tail = 0;
        int curr = 0;
        int calc = 0;
        char lastEX = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((Character.isDigit(c)))
            {
                curr = curr*10 + c - '0'; 
            }
            if(!(Character.isDigit(c)) && c != ' '|| i == s.length() - 1){
                if(lastEX == '+'){
                    calc += curr; 
                    tail = curr;
                }else if(lastEX == '-'){
                    calc -= curr;
                    tail = -curr; 
                }else if(lastEX == '*'){
                    calc = calc - tail + tail * curr;
                    tail =  tail * curr;
                }else{
                    calc = calc - tail + tail/curr;
                    tail = tail/curr;
                }
                curr = 0;
                lastEX = c;
                   
            }
        }
        return calc;
    }
}
