//https://leetcode.com/problems/basic-calculator-ii/
/*
Time: O(n) where n=s.length()
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();

        int prevNum = 0;
        char prevSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                prevNum = prevNum * 10 + curr - '0'; // ascii val
            }

            if (!Character.isDigit(curr) && curr != ' ' || i == s.length() - 1) // enter only if curr is a sign
            {
                if (prevSign == '+') // push previously stored num
                    stack.push(prevNum);

                else if (prevSign == '-') // note we push to stack based on prevSign, not curr
                    stack.push(-prevNum);

                else if (prevSign == '/')
                    stack.push(stack.pop() / prevNum);

                else if (prevSign == '*')
                    stack.push(stack.pop() * prevNum);

                prevNum = 0; // reset num
                prevSign = curr; // update prevSign
            }

        }
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;

    }

}
