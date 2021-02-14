// https://leetcode.com/problems/basic-calculator-ii/
// Time complexity : O(N)
// Space complexity : O(N)

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    stack.push(num);
                } else if (lastSign == '-') {
                    stack.push(-num);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }

                lastSign = c;
                num = 0;
            }
        }

        int res = 0;
        for (int r : stack)
            res += r;
        return res;
    }
}