// Time Complexity : O(n), n -> Length of string
// Space Complexity : O(n)
class Solution {
    public int calculate(String s) {
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

}