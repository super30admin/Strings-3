// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int calculate(String s) {
        
        if(s.length()==0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        char operation = '+';
        int currNum = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                currNum = currNum * 10 + ch - '0';
            
            if((!Character.isDigit(ch) && !Character.isSpace(ch)) || i == s.length()-1) {
                
                if(operation == '+')
                    stack.push(currNum);
                
                if(operation == '-')
                    stack.push(-currNum);
                
                if(operation == '*')
                    stack.push(stack.pop() * currNum);
                
                if(operation == '/')
                    stack.push(stack.pop() / currNum);
                
                currNum = 0;
                operation = ch;
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()) {
            res+=stack.pop();
        }
        
        return res;
    }
}
