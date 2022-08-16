//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public int calculate(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        int calc = 0, num = 0, tail = 0;
        char lastSign = '+';
        
        for(int i =0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            
            if((!Character.isDigit(c) && c != ' ') || i == s.length()- 1)
            {
                if(lastSign == '+'){
                    calc = calc + num;
                    tail = num;
                }
                
                else if(lastSign == '-'){
                    calc = calc - num;
                    tail = -num;
                }
                else if(lastSign == '*'){
                    calc = (calc - tail) + (tail*num);
                    tail = tail*num;
                }
                else
                {
                    calc = (calc - tail) + (tail/num);
                    tail = tail/num;
                }
                
                lastSign = c;
                num = 0;
            }
        }
        
        return calc;
    }
}
