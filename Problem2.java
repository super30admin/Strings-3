// Time Complexity : O(n) where n is the length of String s
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
  
    public int calculate(String s) {

        char sign = '+';
        int temp =0;
        Stack<Integer> stack = new Stack<>();
        int idx =0;

        while(idx < s.length()){
            Character current = s.charAt(idx);
            temp = 0;
            if(Character.isDigit(s.charAt(idx))){ // IF its a digit then the characters after it may be digits as well
                while(idx < s.length() && Character.isDigit(s.charAt(idx))){ // while it is getting digits keep on doing this
                temp = temp * 10 + Character.getNumericValue(s.charAt(idx));
                idx++;
                }
                // we will push this digit with respect to its sign in the stack 
                if(sign == '+'){
                    stack.push(temp);
                }
                else if(sign == '-'){
                    stack.push(-temp);
                }
                else if(sign == '/'){
                    stack.push(stack.pop() / temp );
                }else if(sign == '*'){
                    stack.push(stack.pop() * temp );
                }
                continue; // since idx has incremented , we will continue from here
            }
            else if(current == '+' || current == '-' || current == '/' || current == '*'){
                sign = current;
            }
            idx++;
        }

        int result = 0;
        // The stack currently contains the number wit their signs , all we need to do is , we need to add them all 
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
        
    }
}