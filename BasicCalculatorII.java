// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int calculate(String s) {
        if(s == null || s == "") {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = (num*10) + (c - '0');
            }

            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1) {
                if(sign == '+') {
                    stack.push(num);
                } else if(sign == '-') {
                    stack.push((-1)*num);
                } else if(sign == '*') {
                    stack.push(stack.pop() * num);
                } else if(sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }

        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}