// Time Complexity: O(n)
//  Space Complexity: O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int curr = 0;
        char lastSign = '+';
        int open_brace = Integer.MAX_VALUE;
        int div = Integer.MIN_VALUE;
        s = s.trim();

        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
                if(i == s.length() - 1){
                    if(lastSign == '+') stack.push(curr);
                    else if(lastSign == '-') stack.push(-curr);
                    else if(lastSign == '*') stack.push(stack.pop() * curr);
                    else stack.push(stack.pop() / curr);
                }
            }
            else if(c == '('){
                if(lastSign == '+') stack.push(1);
                else if(lastSign == '-') stack.push(-1);
                else if(lastSign == '*') stack.push(null);
                else if(lastSign == '/') stack.push(div);
                stack.push(open_brace);
                lastSign = '+';
                curr = 0;
            }
            else if(c == ')'){
                if(lastSign == '+') stack.push(curr);
                else if(lastSign == '-') stack.push(-curr);
                else if(lastSign == '*') stack.push(stack.pop() * curr);
                else if(lastSign == '/') stack.push(stack.pop() / curr);
                int temp = 0;
                while(stack.peek() != open_brace){
                    temp += stack.pop();
                }
                stack.pop();
                if(stack.peek() == null){
                    stack.pop();
                    stack.push(stack.pop() * temp);
                }else if(stack.peek() == div){
                    stack.pop();
                    stack.push(stack.pop() / temp);
                }else {
                    stack.push(stack.pop() * temp);
                }
                lastSign = ' ';
                curr = 0;
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                if(lastSign == '+') stack.push(curr);
                else if(lastSign == '-') stack.push(-curr);
                else if(lastSign == '*') stack.push(stack.pop() * curr);
                else if(lastSign == '/') stack.push(stack.pop() / curr);
                lastSign = c;
                curr = 0;
            }
        }

        while(stack.size() != 0){
            result += stack.pop();
        }
        return result;
         
        
    }
}