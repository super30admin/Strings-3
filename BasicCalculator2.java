// Time Complexity : O(n). n is the length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        
        if(s==null || s.length()==0) return 0;
        
        int num=0;
        int operator='+';
        
            
        Stack<Integer>stack = new Stack();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                num = num*10+ch-'0';     
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                
                if(operator=='+') stack.push(num);
                else if(operator=='-') stack.push(-num);
                else if(operator=='*') stack.push(stack.pop()*num);
                else stack.push(stack.pop()/num);
                
                num=0;operator=ch;
                
            }
            
            
        }
        
        int result=0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        
        return result;
    }
}
