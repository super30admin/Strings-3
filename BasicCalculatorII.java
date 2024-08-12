// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class BasicCalculator {
    public int calculate(String s) {

        int num = 0;
        char lastSign = '+';
        s.trim();
        int n = s.length();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // process if character is digit
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            // process if character is not a digit and it is not a space or if it is last character
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (lastSign == '+') {
                    stack.push(num);
                } else if (lastSign == '-') {
                    stack.push(-num);
                } else if (lastSign == '*') {
                    stack.push(stack.pop()*num);
                } else {
                    stack.push(stack.pop()/num);
                }
                num = 0;
                lastSign = c;
            }
        }
        int calculated = 0;
        while(!stack.isEmpty()) {
            calculated+= stack.pop();
        }
        return calculated;
    }
}