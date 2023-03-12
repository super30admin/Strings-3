import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Initially set current number to 0 and operation to +. Iterate over all chars
 * in the string. if it is a digit, append to current number else if it is an
 * operation, then check whatever operation it is. If +, then push the current
 * number to stack. If -, then push -number to stack. If *, pop peek element and
 * multiply it with current number and push it to stack. If /, pop the peek
 * element and divide it by current number and push it to stack. Once iterations
 * are done, add all numbers from the stack and return result.
 *
 */
class Solution {
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int current = 0;
		int operation = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				current = current * 10 + (c - '0');
			}
			if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1) {
				if (operation == '+') {
					stack.push(current);
				} else if (operation == '-') {
					stack.push(-current);
				} else if (operation == '*') {
					stack.push(stack.pop() * current);
				} else {
					stack.push(stack.pop() / current);
				}
				current = 0;
				operation = c;
			}
		}
		int ans = 0;
		while (!stack.isEmpty()) {
			ans += stack.pop();
		}
		return ans;
	}
}
