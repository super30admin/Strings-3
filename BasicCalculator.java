//Time Complexity: O(n)
//Space Complexity: O(1)

public class BasicCalculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int num =0, calc =0, tail =0;
        char lastsign = '+';

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)){
                if(lastsign == '+'){
                    calc = num+calc;
                    tail = num;
                }else if(lastsign == '-'){
                    calc = calc-num;
                    tail = -num;
                }else if(lastsign == '*'){
                    calc = calc-tail + (tail * num);
                    tail = tail*num;
                }else if(lastsign == '/'){
                    calc = calc-tail + (tail / num);
                    tail = tail/num;
                }
                lastsign = c;
                num =0;
            }
        }
        return calc;
    }
}
