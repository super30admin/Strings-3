
// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


//This is the solution without using stacks
class basiccalc {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        s = s.trim() + '+';
        s = s.replace(" ", "");
         
        int calc = 0;
        int tail = 0;
        int num = 0;
        char lastSign = '+';
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            //digit
            if(Character.isDigit(c)){
                
                //in order to get ascii value of c we need to subtract by ascii of 0
                num = num * 10 + c - '0';
            }
            //not a digit or last character
            else{
                if(lastSign == '+'){
                    calc = calc + num;
                    tail = num;
                }
                else if(lastSign == '-'){
                    calc = calc - num;
                    tail = -num;
                }
                else if(lastSign == '*'){
                    calc = calc - tail + tail * num;
                    tail = tail * num;
                }
                else if(lastSign == '/'){
                    calc = calc - tail + tail / num;
                    tail = tail / num;
                }
                
                num = 0;
                lastSign = c;
            }
        }
        
        return calc;
    }
}