//time o(n) , n is the length of a string
//space o(n), (stack space)
class Solution {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        
        //last sign
        char lastSign = '+';
        int num = 0;
        int i=0;
        
        while(i< len) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num*10 + ch-'0';
            }
            
            if((!Character.isDigit(ch) && ch != ' ') || i==len-1) {
                if(lastSign == '*') {
                    stack.push(stack.pop() * num);
                }
                else if(lastSign == '/') {
                    stack.push(stack.pop()/num);
                }
                else if(lastSign == '-') {
                    stack.push(-num);
                }
                else {
                    stack.push(num);
                }
                num =0;
                lastSign = ch;
            }
            i++;
        }
        
        int res=0;
        while(!stack.isEmpty()) {
            res = res + stack.pop();
        }
        return res;
    }
}