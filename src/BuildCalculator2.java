// Time Complexity:  O(n)
// Space Complexity: O(1)
// where n is length of given string

class BuildCalculator2 {

    public int calculate(String s) {

        int res = 0;
        char lastOpr = '+';
        int lastOpd = 0;
        int curOpr = '+';
        int curOpd = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                curOpd = curOpd * 10 + (c-'0');
            }

            if(!Character.isDigit(c) && c!=' ' || i==s.length()-1) {
                if(curOpr == '+' || curOpr == '-') {
                    res = res + lastOpd;
                    lastOpd = curOpr == '+' ? curOpd : -curOpd;
                }
                else if(curOpr == '*') {
                    lastOpd = lastOpd * curOpd;
                }
                else if(curOpr == '/') {
                    lastOpd = lastOpd / curOpd;
                }
                curOpd = 0;
                curOpr = c;
            }
        }

        return res + lastOpd;
    }
}

//// ****************************** ANOTHER METHOD ******************************
//// Time Complexity:  O(n)
//// Space Complexity: O(1)
//// where n is length of given string
//
//class BuildCalculator2 {
//
//    public int calculate(String s) {
//
//        int cur = 0, res = 0, tail = 0;
//        char lastOp = '+';
//
//        for(int i=0; i<s.length(); i++) {
//
//            char c = s.charAt(i);
//
//            if(Character.isDigit(c)) {
//                // Operands
//                cur = cur * 10 + (c-'0');
//            }
//
//            if(!Character.isDigit(c) && c!=' ' || i == s.length()-1) {
//
//                // Operators
//                if(lastOp == '+') {
//                    res = res + cur;
//                    tail = cur;
//                }
//                else if(lastOp == '-') {
//                    res = res - cur;
//                    tail = -cur;
//                }
//                else if(lastOp == '*') {
//                    res = res - tail + tail*cur;
//                    tail = tail*cur;
//                }
//                else if(lastOp == '/') {
//                    res = res - tail + tail/cur;
//                    tail = tail/cur;
//                }
//
//                cur = 0;
//                lastOp = c;
//            }
//        }
//        return res;
//    }
//}
