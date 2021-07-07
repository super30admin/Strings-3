// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int calculate(String s) {
        if(s == null || s.length()==0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        int i=0;
        char sign = '+';  //Store the sign before validating the next value.
        int val = 0;
        while(i< s.length()){
            
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                val = val*10 + ch - '0';
            }
            if((!Character.isDigit(ch) && ch !=' ' ||i == s.length()-1)){
                if(sign == '+')
                    stack.push(val);
                if(sign == '-')
                stack.push(-val);
                if(sign =='*')
                    stack.push(stack.pop() * val);
                if(sign == '/')
                     stack.push(stack.pop() / val);
               sign=ch;
                val =0;    
            }
            
             
            i++;
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
