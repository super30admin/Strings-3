// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BasicCalculator {
            public int calculate(String s) {
            int curr = 0;
            int tail = 0;
            int cal = 0;
            int lastSign = '+';
            for (int i=0; i<s.length(); i++){
                int ch = s.charAt(i);
                if (Character.isDigit(ch)){
                    curr = curr*10 + ch - '0';
                } 
                if ((!Character.isDigit(ch) && ch != ' ' )|| i == s.length()-1){
                    if (lastSign == '+'){
                        cal = cal + curr;
                        tail = curr;
                    } else if (lastSign == '-'){
                        cal = cal - curr;
                        tail = -curr;
                    } else if (lastSign == '*'){
                        cal = cal - tail + (tail*curr);
                        tail = tail*curr;
                    } else if (lastSign == '/'){
                        cal = cal - tail + (tail/curr);
                        tail = tail/curr;
                    } 
                    curr = 0;
                    lastSign = ch;
                }
            }
            return cal;
        }
    }
