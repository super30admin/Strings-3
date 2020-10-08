// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using a stack and then ading at the end all elemets in  the stack
class Solution {
    public int calculate(String s){
        if(s==null || s.length()==0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char sign= '+';
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            
            if(!Character.isDigit(c) && c!=' ' || i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = c;
                num = 0;
            } 
        }
        int res =0;
        while(!stack.isEmpty()){
            res += stack.pop(); 
        }
        return res;
    }
}