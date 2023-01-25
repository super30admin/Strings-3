import java.util.Stack;
//Time - O(n)
//Space  - O(1)

public class BasicCalculator2 {
	public int calculate(String s) {
		char[] arr = s.toCharArray();
		int curr = 0;
		int calc = 0;
		char lastSign = '+';
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (Character.isDigit(ch)) {
				curr = curr * 10 + ch - '0';
			}
			if (ch != ' ' && !Character.isDigit(ch) || i == arr.length - 1) {

				if (lastSign == '+') {
					stack.push(+curr);
				} else if (lastSign == '-') {
					stack.push(-curr);
				} else if (lastSign == '*') {
					stack.push(stack.pop() * curr);
				} else if (lastSign == '/') {
					stack.push(stack.pop() / curr);
				}
				curr = 0;
				lastSign = ch;
			}

		}
		while (!stack.isEmpty()) {
			calc += stack.pop();
		}

		return calc;
	}
}
