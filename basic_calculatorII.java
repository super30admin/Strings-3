// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) 
                sum = (sum * 10) + (ch - '0');
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == len - 1) {
                if (sign == '-') 
                    stack.push(-sum);    
                else if (sign == '+') 
                    stack.push(sum);
                else if (sign == '*') 
                    stack.push(stack.pop() * sum);
                else if (sign == '/') 
                    stack.push(stack.pop() / sum);
                sign = ch;
                sum = 0;}}
        int result = 0;
        while (!stack.isEmpty()) 
            result += stack.pop();
        
        return result;
    }
}
