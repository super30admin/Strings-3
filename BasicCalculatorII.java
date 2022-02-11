package strings3;

import java.util.Stack;

public class BasicCalculatorII {
	//Time Complexity : O(n), where n is the length of String s
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int calculate(String s) {
        int num = 0;
        char sign = '+';
        int tail = 0;
        int res = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + (c - '0');
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if(sign == '+') {
                    res += num;
                    tail = num;
                } else if(sign == '-') {
                    res -= num;
                    tail = -num;
                } else if(sign == '*') {
                    res = res - tail + (tail * num);
                    tail = num * tail;
                } else if(sign == '/') {
                    res = res - tail + (tail / num);
                    tail = tail / num;
                }
                num = 0;
                sign = c;
            } 
        }
        
        return res;
    }
	
	//Time Complexity : O(n), where n is the length of String s
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(s.charAt(i)))
                num = num * 10 + (c - '0');
                
            if((c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1)) {
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(stack.pop() * num);
                else if(sign == '/')
                    stack.push(stack.pop() / num);
                num = 0;
                sign = c;
            }
        }
        
        int calc = 0;
        while(!stack.isEmpty())
            calc += stack.pop();
        
        return calc;
    }
}
