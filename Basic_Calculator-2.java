// Time Complexity : O(n), string length
// Space Complexity : O(n), string length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



class Solution {
    public int calculate(String s) {
        int result = 0; 
        //if string is empty or null, return result = 0
        if(s == null || s.length() == 0) return result;
        //remove all space 
        s = s.replaceAll("\\s","");
        //set default num = 0
        int num = 0;
        // and default sign as +
        char sign = '+';
        //create stack of integer to add num in the end add all the number
        Stack<Integer> st = new Stack<>();
        
        //iterate the string
        for(int i = 0; i < s.length(); i++) {
            //get curr char c
            char c = s.charAt(i);
            //it can either be a num or sign
            
            //if num
            if(Character.isDigit(c)) {
                //convert to int and calc num
                int curr = Character.getNumericValue(c);  
                num = num*10 + curr; 
            }
            
            //if c = operand
            // get (prev) sign and add the num to stack based on sign
            if(!Character.isDigit(c) || i == s.length()-1) {
                if(sign == '+') {
                    //if sign = +, add curr num to stack
                    st.push(num);
                }
                else if(sign == '-') {
                    //if sign = -, add -ve of num to stack
                    num = -num;
                    st.push(num);
                }
        
                else if(sign == '*') {
                    //if *,
                    //get prev added num and mul with curr num and add to stack
                    int temp = st.pop();
                    num = num*temp;
                    st.push(num);
                }
                else if(sign == '/') {
                    //if /
                    //get prev added num and div with curr num and add to stack
                    int temp = st.pop();
                    num = temp/num;
                    st.push(num);
                } 
                //update sign to c (curr sign)
                //and reset num = 0
                sign = c;
                num = 0; 
            }
        }
        
        //add all vals of stack
        while(!st.isEmpty()) {
            result += st.pop();
        }     
        return result;        
    }
}