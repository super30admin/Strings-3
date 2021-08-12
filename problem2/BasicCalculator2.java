// Time Complexity : O(n), n -> Length of String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Stack;

public class BasicCalculator2 {
	/********************* USING STACK *********************/
	// Time Complexity : O(n), n -> Length of string
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int calculateUsingStack(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		char lastSign = '+';
		int num = 0;
		s = s.replace(" ", "") + '+';

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// Digit
			if (Character.isDigit(ch)) {
				num = num * 10 + ch - '0';
			}
			// Not a Digit or its last character
			else {
				if (lastSign == '+') {
					stack.push(num);
				} else if (lastSign == '-') {
					stack.push(-num);
				} else if (lastSign == '*') {
					stack.push(stack.pop() * num);
				} else {
					stack.push(stack.pop() / num);
				}
				num = 0;
				lastSign = ch;
			}
		}

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}

	/********************* OPTIMIZED SPACE *********************/
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		s = s.replace(" ", "") + '+';
		char lastSign = '+';
		int num = 0;
		int calc = 0;
		int tail = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				continue;
			}

			// Digit
			if (Character.isDigit(ch)) {
				num = num * 10 + ch - '0';
			}
			// Not a Digit or its last character
			else {
				if (lastSign == '+') {
					calc += num;
					tail = num;
				} else if (lastSign == '-') {
					calc -= num;
					tail = -num;
				} else if (lastSign == '*') {
					calc = calc - tail + tail * num;
					tail = tail * num;
				} else {
					calc = calc - tail + tail / num;
					tail = tail / num;
				}
				num = 0;
				lastSign = ch;
			}
		}

		return calc;
	}

	public static void main(String[] args) {
		BasicCalculator2 obj = new BasicCalculator2();
		String s = "3+2*2";
		System.out.println("Calculated value: " + obj.calculate(s));
	}

}
