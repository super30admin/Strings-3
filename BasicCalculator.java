// TIme Complexity: O(N)
// Space Complexity: O(1)
public class BasicCalculator {
    public int calculate(String s) {
        int currNum = 0;
        int prev = 0;
        char lastSign = '+';
        int calc =0;
        int tail = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                if(lastSign == '+'){
                    calc = currNum + calc;
                    tail = currNum;
                }
                else if(lastSign == '-'){
                    calc = calc - currNum;
                    tail = -currNum;
                }
                else if(lastSign == '*'){
                    calc = calc - tail + tail * currNum;
                    tail = tail * currNum;
                }
                else if(lastSign == '/'){
                    calc = calc - tail + tail/currNum;
                    tail = tail/currNum;
                }
                currNum = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}
