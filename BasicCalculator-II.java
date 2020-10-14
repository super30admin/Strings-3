// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        
        //base case
        if(s == null || s.length() == 0)    return 0;
        
        Stack<Integer> stack = new Stack();
        int num = 0;
        //to store the previously seen operator
        char lastSign = '+';
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            //calculate num if the given number in that part of string is greater than 9
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            
            
            //check if the character is valid i.e. it should be a operator and not a whitespace, last operation should also be performed so we have checked whether we have reached the end of the string else we will miss that last operation
            if(!Character.isDigit(ch) && 
                ch != ' ' || i == s.length() - 1){
                
                if(lastSign == '+'){
                    stack.push(num);
                }else if(lastSign == '-'){
                    stack.push(-num);
                }else if (lastSign == '*'){
                    //perform multiplication with two numbers one from stack and the current num and push back to the stack
                    stack.push(stack.pop() * num);
                    
                }else if(lastSign == '/'){
                    //perform division with two numbers one from stack and the current num
                    stack.push(stack.pop() / num);
                    
                }
                
                num = 0;
                lastSign = ch;
                
            }
            
        }
        
        int output = 0;
        
        //perform addition operation of all the elements in the stack
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        
        return output;
        
    }
}
