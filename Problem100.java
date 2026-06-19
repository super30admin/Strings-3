//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int calculate(String s) {
        int currNum = 0;
        char lastSign = '+';
        int cal = 0;
        int tail = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }

            if((!Character.isDigit(c) && c!=' ') || i == s.length()-1){
                if(lastSign == '+'){
                    cal = cal + currNum;
                    tail = currNum;
                }else if(lastSign == '-'){
                    cal = cal - currNum;
                    tail = -currNum;
                }else if(lastSign == '*'){
                    cal = (cal - tail) + (tail * currNum);
                    tail = tail * currNum;
                }else if(lastSign == '/'){
                    cal = (cal - tail) + (tail / currNum);
                    tail = tail / currNum;
                }

                currNum = 0;
                lastSign = c;
            }
        }

        return cal;
    }
}