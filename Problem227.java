class Problem227 {
    public int calculate(String s) {
        Stack<Integer> stk=new Stack();
        int n =s.length();
        int curr=0;
        char lastSign='+';
        int calc=0;
        int tail=0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c!=' ') ||i==n-1){
                if(lastSign=='+'){
                    calc+=curr;
                    tail=curr;
                }
                else if(lastSign=='-'){
                    calc-=curr;
                    tail=-curr;
                }
                else if(lastSign=='*'){
                    calc=calc-tail + (tail*curr);
                    tail=tail*curr;
                }
                else if(lastSign=='/'){
                    calc=calc-tail + (tail/curr);
                    tail=tail/curr;
                }  
                curr=0;
                lastSign=c;
            }
        }
        return calc;
    }
}
