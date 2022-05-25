public class Problem2 {

    //TC : O(n)
    //SC : O(1)
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        char lastSign = '+';
        int calc = 0;
        int tail = 0;
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                if (lastSign == '+') {
                    tail = curr;
                    calc = calc + curr;
                    curr = 0;
                } else if (lastSign == '-') {
                    tail = -curr;
                    calc = calc - curr;
                    curr = 0;
                } else if (lastSign == '*') {
                    calc = (calc - tail) + (tail * curr);
                    tail = tail * curr;
                    curr = 0;
                } else if (lastSign == '/') {
                    calc = (calc - tail) + (tail / curr);
                    tail = tail / curr;
                    curr = 0;
                }
                lastSign = c;
            }
        }
        return calc;
    }
    public static void main (String[] arg){
        Problem2 problem2 = new Problem2();
        int finalValue = problem2.calculate("3+2*2");
        System.out.println("Final value" + finalValue);
    }
}
