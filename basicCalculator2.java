//TC - O(n)
//SC - O(n)
class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        Character lastOperation = '+';

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr * 10 + (ch - '0');
            }
            if((i==s.length()-1) || (!Character.isDigit(ch) && !Character.isWhitespace(ch))){
                if(lastOperation=='+'){
                    stack.push(curr);
                }
                else if(lastOperation=='-'){
                    stack.push(-curr);
                }
                else if(lastOperation=='/'){
                    stack.push(stack.pop()/curr);
                }
                else if(lastOperation=='*'){
                    stack.push(stack.pop()*curr);
                }
                lastOperation = ch==' ' ? lastOperation : ch;
                curr = 0;
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }
}