
//TC - O(N)
//SC - O(N)
import java.util.*;

class Solution {
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		char lastSign = '+';
		int num = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
				if (lastSign == '+')
					stack.push(num);
				else if (lastSign == '-')
					stack.push(-num);
				else if (lastSign == '*')
					stack.push(stack.pop() * num);
				else
					stack.push(stack.pop() / num);
				num = 0;
				lastSign = c;
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}
}