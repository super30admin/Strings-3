// Time : O(n)
// space : O(1) // without stack
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int currNum = 0;
        int lastSign = '+';
        int cal =0;
        int tail =0;

        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = 10*currNum + ch - '0';
            }
            if(!Character.isDigit(ch) && ch != ' ' || i==n-1){
                // whenever we are on the operator then evaluate the number formed till now along with last sign. 
                if(lastSign =='+') {
                    cal = cal + currNum;
                    tail = currNum;
                    }
                else if (lastSign =='-') {
                    cal = cal - currNum;
                    tail = -currNum;
                }
                else if (lastSign =='*') {
                    cal = cal - tail + (tail * currNum);
                    tail = tail * currNum;
                    
                }
                else if (lastSign == '/'){
                    cal = cal - tail + (tail / currNum);
                    tail = tail / currNum;
                };

                // reset the currNum and lastSign as you landed on the operator
                lastSign = ch;
                currNum =0;
            }
        }

        return cal;
    }
}