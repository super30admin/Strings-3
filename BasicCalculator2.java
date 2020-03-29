// Time Complexity : O(n) n--> no. characters in string
// Space Complexity : O(n) stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// The main intuition here is that multiplication and division needs to be performed before any addition and subtraction.
// Also, the numbers can be prefixed with '+' and '-' for addition and subtractions.
// Whenever a sign is observed, the respective action is taken and the result is pushed onto stack.

class Solution {
    public int calculate(String s) {
        // edge case
        if(s == null || s.length() == 0) return 0;
        
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1) {
                if(sign == '+') {
                    stack.push(num);
                }
                else if(sign == '-') {
                    stack.push((-1)*num);
                }
                else if(sign == '*') {
                    stack.push(stack.pop()*num);
                }
                else if(sign == '/') {
                    stack.push(stack.pop()/num);
                }
                // reset num and sign
                num = 0;
                sign = ch;
            }
        }
        
        while(!stack.isEmpty()) {
            num += stack.pop();
        }
        return num;
    }
}

