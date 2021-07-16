// Time Complexity : O((n)),
// Space Complexity : O(n),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package strings3;

import java.util.*;

public class BasicCalculator_100 {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        s = s.trim();
        int res = 0, num = 0;
        char lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {
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

        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
