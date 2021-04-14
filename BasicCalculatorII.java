import java.util.Stack;
//tc : O(n + m); n = len of string; m = #operators, bcz that many times we are pushing into stack so at the end stack will have m numbers.
//sc : O(m)

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            if(c != ' ' && !Character.isDigit(c) || i == s.length() - 1){
                if(sign == '+') {
                    stack.push(num);
                }
                else if(sign == '-') {
                    stack.push(num * -1);
                }
                else if(sign == '*') {
                    int temp = stack.pop();
                    stack.push(temp * num);
                }
                else if(sign == '/') {
                    int temp = stack.pop();
                    stack.push(temp / num);
                }

                num = 0;
                sign = c;
            }

        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }
}
