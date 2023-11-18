// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BasicCalciTwo {
    class Solution {
        public int calculate(String s) {
            int sLen = s.length();
            int result = 0;
            if(sLen == 0 || s == null) return result;

            int curr = 0;
            char op = '+';
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < sLen; i++){
                char c = s.charAt(i);
                if(Character.isDigit(c)){
                    curr = (curr * 10) + (c - '0');
                }

                if((c != ' ' && !Character.isDigit(c)) || i == sLen - 1){
                    if(op == '+'){
                        stack.push(curr);
                    }
                    else if(op == '-'){
                        stack.push(-curr);
                    }
                    else if(op == '*'){
                        stack.push(stack.pop() * curr);
                    }
                    else if(op == '/'){
                        stack.push(stack.pop() / curr);
                    }

                    op = c;
                    curr = 0;
                }
            }

            while(!stack.isEmpty()){
                result = result + stack.pop();
            }

            return result;
        }
    }
}
