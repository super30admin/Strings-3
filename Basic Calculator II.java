// Time Complexity : O(N)
// Space Complexity : O(N) space for using stack
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


class Solution {
    public int calculate(String s) {
        if( s==null || s.length() ==0) return 0;
        Stack<Integer> stack=new Stack<Integer>();
       char sign='+';
        int value=0;
      int i=0;
            while(i<s.length()){
                char ch=s.charAt(i);
                if(Character.isDigit(ch)){
                   value =value * 10+ (ch -'0');   
                }
                if((!Character.isDigit(ch) && ch !=' ') ||  i==s.length() -1){
                    if(sign =='+'){
                        stack.push(value);
                    }
                    if(sign=='-'){
                        stack.push(-value);
                    }
                    if(sign=='*'){
                       stack.push(stack.pop()*value); 
                    }
                    if(sign=='/'){
                       stack.push(stack.pop()/value); 
                    }
                 value =0;
                sign=ch;
                }
               
                i++;
            }
        int res=0;
        while(!stack.isEmpty()){
            res=res+stack.pop();
        }
        return res;
    }
}