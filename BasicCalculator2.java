// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        int size = s.length();
        char sign = '+';
        int num = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if(!Character.isDigit(ch) && ch != ' ' || i == size - 1){ // ch is  operator
                if(sign == '+'){
                    stack.push(num);
                } else if(sign == '-'){
                    stack.push((-1) * num);
                } else if(sign == '*'){
                    stack.push(stack.pop() * num);
                } else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        int returnVal = 0;
        while(!stack.isEmpty()){
            returnVal += stack.pop();
        }

        return returnVal;
    }
}
