

import java.util.Stack;

// Time Complexity : O(N) for Stack Approach
// Space Complexity :  O(N) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach


public class Calculator {
    public int calculate(String s) {
        if(s == null || s.length() == 0 || s.isEmpty()){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        int num =0;
        int size = s.length();
        for(int i =0; i < size; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            if(!(Character.isDigit(ch)  && ch != ' ') || i == size -  1){
                if(lastSign == '+'){
                    stack.push(num);
                }
                if(lastSign == '-'){
                    stack.push(-num);
                }
                if(lastSign == '*'){
                    stack.push(stack.pop() * num);
                }
                if(lastSign == '/'){
                    stack.push(stack.pop() / num);
                }
                lastSign = ch;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String args[]){
        String s = "3+2*2";

        Calculator calc = new Calculator();

        int res = calc.calculate(s);
        System.out.println("Result of " + s + " is: "+ res);
    }
}