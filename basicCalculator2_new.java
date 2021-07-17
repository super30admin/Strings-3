package strings3;
//TC:o(n)
//SC:o(n)
public class basicCalculator2_new {
	public static int calculate1(String s) {
        //Edge
        if(s == null || s.length() == 0) return 0;

        s = s.trim();
        int result = 0;
        int num = 0;
        char lastSign = '+';
        int calculated = 0;
        int tail = 0;
        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {
                if(lastSign == '+') {
                    calculated = calculated + num;
                    tail = num;
                }
                else if(lastSign == '-') {
                    calculated = calculated - num;
                    tail = -num;
                }
                else if(lastSign == '*') {
                    calculated = calculated - tail + tail * num;
                    tail = tail * num;
                }
                else {
                    calculated = calculated - tail + tail / num;
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calculated;
    }
}
