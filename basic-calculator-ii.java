/*
Time Complexity: O(length of given String)
Space Complexity: O(length of Stack)
*/


// Did this code successfully run on Leetcode :
YES
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach


class Solution {
    public int calculate(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        //define  a variable to hold current result
        int current = 0;
        //define a variable to hold current operator
        char operator = '+';
        
        //convert the s to char array
        char [] ch = s.toCharArray();
        
        for(int i = 0;i<ch.length;i++){
            //two cases can happen whether a character is digit or not a digit
            if(Character.isDigit(ch[i])){
                current = current*10 + ch[i] - '0';
            }
            if(!Character.isDigit(ch[i]) && ch[i] != ' ' || i == ch.length -1){
                //we will have 4 conditions here for 4 operators
                if(operator == '+'){
                  stack.push(current);  
                }else if(operator == '-'){
                  stack.push(-current);   
                }else if(operator == '*'){
                   stack.push(stack.pop() * current); 
                }else if(operator == '/'){
                   stack.push(stack.pop() / current);  
                }
                //update operator 
                operator = ch[i];
                //reset current
                current = 0;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        
        return sum;
    }
}