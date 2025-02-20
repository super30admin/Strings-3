class BasicCalculatorII {
    public int calculate(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }

        int calc=0;
        int num = 0;
        int tail=0;
        char lastSign = '+';
        for(int i=0; i<s.length(); i++){

            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }

            if((!Character.isDigit(c) && c!=' ') || i == s.length() - 1){
                if (lastSign == '+') {
                    calc = calc + num;
                    tail = +num;
                } else if (lastSign=='-') {
                    calc = calc - num;
                    tail = -num;
                } else if (lastSign=='*') {
                    calc = calc - tail + tail * num;
                    tail = tail * num;
                } else if (lastSign=='/') {
                    calc = calc - tail + tail / num;
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }

        return calc;
    }
}
