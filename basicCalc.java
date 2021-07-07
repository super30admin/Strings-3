// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        char lastSign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char present = s.charAt(i);
            
            if(Character.isDigit(present)){
                num = num * 10 + (present - '0');
            }
            if((!Character.isDigit(present) && present != ' ') || i == s.length() - 1){
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
                lastSign = present;
                num = 0;
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        
        return sum;
    }
}