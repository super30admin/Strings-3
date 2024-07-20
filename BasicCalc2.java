//TC - O(n)
//Sc - O(1)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int curr = 0;
        int calc = 0;
        int tail = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            //Operator actions
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+'){
                    calc = curr + calc;
                    tail = +curr;

                }
                if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                if(lastSign == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }
                if(lastSign == '/'){
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;

            }

        }
        return calc;
        
    }
}