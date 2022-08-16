// TC : O(n)
// SC : O(1)

class Solution {
    public int calculate(String s) {
        if(s == null || s.length()==0) return 0;
        s=s.trim();
        char lastsign = '+';
        int calc = 0, num = 0, tail = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            }
            
            if((!Character.isDigit(c) && c!=' ') || i == s.length()-1){
                if(lastsign == '+'){
                    calc = calc + num;
                    tail = +num;
                }
                else if(lastsign == '-'){
                    calc = calc - num;
                    tail = -num;
                }
                else if(lastsign == '*'){
                    calc = calc - tail + tail * num;
                    tail = tail * num;
                }
                else{
                    calc = calc - tail + tail / num;
                    tail = tail / num;
                }
                lastsign = c;
                num=0;
            }
        }
        return calc;
        
    }
}