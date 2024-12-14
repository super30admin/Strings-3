// with lastSign , curr and tail.
class Solution {
    public int calculate(String s) {
        s = s.trim();
        char lastSign = '+';
        int calc =0;
        int tail =0;
        int curr = 0;
        for(int i=0;i< s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr*10 +  (c-'0');
            }
            if((!Character.isDigit(c) && c!=' ') || (i== s.length()-1)) {
                if(lastSign=='+') {// addition
                    calc = calc + curr;
                    tail = curr;                    
                }
                if(lastSign=='-') {// subtraction
                    calc = calc - curr;
                    tail = curr * -1;                    
                }
                if(lastSign=='*') { // multiplication
                    calc = calc - tail + (tail*curr);
                    tail = (tail*curr);            
                }
                if(lastSign=='/') { // division
                    calc = calc - tail + (tail/curr);
                    tail = (tail/curr);            
                }
                lastSign =c;
                curr = 0;
            }
        }
        return calc;
    }
}