class Solution {
    public int calculate(String s)
    {

        int res = 0, num = 0;

        char opr = '+';

        Stack<Integer> stack = new Stack<Integer>();

        for(char chr : (s + "+").toCharArray()) {

            if(chr == ' ') continue;

            if(Character.isDigit(chr)) num = num * 10 + (chr - '0');

            else {

            if(opr == '+') stack.push(num);

            else if(opr == '-') stack.push(-num);

            else if(opr == '*') stack.push(stack.pop() * num);

            else if(opr == '/') stack.push(stack.pop() / num);

            num = 0;

            opr = chr;

            }

        }

        while(!stack.isEmpty()) res += stack.pop();

        return res;
}}
