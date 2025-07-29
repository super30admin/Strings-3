class Solution {
    public int calculate(String s) {
        s = s.trim();
        int curr = 0;
        char ls = '+';
        int calc = 0;
        int tail = 0;

        for(int i = 0; i < s.length(); i++){
            char cc = s.charAt(i);
            if(Character.isDigit(cc)){
                curr = curr * 10 + cc - '0';
            }

            if((!Character.isDigit(cc) && cc != ' ') || i == s.length() - 1){
                if(ls == '+'){
                    calc = calc + curr;
                    tail =  curr;
                }else if (ls == '-'){
                    calc = calc - curr;
                    tail = - curr;
                }else if(ls == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }else{
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }

                curr = 0;
                ls = cc;
            }
        }

        return calc;
    }
}
