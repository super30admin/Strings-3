package Strings3;

import java.util.Stack;

public class question100_BasicCalculator2 {
    /* Created by palak on 7/15/2021 */

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public static int calculate(String s) {
        //Edge
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s = s.trim();
        int result = 0;
        int num = 0;
        char lastSign = '+';
        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {
                if(lastSign == '+') stack.push(num);
                else if(lastSign == '-') stack.push(-num);
                else if(lastSign == '*') stack.push(stack.pop() * num);
                else stack.push(stack.pop() / num);
                lastSign = c;
                num = 0;
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public static int calculate1(String s) {
        //Edge
        if(s == null || s.length() == 0) return 0;

        s = s.trim();
        int result = 0;
        int num = 0;
        char lastSign = '+';
        int calculated = 0;
        int tail = 0;
        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {
                if(lastSign == '+') {
                    calculated = calculated + num;
                    tail = num;
                }
                else if(lastSign == '-') {
                    calculated = calculated - num;
                    tail = -num;
                }
                else if(lastSign == '*') {
                    calculated = calculated - tail + tail * num;
                    tail = tail * num;
                }
                else {
                    calculated = calculated - tail + tail / num;
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calculated;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));

        String s1 = " 3+5 / 2 ";
        System.out.println(calculate1(s1));
    }
}
