//Leetcode 224 - just has +- signs , while 772 has all the operators include. this code works fine in both. 
/*
 * TC: O(L) - 2 pass , one pass for trimming!
 * sc: O(L) - length of string!
 */

/*
Stack approach- 
1. when find operator, pus it to stack
2. when find open bracket -push sign to stack and then push null to represent bracket
3. when found * - push Integer.MAX_VALUE
*/

class Solution {
    public int calculate(String s) {

        int len = s.length();
        if (s == null || len == 0)
            return -1;

        int result = 0, curr = 0;
        char lastSign = '+';
        int k = 1;
        // int openBrace = null;

        Stack<Integer> stack = new Stack<>();

        // trim it
        s = s.trim(); // major mistake, always assign to s after trimming, else it will take old
                      // string only.
        len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int multiply = Integer.MAX_VALUE;
            int division = Integer.MIN_VALUE;

            // if character is a digit
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
                if (i == len - 1) {
                    if (lastSign == '+')
                        stack.push(curr);
                    else if (lastSign == '-')
                        stack.push(-curr);
                    else if (lastSign == '*')
                        stack.push(stack.pop() * curr);
                    else if (lastSign == '/')
                        stack.push(stack.pop() / curr);
                }
            } else if (c == '(') {

                if (lastSign == '+')
                    stack.push(+1);
                else if (lastSign == '-')
                    stack.push(-1);
                else if (lastSign == '*')
                    stack.push(multiply);
                else if (lastSign == '/')
                    stack.push(division);
                // pushed sign and now brace
                stack.push(null); // brace

                curr = 0;
                lastSign = '+';
            } else if (c == ')') // pop from the stack until found open bracket!
            {
                if (lastSign == '+')
                    stack.push(curr);
                else if (lastSign == '-')
                    stack.push(-curr);
                else if (lastSign == '*')
                    stack.push(stack.pop() * curr);
                else if (lastSign == '/')
                    stack.push(stack.pop() / curr);
                int intermediate = 0;

                while (stack.peek() != null) {
                    int val = stack.pop();
                    intermediate += val;
                }

                stack.pop();// pop the brace
                int tempSign = stack.pop();// we pushed sign and then openBrace as bracket
                if (tempSign == multiply) {
                    intermediate = intermediate * stack.pop();
                } else if (tempSign == division) {
                    intermediate = stack.pop() / intermediate;
                } else
                    intermediate *= tempSign;

                stack.push(intermediate);
                curr = 0;
                lastSign = ' ';
            }
            // if not a digit
            else if (c == '+' || c == '-' || c == '/' || c == '*') {
                if (lastSign == '+')
                    stack.push(+curr);
                else if (lastSign == '-')
                    stack.push(-curr);
                else if (lastSign == '*')
                    stack.push(stack.pop() * curr);
                else if (lastSign == '/')
                    stack.push(stack.pop() / curr);
                curr = 0;
                lastSign = c;
            }
        }
        while (!stack.isEmpty()) {
            int res = stack.pop();
            result += res;
        }
        return result;
    }
}