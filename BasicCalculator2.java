class Solution {
    public int calculate(String s) {
        int n=s.length();
        int calc=0;
        int currNum=0;
        int tail=0;
        char lastSign='+';
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currNum=currNum*10+c-'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i==s.length()-1){
                if(lastSign=='+'){
                    calc=calc +currNum;
                    tail=currNum;
                }else if(lastSign=='-'){
                    calc=calc-currNum;
                    tail=-currNum;
                }else if(lastSign=='*'){
                    calc=(calc-tail)+(tail*currNum);
                    tail=tail*currNum;
                }else if(lastSign=='/'){
                    calc=(calc-tail)+(tail/currNum);
                    tail=tail/currNum;
                }
                currNum=0;
                lastSign=c;
            }
        }
        return calc;
    }
}