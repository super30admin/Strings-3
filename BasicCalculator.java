//TC : O(n)
//SC : O(1)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int calc = 0, curr = 0,tail = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr*10 + Character.getNumericValue(c);
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if(lastSign == '+') {
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-') {
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*') {
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }
                else {
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = c;
            }
        }

        return calc; 
    }
}
