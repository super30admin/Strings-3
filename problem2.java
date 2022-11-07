package s30.Strings-3;

public class problem2 {
    class Solution {
        public int calculate(String s) {
            //TC:- O(n)
            //SC:- O(1)
            if(s == null || s.length() == 0) return 0;
            
            char lastSign = '+';
            int num = 0;
            int tail = 0;
            int calc = 0;
            
            s = s.trim();
            
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                
                if(Character.isDigit(c)){
                    num = num * 10 + (c - '0');
                }
                
                if((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)){
                    if(lastSign == '+'){
                        calc = calc + num;
                        tail = +num;
                    }
                    else if(lastSign == '-'){
                        calc = calc - num;
                        tail = -num;
                    }
                    else if(lastSign == '*'){
                        calc = calc - tail + (tail * num);
                        tail = tail * num;
                    }
                    else{
                        calc = calc - tail + (tail / num);;
                        tail = tail / num;
                    }
                    
                    lastSign = c;
                    num = 0;
                }
            }
            return calc;
        }
    }
}
