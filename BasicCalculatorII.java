class BasicCalculatorII {
    public int calculate(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        int result = 0, currNum = 0, lastNum = 0;
        char operation = '+', currChar;

        for(int i=0; i<s.length(); i++) {
            currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                currNum = (currNum * 10) + (currChar - '0');
            }
            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length()-1) {
                if(operation == '+' || operation == '-') {
                    result += lastNum;
                    lastNum = operation == '+' ? currNum : -currNum;
                }
                if(operation == '*') {
                    lastNum = lastNum * currNum;
                }
                if(operation == '/') {
                    lastNum = lastNum / currNum;
                }
                operation = currChar;
                currNum = 0;
            }
        }

        result += lastNum;
        return result;
    }
}
