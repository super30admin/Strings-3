//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    public int calculate(String s) {
        if(s ==  null || s.length() == 0)
            return 0;
        int num = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c!= ' ') || i == n-1){
                if(lastSign == '+')
                    stack.push(num);
                else if(lastSign == '-')
                    stack.push(-num);
                else if(lastSign == '*')
                    stack.push(stack.pop() * num);
                else if(lastSign == '/')
                    stack.push(stack.pop() / num);
                num = 0;
                lastSign = c;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }
}