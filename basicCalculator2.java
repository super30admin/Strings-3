// approch 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 using stack
    public static int calculate1(String s) {
        // stack for maintaing multipication and division
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        // if string has only one character return this number
        if (n == 1)
            return s.charAt(0) - '0';
        // intially number is 0 and lastSign is +
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // if char is calculate number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // System.out.println(lastSign);
            // if charcater is not number and it is not space
            // another edge case if it is last character that means we have to calculate
            // previous number
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                // if last sign is + push into stack
                if (lastSign == '+') {
                    stk.push(num);
                } else if (lastSign == '-') {
                    // if last sign is - push minus value into stack
                    stk.push(-num);
                } else if (lastSign == '*') {
                    // if last sign is * or / get last value from the stack multiply or divide with
                    // currentNum and
                    // push into stack
                    stk.push(stk.pop() * num);
                } else if (lastSign == '/') {
                    stk.push(stk.pop() / num);
                }
                // update last sign and reset currentNumber
                lastSign = c;
                num = 0;
            }
        }
        int result = 0;
        // sumup the value of the stack
        while (!stk.isEmpty()) {
            // System.out.println(stk.peek());
            result += stk.pop();
        }
        return result;

    }

    // approch 2 without using stack
    public static int calculate2(String s) {
        // to store tail value;
        int tail = 0;
        // to store current result
        int result = 0;
        // to store current Number
        int curNum = 0;
        // to store last sign
        char lastSign = '+';
        int n = s.length();
        // for loop for traverse
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // if character is num
            if (Character.isDigit(c)) {
                curNum = 10 * curNum + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                // if lastSign is + add into the result and set tail to current Number;
                if (lastSign == '+') {
                    result += curNum;
                    tail = curNum;
                } else if (lastSign == '-') {
                    // if lastSign is - substract it from the result and set tail to -1*currNum
                    result -= curNum;
                    tail = -curNum;
                } else if (lastSign == '*') {
                    // if lastSign is * result would be (result - tail) + (tail * curNum)
                    // make tail = tail * curNum
                    result = (result - tail) + (tail * curNum);
                    tail = tail * curNum;
                } else if (lastSign == '/') {
                    // if lastSign is / result would be (result - tail) + (tail / curNum)
                    // make tail = tail / curNum
                    result = (result - tail) + (tail / curNum);
                    tail = tail / curNum;
                }
                // reset curNum and update lastSign
                curNum = 0;
                lastSign = c;
            }
        }
        // return result
        return result;

    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate1(s));
        System.out.println(calculate2(s));

    }
}
