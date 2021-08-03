// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<>();
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)){
                if(op == '+')
                    stack.push(num);
                else if(op == '-')
                    stack.push(num * -1);
                else if(op == '*')
                    stack.push(stack.pop() * num);
                else if(op == '/')
                    stack.push(stack.pop() / num);
                op = c;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}