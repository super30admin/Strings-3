// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int num=0;
        char lastSign='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            
            if(c=='+' || c=='-' || c=='*' || c=='/' || i==s.length()-1){
                if(lastSign=='*'){
                    int prev=stack.pop();
                    stack.push(prev*num);
            }else if(lastSign=='/'){
                    int prev=stack.pop();
                    stack.push(prev/num);
            }else if(lastSign=='+'){
                stack.push(num);      
            }else if(lastSign=='-'){
                stack.push(-1*num); 
            }
                    num=0;
                lastSign=c;
        }
            
        }
        int result=0;
        
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        
        return result;
    }
}