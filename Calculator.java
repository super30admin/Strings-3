//Time Complexity : O(n) //length of the string 
//Space Complexity :O(k) //k is number of numeric numbers n the string. stack size 
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

import java.util.Stack;

public class Calculator {
	public int calculate(String s) {
		s = s.trim();
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		char lastSymbol = '+';
		int curNum = 0;

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				curNum = curNum * 10 + (s.charAt(i) - '0');
			}

			if (s.charAt(i) != ' ' && (i == s.length() - 1 || !Character.isDigit(s.charAt(i)))) {
				if (lastSymbol == '+') {
					stack.push(curNum);
				} else if (lastSymbol == '-') {
					stack.push(-curNum);
				} else if (lastSymbol == '*') {
					stack.push(stack.pop() * curNum);
				} else if (lastSymbol == '/') {
					stack.push(stack.pop() / curNum);
				}
				curNum = 0;
				lastSymbol = s.charAt(i);
			}
		}

		while (!stack.isEmpty()) {
			result = result + stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Calculator().calculate("3+2*2"));
	}
}
