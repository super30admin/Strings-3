/*
approach -1
using stack, to follow BODMAS rule
1. whenever found operator - push curr num and sign to Stack, reset them
2. when * found, pop from the tack, perform multiplication, push to stack
3. at last , whn reach to bound, pop everything, and sum up things
tc: O(n)
sc: O(n)
*/
class Solution {
    public int calculate(String s) {
        // base case
        int len = s.length();
        if (s == null || len == 0)
            return -1;

        int curr = 0, result = 0;
        char lastSign = '+';
        Stack<Integer> stack = new Stack<>();
        s.trim();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if (i == len - 1 || (!Character.isDigit(c) && c != ' '))// if we keep this elseif; last digit will never be
                                                                    // processed!, so just keep if!
            {
                // if characters found = +, -,*,/
                if (lastSign == '+') {
                    stack.push(curr);
                } else if (lastSign == '-') {
                    stack.push(-curr);
                } else if (lastSign == '*') {
                    int lastVal = stack.pop();
                    stack.push(lastVal * curr);
                } else if (lastSign == '/') {
                    int lastVal = stack.pop();
                    stack.push(lastVal / curr);
                }
                curr = 0;
                lastSign = c;
            }

        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;

    }
}

/*
 * approach-2
 * using tail approach like expression Add operator, to follow BODMAS rule
 * 1. whenever found * operator - update curr = (curr -tail) + (tail*curr); and
 * tail = tail*curr
 * for + curr is curr, tail is +curr
 * for - curr is -curr, tail is -curr
 * for /curr is +curr, tails is tail/curr
 * 3. at last return result
 * tc: O(n)
 * sc: O(1)
 */
class Solution {
    public int calculate(String s) {
        // base case
        int len = s.length();
        if (s == null || len == 0)
            return -1;

        int curr = 0, result = 0, tail = 0;
        char lastSign = '+';
        s.trim();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if (i == len - 1 || (!Character.isDigit(c) && c != ' '))// if we keep this elseif; last digit will never be
                                                                    // processed!, so just keep if!
            {
                // if characters found = +, -,*,/
                if (lastSign == '+') {
                    result += curr;
                    tail = +curr;
                } else if (lastSign == '-') {
                    result += -curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    result = (result - tail) + (curr * tail);
                    tail = tail * curr;
                } else if (lastSign == '/') {
                    result = (result - tail) + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = c;
            }
        }

        return result;

    }
}