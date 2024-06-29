// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/basic-calculator-ii/
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> stack= new Stack<>();
        int curr = 0;
        char lastSign ='+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10 + c-'0';
            }
            if(!Character.isDigit(c) && c!=' ' || i==s.length()-1){
                if(lastSign=='+'){
                    stack.push(curr);
                } else if(lastSign=='-'){
                    stack.push(-curr);
                }else if(lastSign=='*'){
                    stack.push(stack.pop()*curr);
                }else{
                    stack.push(stack.pop()/curr);
                } 
                curr = 0;
                lastSign = c;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
