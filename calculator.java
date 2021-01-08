// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack();
        char currOp = ' ';
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ')
                continue;
            
            if(Character.isDigit(ch)) {
                int curr = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    curr = 10 * curr + Integer.parseInt(String.valueOf(s.charAt(i)));
                    i++;
                }
                i--;
                if(currOp == '-'){
                    curr = -1 * curr;
                    currOp = ' ';
                }
                if(currOp == '*'){
                    curr *= stack.pop();   
                    currOp = ' ';
                }
                if(currOp == '/'){
                    curr = stack.pop()/ curr;   
                    currOp = ' ';
                }
                stack.push(curr);
                
            }
            else if(ch == '+')
                continue;
            else if(ch == '-')
                currOp = '-';
            else if(ch == '*')
                currOp = '*';
            else if(ch == '/')
                currOp = '/';
            // System.out.println(stack);
        }
        
        int res = 0;
        
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}