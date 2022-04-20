// Time Complexity : O(N)
//N -> Length of Input String
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        
        char sign = '+';
        int curr = 0, tail = 0, cal = 0;
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){ 
                curr = curr * 10 + ch - '0';
            }
            if( (!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if(sign == '+'){
                    cal += curr;
                    tail = +curr;
                }else if(sign == '-'){
                    cal -= curr;
                    tail = -curr;
                }else if(sign == '*'){
                    cal = cal - tail + tail * curr;
                    tail = tail * curr;
                }else{
                    cal = cal - tail + tail / curr;
                    tail = tail / curr;
                }
                curr = 0;
                sign = ch;
            }
        }
        
        return cal;
    }
}


/*
// Time Complexity : O(N)
//N -> Length of Input String
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char sign = '+';
        int curr = 0;
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){ 
                curr = curr * 10 + ch - '0';
            }
            if( (!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(curr);
                }else if(sign == '-'){
                    stack.push(-curr);
                }else if(sign == '*'){
                    stack.push(stack.pop() * curr);
                }else{
                    stack.push(stack.pop() / curr);
                }
                curr = 0;
                sign = ch;
            }
        }
        
        
        //Add all elements from stack
        
        int data = 0;
        while(!stack.isEmpty()){
            data += stack.pop();
        }
        
        return data;
    }
}
*/