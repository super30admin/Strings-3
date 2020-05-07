// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        char lastSign = '+';
        int num = 0;
        
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            if((!Character.isDigit(c) && c!=' ')||i==s.length()-1){
                if(lastSign=='+')
                    stack.push(num);
                else if(lastSign=='-')
                    stack.push(-num);
                else if(lastSign=='*')
                    stack.push(stack.pop()*num);
                else if(lastSign=='/')
                    stack.push(stack.pop()/num);
            
            lastSign = c;
            num=0;
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