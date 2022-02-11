// Time Complexity : Add : O(n),
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "12-5+3*2+4/2";
        calculate(s);
    }

    public static int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;

        s= s.trim(); // trim front and end spaces

        int curr = 0;
        int calc = 0;
        int tail = 0;
        char lastSign = '+';

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                curr = curr*10 + c - '0'; //eg. 52, 12
            }

            if((!Character.isDigit(c) || i == s.length() - 1) && c != ' '){
                if(lastSign == '+'){ //+  // calculate through last sign, not current sign
                    calc = calc + curr;
                    tail = curr; // remeber last value

                } else if(lastSign == '-'){ //-
                    calc = calc - curr;
                    tail = -curr;

                } else if(lastSign == '*'){ //*
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                } else { // - /
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;
            }
        }

        return calc;
    }
}

