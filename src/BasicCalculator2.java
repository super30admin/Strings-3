// TC : O(n)
// SC : O(1)
class BasicCalculator2 {
    public int calculate(String s) {
        s = s.trim();
        int n = s.length();
        int result = 0;
        int tail = 0;
        int curr = 0;
        char lastSign = '+';
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curr = curr*10 + ch-'0';
            }  
            if((!Character.isDigit(ch) && ch!= ' ') || i==n-1){
                if(lastSign == '+') {
                    result = result + curr;
                    tail = curr;
                }
                if(lastSign == '-') {
                    result = result - curr;
                    tail = -curr;
                }
                if(lastSign == '*') {
                    result = result - tail + tail*curr;
                    tail *= curr;
                }
                if(lastSign == '/') {
                    result = result - tail + tail/curr;
                    tail /= curr;
                }
                curr = 0;
                lastSign = ch;
            }
        }
        return result;
    }
}