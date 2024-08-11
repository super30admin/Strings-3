// TC - O(n), sc -O(1)
class Solution {
    public int calculate(String s) {
        int num = 0;
        int tail = 0;
        int cal = 0;
       
        s = s.trim();
         int n = s.length();
        char lastSign = '+';
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {
                if (lastSign == '+') {
                    cal += num;
                    tail = num;
                } else if (lastSign == '-') {
                    cal -= num;
                    tail = -num;
                } else if (lastSign == '*') {
                    cal = cal - tail + tail * num;
                    tail = tail * num;
                } else if (lastSign == '/') {
                    cal = cal - tail + tail / num;
                    tail = tail / num;
                }
                
                num = 0;
                lastSign = c;
            }
        }
        
        return cal;
    }
}
