
// TC : O(n)
// SC : O(1)

package S30_Codes.Strings_3;

class BasicCalculatorII {
    public int calculate(String s) {
        if(s==null) return 0;
        s = s.trim();
        int n = s.length();

        int curr = 0;
        char lastSign = '+';
        int tail = 0;
        int calc = 0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
                if(lastSign == '+'){
                    calc += curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc -= curr;
                    tail = -curr;
                }
                else if(lastSign == '*'){
                    calc = (calc - tail) + (tail*curr);
                    tail = tail*curr;
                }
                else{
                    calc = (calc - tail) + (tail/curr);
                    tail = tail/curr;
                }

                lastSign = c;
                curr = 0;
            }
        }
        return calc;
    }
}